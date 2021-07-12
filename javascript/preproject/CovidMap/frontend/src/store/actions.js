import axios from 'axios'
import {
  SET_AUTH_TOKENS,
  DESTROY_AUTH_TOKEN,
  SET_LOGIN_INFO,
  DESTROY_LOGIN_INFO,
  SET_BOARD_LIST,
  SET_BOARD
} from '@/store/mutation-types.js'

import router from '@/router'

export default {
  signInAction: function ({ commit }, data) {
    // console.log('id : ' + data.id)
    // console.log('password : ' + data.password)

    axios.post('http://127.0.0.1:7777/api/authenticate', data).then(res => {
      if (res.status === 200) {
        const tokens = res.data.jwt
        // console.log('tokens : ' + tokens)
        commit(SET_AUTH_TOKENS, tokens)
        axios.get(`http://127.0.0.1:7777/member/getLoginInfo/${data.id}`).then(res => {
          if (res.status === 200 && res.data !== null) {
            commit(SET_LOGIN_INFO, res.data)
            // alert('로그인 성공')
            router.go(-1)
          } else {
            console.log('status : ' + res.status + ', data : ' + res.data)
            alert('아이디와 패스워드를 확인해 주세요')
          }
        }).catch(err => {
          console.log(err)
          alert('아이디와 패스워드를 확인해 주세요')
        })
      } else {
        console.log('status : ' + res.status + ', data : ' + res.data)
        alert('아이디와 패스워드를 확인해 주세요')
      }
    }).catch(err => {
      console.log(err)
      alert('아이디와 패스워드를 확인해 주세요')
    })
  },
  logoutAction: function ({ commit }) {
    commit(DESTROY_AUTH_TOKEN)
    commit(DESTROY_LOGIN_INFO)
  },
  getBoardListAction: function ({ commit }) {
    axios.get('http://127.0.0.1:7777/board').then(res => {
      commit(SET_BOARD_LIST, res.data)
    }).catch(err => {
      console.log(err)
    })
  },
  getBoardAction: function ({ commit }, boardNo) {
    axios.get(`http://127.0.0.1:7777/board/${boardNo}`).then(res => {
      if (res.status === 200) {
        commit(SET_BOARD, res.data)
      } else {
        console.log('status : ' + res.status + ', data : ' + res.data)
      }
    }).catch(err => {
      console.log(err)
    })
  }
}
