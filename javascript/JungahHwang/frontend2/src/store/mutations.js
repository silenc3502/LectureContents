// mutation: 동기 처리를 하기 때문에 데이터 무결성이 보장

import {
  // Todo
  ADD_TODO,
  REMOVE_TODO,
  EDIT_TODO,
  SET_EDITING_ID,
  RESET_EDITING_ID,

  // Monster
  ADD_MONSTER,
  DEATH
} from './mutation-types'

export default {
  [ADD_TODO] (state, payload) {
    const { content } = payload
    // false: todo를 실행하지 않았으므로 초기값은 false, todo를 하고 체크하면 true가 되도록
    // 받은 값을 todoItem에 저장
    state.todoItems.push({ id: state.nextTodoId, content, done: false })
    state.nextTodoId++
  },
  [REMOVE_TODO] (state, id) {
    const targetIndex = state.todoItems.findIndex(v => v.id === id)
    state.todoItems.splice(targetIndex, 1)
  },
  [EDIT_TODO] (state, payload) {
    const { id, content } = payload
    const targetIndex = state.todoItems.findIndex(v => v.id === id)
    const targetTodoItem = state.todoItems[targetIndex]
    state.todoItems.splice(targetIndex, 1, {...targetTodoItem, content})
  },
  [SET_EDITING_ID] (state, id) {
    state.editingId = id
  },
  [RESET_EDITING_ID] (state) {
    state.editingId = 0
  },

  // Monster
  [ADD_MONSTER] (state, payload) {
    const { name } = payload
    state.monsterElements.push({ monsterId: state.nextMonsterId, name })
    state.nextMonsterId++
  },
  [DEATH] (state, monsterId) {
    const targetIndex = state.monsterElements.findIndex(v => v.monsterId === monsterId)
    state.monsterElements.splice(targetIndex, 1)
  }
}