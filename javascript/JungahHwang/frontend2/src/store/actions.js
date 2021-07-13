// 비동기 처리하는 것은 모두 actions에서 처리
// (비동기 처리(action) <-> 동기 처리(mutation))

import {
  ADD_TODO,
  REMOVE_TODO,
  EDIT_TODO
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
  },
  // context로 받으면 context.commit으로 작성
  removeTodo (context, payload) {
    context.commit(REMOVE_TODO, payload)
  },
  // commit으로 바로 받으려면 {객체}로 받고 commit 작성
  editTodo ({ commit }, payload) {
    commit(EDIT_TODO, payload)
  }
}