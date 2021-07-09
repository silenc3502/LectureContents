import {
  SET_AUTH_TOKEN,
  SET_AUTH_TOKENS,
  DESTROY_AUTH_TOKEN,
  SET_LOGIN_INFO,
  DESTROY_LOGIN_INFO,
  SET_BOARD_LIST,
  SET_BOARD,
  SET_MAP,
  SET_CENTER_MARKER,
  SET_MARKERS,
  SET_CIRCLE,
  SET_LOGIN_LOACTION_XY
} from '@/store/mutation-types.js'

import axios from 'axios'
import cookies from 'vue-cookies'

export default {
  [SET_AUTH_TOKENS] (state, tokens) {
    // console.log('SET_AUTH_TOKENS')
    axios.defaults.headers.common.Authorization = `Bearer ${tokens.access_token}`
    cookies.set('jwt', tokens.access_token, '30m')
    cookies.set('refresh', tokens.refresh_token, (24 * 14) + 'h')
  },
  [SET_AUTH_TOKEN] (state, token) {
    // console.log('SET_AUTH_TOKEN')
    axios.defaults.headers.common.Authorization = `Bearer ${token}`
    cookies.set('jwt', token, '30m')
  },
  [DESTROY_AUTH_TOKEN] () {
    delete axios.defaults.headers.common.Authorization
    cookies.remove('jwt')
    cookies.remove('refresh')
  },
  [SET_LOGIN_INFO] (state, data) {
    // console.log('SET_LOGIN_INFO')
    state.isLogin = true
    state.loginInfo = data
    cookies.set('usuerid', data.id, '1h')
  },
  [DESTROY_LOGIN_INFO] (state) {
    state.isLogin = false
    state.loginInfo = null
  },
  [SET_BOARD_LIST] (state, data) {
    state.boardList = data
  },
  [SET_BOARD] (state, data) {
    state.board = data
  },
  [SET_MAP] (state, map) {
    state.map = map
  },
  [SET_CENTER_MARKER] (state, marker) {
    state.centerMarker = marker
  },
  [SET_MARKERS] (state, markers) {
    state.markers = markers
  },
  [SET_CIRCLE] (state, circle) {
    state.circle = circle
  },
  [SET_LOGIN_LOACTION_XY] (state, data) {
    if (state.loginInfo != null) {
      state.loginInfo.positionX = data.x
      state.loginInfo.positionY = data.y
    }
  }
}
