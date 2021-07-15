import {
    ADD_TODO,
    REMOVE_TODO,
    EDIT_TODO,
    TOGGLE_TODO_STATUS,

    KILL_MONSTER,
    ADD_MONSTER,
    EDIT_NAME,
    CLEAR_ALL,
    SUCCESS_GEN_RAN_NUM,
    FAIL_GEN_RAN_NUM
} from './mutation-types'

import axios from 'axios'

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
    //밑의 메소드 작성 형식 2개 아무거나 사용하면 된다.
    
    removeTodo (context, payload) {
        context.commit(REMOVE_TODO, payload)
    },
    editTodo ({ commit }, payload) {
        commit(EDIT_TODO, payload)
    },
    toggleTodoStatus ({ commit }, payload) {
        commit(TOGGLE_TODO_STATUS, payload) //payload -> id
    },
    
    generateRandomNumber ({ commit }) {
        console.log(commit)

        axios.get('http://localhost:7777/random')
            .then((res) => {
                commit(SUCCESS_GEN_RAN_NUM, parseInt(res.data.ranNumber))
                //localhost:7777에서 받은 ranNumber값을 int로 변환해 mutation에 있는 SUCCESS_GEN으로 넘긴다.
            })
            .catch((res) => {
                commit(FAIL_GEN_RAN_NUM, res)
            })
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
    clearAll(context) {
        context.commit(CLEAR_ALL)
    }
}

//action에 있는 것들은 비동기처리 - 대충 보여져도 된다면 action에
//mutation에 있는 것들은 동기처리 - 무결성이 중요하다면 mutation에