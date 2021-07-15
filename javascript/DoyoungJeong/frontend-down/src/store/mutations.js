import {
    ADD_TODO,
    EDIT_TODO,
    REMOVE_TODO,
    SET_EDITTING_ID,
    RESET_EDITTING_ID,
    CLEAR_ALL,
    TOGGLE_TODO_STATUS,

    KILL_MONSTER,
    ADD_MONSTER,
    EDIT_NAME,

    SUCCESS_GEN_RAN_NUM,
    FAIL_GEN_RAN_NUM
} from './mutation-types'

export default {
    [ADD_TODO] (state, payload) {
        const { content } = payload
        state.todoItems.push({ id: state.nextTodoId, content, done: false })
        state.nextTodoId++
    },
    [REMOVE_TODO] (state, id) {
        const targetIndex = state.todoItems.findIndex(v => v.id === id)
        //인자로 받은 id값과 todoItems에서 같은 id값을 가진 index 순서를 찾는다.

        //state.todoItems.splice(id-1, 1) --> 이 방식은 안됨 왜 안될까?
        //안될 수밖에 없다. todoItems에서 splice를 하면 index번호가 서로 바뀌기 때문에 id-1로 없애고자 하는 대상이 splice(id-1, 1)과 겹치지 않는다.
        state.todoItems.splice(targetIndex, 1)
    },
    [EDIT_TODO] (state, payload) {
        const { id, content } = payload
        //payload는 바뀐 id와 content값을 모두 가진 todoItem객체인가?? --> 객체로 받을 때는 payload를 쓰는것같다.
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
    [CLEAR_ALL] (state) {
        state.todoItems = []
    },
    [TOGGLE_TODO_STATUS] (state, id) {
        const filtered = state.todoItems.filter(todoItem => {
            return todoItem.id === id 
        })
        //인자 id값과 같은 id를 return 후,
        //todoItems배열에서 인자 id로 들어온 값만큼의 인덱스 값을가진(리턴된 값의) todoItem을 구한다.

        console.log('filtered: ' + JSON.stringify(filtered))

        filtered.forEach(todoItem => {
            todoItem.done = !todoItem.done
        })
    },


    [ADD_MONSTER] (state, payload) {
        const { name } = payload
        state.monsterElements.push({ monsterId: state.nextMonsterId, name })
        state.nextMonsterId++
    },
    [KILL_MONSTER] (state, monsterId) {
        const targetIndex = state.monsterElements.findIndex(v => v.monsterId === monsterId)
        state.monsterElements.splice(targetIndex, 1)
    },
    [EDIT_NAME] (state, payload) {
        const { monsterId, content } = payload
        const targetIndex = state.monsterElements.findIndex(v => v.monsterId === monsterId)
        const targetMonsterElem = state.monsterElements[targetIndex]
        state.monsterElements.splice(targetIndex, 1, { ...targetMonsterElem, content })
    },

    [SUCCESS_GEN_RAN_NUM] (state, payload) {
        console.log('payload = ' + payload)
        state.randomFromSpring = payload
    },
    [FAIL_GEN_RAN_NUM] () {
        console.log('Connection ERROR!')
    }

}

//action에 있는 것들은 비동기처리 - 대충 보여져도 된다면 action에
//mutation에 있는 것들은 동기처리 - 무결성이 중요하다면 mutation에