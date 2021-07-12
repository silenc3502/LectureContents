export default {
  getIsLogin (state) {
    return state.isLogin
  },
  getLoginInfo (state) {
    return state.loginInfo
  },
  getLoginId (state) {
    if (state.loginInfo != null) {
      return state.loginInfo.id
    }

    return null
  },
  getBoardList (state) {
    return state.boardList
  },
  getBoardTitle (state) {
    if (state.board !== null) {
      return state.board.title
    }

    return ''
  },
  getBoardContents (state) {
    if (state.board !== null) {
      return state.board.contents
    }

    return ''
  },
  getSameUser (state) {
    if (state.board === null || state.loginInfo === null) {
      return false
    }
    return state.board.writer === state.loginInfo.nickName
  }
}
