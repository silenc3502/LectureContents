import{
  ADD_TODO
} from './mutation-types'

export default {
  // context 자바스크립트 내에서 동작하는 일련의 흐름
  // 보통 action에서 처리하는 것은 비동기 처리를 함

  //commit을 하면 mutation을 넘어감
  addTodo (context, payload) {
    context.commit(ADD_TODO, payload)
  },
  save ({ state }) {
    const data = {
      todoItems: state.todoItems,
      nextTodoId: state.nextTodoId
    }
    //db대신 임시적으로 사용하고 있음 (데이터를 저장) key,value값과 비슷한 역할 
    localStorage.setItem('todo-app-data', JSON.stringify(data))
  }
}