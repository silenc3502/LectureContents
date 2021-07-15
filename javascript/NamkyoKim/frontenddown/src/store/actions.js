import {
    // TODO
    ADD_TODO,
    REMOVE_TODO,
    EDIT_TODO,
    CLEAR_ALL,
    TOGGLE_TODO_STATUS,
    // 몬스터
    ADD_MONSTER,
    DEATH,
    // 스프링 랜덤 데이터 통신
    FAIL_GEN_RAND_NUM,
    SUCCESS_GEN_RAND_NUM
} from './mutation-types'

import axios from 'axios'

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
    clearAll (context) {
        context.commit(CLEAR_ALL)
    },
    toggleTodoStatus({ commit }, id){
        commit(TOGGLE_TODO_STATUS, id)
    },
    // 판타지 온라인
    addMonster (context, payload) {
        context.commit(ADD_MONSTER, payload)
    },
    death ({ commit }, payload) {
        commit(DEATH, payload)
    },
    // Spring과 랜덤 데이터 통신
    generateRandomNumber ({ commit }){
        console.log(commit)

        axios.get('http://localhost:7777/random')
         .then((res) => {
            commit(SUCCESS_GEN_RAND_NUM, parseInt(res.data.randNumber))
        })
        .catch((res) => {
            commit(FAIL_GEN_RAND_NUM, res)
        })
    }
}
