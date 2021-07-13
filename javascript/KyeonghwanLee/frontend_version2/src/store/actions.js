import {
    ADD_TODO
} from './mutation-types'

// 보통 action에서 처리하는 것은 비동기 처리를 함 
// payload는 todoItem(todo.vue에있는거) 즉 창에입력하는값

export default {
    addTodo (context, payload) {
        context.commit(ADD_TODO, payload)
    },
    save ({ state }) {
        const data = {
            todoItems: state.todoItems,
            nextTodoId: state.nextTodoId
        }
        //localStroage는 DB 대신 임시적으로 사용하고 있음
        //todo-app-data키값, JSON.stringify(data)밸류값
        localStorage.setItem('todo-app-data', JSON.stringify(data))
    }
}


