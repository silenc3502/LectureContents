import {
    ADD_TODO,
    EDIT_TODO,
    REMOVE_TODO,
    SET_EDITTING_ID,
    RESET_EDITTING_ID,

    KILL_MONSTER,
    ADD_MONSTER,
    EDIT_NAME

} from './mutation-types'

export default {
    [ADD_TODO] (state, payload) {
        const { content } = payload
        state.todoItems.push({ id: state.nextTodoId, content, done: false })
        state.nextTodoId++
    },
    [REMOVE_TODO] (state, id) {
        const targetIndex = state.todoItems.findIndex(v => v.id === id)
        state.todoItems.splice(targetIndex, 1)
    },
    [EDIT_TODO] (state, payload) {
        const { id, content } = payload
        //payload는 바뀐 id와 content값을 모두 가진 todoItem객체인가??
        const targetIndex = state.todoItems.findIndex(v => v.id === id)
        const targetTodoItem = state.todoItems[targetIndex]
        state.todoItems.splice(targetIndex, 1, { ...targetTodoItem, content })
        //targetIndex번호의 항을 하나 지우고 targetTodoItem을 밀어내고 content를 그 항에 넣는다.. 맞나?
    },
    [SET_EDITTING_ID] (state, id) {
        state.editingId = id
    },
    [RESET_EDITTING_ID] (state) {
        state.editingId = 0
    },
    [ADD_MONSTER] (state, payload) {
        const { name } = payload
        state.monsterElements.push({ monsterId: state.nextMonsterId, name })
        state.nextMonsterId++
    },
    [KILL_MONSTER] (state, monsterId) {
        const targetIndex = state.monsterElements.findIndex(v => v.monsterId === monsterId)
        state.monsterElements.splice(targetIndex, 1)
        //그냥 state.monsterElements.splice(monsterId, 1) 이렇게 하면 안되나? 왜 위의 방식으로 해야하나요?
    },
    [EDIT_NAME] (state, payload) {
        const { monsterId, content } = payload
        const targetIndex = state.monsterElements.findIndex(v => v.monsterId === monsterId)
        const targetMonsterElem = state.monsterElements[targetIndex]
        state.monsterElements.splice(targetIndex, 1, { ...targetMonsterElem, content })
    }
}

//action에 있는 것들은 비동기처리 - 대충 보여져도 된다면 action에
//mutation에 있는 것들은 동기처리 - 무결성이 중요하다면 mutation에