// 비동기 처리하는 것은 모두 actions에서 처리
// (비동기 처리 <-> 동기 처리)

import {
  ADD_TODO
} from './mutation-types'

export default {
  // context: 자바스크립트에서 사용하는 일련의 동작 흐름
  // payload: todoItem(웹에서 입력한 데이터)
  addTodo (context, payload) {
    // commit: 동기처리를 위해 mutations로 넘김
    context.commit(ADD_TODO, payload)
  },
  save ({ state }) {
    const data = {
      todoItems: state.todoItems,
      nextTodoId: state.nextTodoId
    }
    // lacalStrorage: DB대신 임시로 로컬스토리지를 사용하여 'todo-app-data'라는 키값에 데이터 저장
    localStorage.setItem('todo-app-data', JSON.stringify(data))
  }
}