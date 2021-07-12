// 동기 처리를 하기 때문에 데이터 무결성이 보장

import {
  ADD_TODO
} from './mutation-types'

export default {
  [ADD_TODO] (state, payload) {
    const { content } = payload
    // false: todo를 실행하지 않았으므로 초기값은 false, todo를 하고 체크하면 true가 되도록
    // 받은 값을 todoItem에 저장
    state.todoItems.push({ id: state.nextTodoId, content, done: false })
    state.nextTodoId++
  }
}