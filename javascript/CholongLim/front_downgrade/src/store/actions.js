import {
  ADD_TODO
} from './mutation-types'

// 보통 action에서 처리하는 것은 비동기 처리를 함
export default {
  addTodo (context, payload) {
    context.commit(ADD_TODO, payload)
  },
  save ({ state }) {
    const data = {
      todoItems: state.todoItems,
      nextTodoId: state.nextTodoId
    }
    localStorage.setItem('todo-app-data', JSON.stringify(data))
  }
}