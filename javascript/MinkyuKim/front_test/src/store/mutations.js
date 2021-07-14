import {
    // TODO
    ADD_TODO,
    EDIT_TODO,
    REMOVE_TODO,
    SET_EDITTING_ID,
    RESET_EDITTING_ID,
    // 몬스터
    ADD_MONSTER,
    DEATH
} from './mutation-types'

// 여기는 동기 처리를 하기 때문에 데이터 무결성이 보장됨
export default {
    [ADD_TODO] (state, payload) {
        const { content } = payload
        //state.js 상에서 입력이 될때마다 id값이 하나씩 증가하게 되어있음
        state.todoItems.push({ id: state.nextTodoId, content, done: false })
        // 사용자가 입력한 내용 콘솔창에서 확인가능
        state.nextTodoId++
    },
    [REMOVE_TODO] (state, id) {
        // 현재 요청들어온 id값을 찾는다.
        const targetIndex = state.todoItems.findIndex(v => v.id === id)
        // 찾아낸 id값을 삭제시킨다.
        state.todoItems.splice(targetIndex, 1)
    },
    [EDIT_TODO] (state, payload) {
        const { id, content } = payload
        const targetIndex = state.todoItems.findIndex(v => v.id === id)
        const targetTodoItem = state.todoItems[targetIndex]
        // ...은 뒤에있는거 마져 붙인다는 의미. 따라서 splice에서 빼진만큼 content가 채워짐
        state.todoItems.splice(targetIndex, 1, { ...targetTodoItem, content })
    },
    [SET_EDITTING_ID] (state, id) {
        state.editingId = id
    },
    [RESET_EDITTING_ID] (state) {
        state.editingId = 0
    },
    [ADD_MONSTER] (state, payload) {
        const { name } = payload
        // push에 monsterId이므로 맞춰줘야함.
        state.monsterElements.push({ monsterId: state.nextMonsterId, name })
        state.nextMonsterId++
    },
    [DEATH] (state, monsterId) {
        const targetIndex = state.monsterElements.findIndex(v => v.monsterId === monsterId)
        state.monsterElements.splice(targetIndex, 1)
    }
}