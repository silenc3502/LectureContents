import {
    // TODO
    ADD_TODO,
    REMOVE_TODO,
    EDIT_TODO,
    // 몬스터
    ADD_MONSTER,
    DEATH
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

        // DB 대신 임시적으로 사용하고 있음
        localStorage.setItem('todo-app-data', JSON.stringify(data))
    },
    removeTodo (context, payload) {
        context.commit(REMOVE_TODO, payload)
    },
    editTodo ({ commit }, payload) {
        commit(EDIT_TODO, payload)
    },
    addMonster (context, payload) {
        context.commit(ADD_MONSTER, payload)
    },
    death ({ commit }, payload) {
        commit(DEATH, payload)
    }
}