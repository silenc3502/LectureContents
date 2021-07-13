import {
    ADD_TODO
} from './mutation-types'

export default {
    addTodo (context, payload) { //payload는 todoItem, context는 별로 중요하진 않다.
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