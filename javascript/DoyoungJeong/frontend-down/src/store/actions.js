import {
    ADD_TODO,
    REMOVE_TODO,
    EDIT_TODO,

    KILL_MONSTER,
    ADD_MONSTER,
    EDIT_NAME
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
    },
    removeTodo (context, payload) {
        context.commit(REMOVE_TODO, payload)
    },
    editTodo ({ commit }, payload) {
        commit(EDIT_TODO, payload)
    },
    addMonster ({ commit }, payload) {
        commit(ADD_MONSTER, payload)
    },
    killMonster ({ commit }, payload) {
        commit(KILL_MONSTER, payload)
    },
    editName ({ commit }, payload) {
        commit(EDIT_NAME, payload)
    },
}

//action에 있는 것들은 비동기처리 - 대충 보여져도 된다면 action에
//mutation에 있는 것들은 동기처리 - 무결성이 중요하다면 mutation에