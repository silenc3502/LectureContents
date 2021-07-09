import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import cookies from 'vue-cookies'
import vuex from 'vuex'

import {
  SET_AUTH_TOKEN,
  SET_LOGIN_INFO
} from '@/store/mutation-types.js'

import axios from 'axios'
import decode from 'jwt-decode'

Vue.use(cookies)
Vue.use(vuex)

Vue.config.productionTip = false

axios.interceptors.request.use(function (config) {
  // console.log('request interceptors')
  if (cookies.isKey('jwt') && cookies.isKey('refresh') && config.url !== 'http://kainTime.iptime.org:7777/api/refreshToken') {
    const accessToken = cookies.get('jwt')
    const { exp } = decode(accessToken)
    if (Date.now() >= exp * 1000) {
      const refreshToken = cookies.get('refresh')
      // console.log('before access token : ' + axios.defaults.headers.common.Authorization)
      axios.defaults.headers.common.Authorization = `Bearer ${refreshToken}`
      axios.post('http://kainTime.iptime.org:7777/api/refreshToken').then(res => {
        if (res.status === 200) {
          // console.log('after access token : ' + res.data.jwt.access_token)
          const token = res.data.jwt.access_token
          store.commit(SET_AUTH_TOKEN, token)
        } else {
          console.log('status : ' + res.status + ', data : ' + res.data)
          alert('Token 갱신 실패')
        }
      }).catch(err => {
        console.log(err)
      })
    }
  }
  return config
}, function (err) {
  console.log(err)
  return Promise.reject(err)
})

function init () {
  if (cookies.isKey('jwt') && cookies.isKey('usuerid')) {
    const accessToken = cookies.get('jwt')
    const usuerid = cookies.get('usuerid')
    store.commit(SET_AUTH_TOKEN, accessToken)
    axios.get(`http://kainTime.iptime.org:7777/member/getLoginInfo/${usuerid}`).then(res => {
      if (res.status === 200 && res.data !== null) {
        store.commit(SET_LOGIN_INFO, res.data)
        // alert('로그인 성공')
      } else {
        console.log('status : ' + res.status + ', data : ' + res.data)
        // alert('로그인 실패')
      }
    }).catch(err => {
      console.log(err)
      // alert('로그인 실패')
    })
  }
  return Promise.resolve()
}

init().then(() => {
  new Vue({
    router,
    store,
    vuetify,
    render: h => h(App)
  }).$mount('#app')
})
