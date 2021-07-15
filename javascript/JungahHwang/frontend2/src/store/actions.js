// 비동기 처리하는 것은 모두 actions에서 처리
// (비동기 처리(action) <-> 동기 처리(mutation))

import {
// Todo
  ADD_TODO,
  REMOVE_TODO,
  EDIT_TODO,
  CLEAR_ALL,
  TOGGLE_TODO_STATUS,

// Monster
  ADD_MONSTER,
  DEATH,
  ADD_MANY_MONSTER,

// Spring
  SUCCESS_GEN_RAND_NUM,
  FAIL_GEN_RAND_NUM
} from './mutation-types'

import axios from 'axios'

export default {
// Todo
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
  },
  // commit하면 mutation이 동작
  clearAll (context) {
    context.commit(CLEAR_ALL)
  },
  toggleTodoStatus ({ commit }, id) {
    commit(TOGGLE_TODO_STATUS, id)
  },

// Monster
  addMonster (context, payload) {
    context.commit(ADD_MONSTER, payload)
  },
  death ({ commit }, payload) {
    commit(DEATH, payload)
  },
  addManyMonster (context, payload) {
    context.commit(ADD_MANY_MONSTER, payload)
  },

// spring과 랜덤 데이터 통신
  generateRandomNumber ({ commit }) {
    
    // axios.get: GET 요청
    // axios.post: POST 요청
    // 특정 URL로 GET 혹은 POST, 그 외의 요청을 보낼 수 있음
    // .then((res)): 데이터를 수신 (응답받은 데이터는 res가 가지고 있음)
    // .catch((res)): 오류가 발생한 경우
    // randNumber는 spring에 있는 변수
    axios.get('http://localhost:7777/random').then((res) => {
      commit(SUCCESS_GEN_RAND_NUM, parseInt(res.data.randNumber))
    }).catch((res) => {
      commit(FAIL_GEN_RAND_NUM, res)
    })
  }
}