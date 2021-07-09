import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '@/store'

import Index from '@/views/Index.vue'

import SignIn from '@/views/member/SignIn.vue'
import SignUp from '@/views/member/SignUp.vue'

import Board from '@/views/boards/Board.vue'
import BoardWrite from '@/views/boards/BoardWrite.vue'
import BoardRead from '@/views/boards/BoardRead.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    component: Index
  },
  {
    path: '/member/signIn',
    name: 'SignIn',
    component: SignIn
  },
  {
    path: '/member/signUp',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/board',
    name: 'BoardMain',
    component: Board
  },
  {
    path: '/board/write',
    name: 'BoardWrite',
    component: BoardWrite,
    beforeEnter (to, from, next) {
      var loginInfo = store.getters.getLoginInfo
      var isLogin = store.getters.getIsLogin
      if (loginInfo !== null && isLogin) {
        next()
      } else {
        alert('Login이 필요한 기능입니다.')
        next({ name: 'SignIn' })
      }
    },
    beforeRouteLeave (to, from, next) {
      var loginInfo = store.getters.getLoginInfo
      var isLogin = store.getters.getIsLogin
      if (loginInfo !== null && isLogin) {
        next()
      } else {
        alert('Login이 필요한 기능입니다.')
        next({ name: 'SignIn' })
      }
    }
  },
  {
    path: '/board/view/:boardNo',
    name: 'BoardRead',
    components: {
      default: BoardRead
    },
    props: {
      default: true
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
