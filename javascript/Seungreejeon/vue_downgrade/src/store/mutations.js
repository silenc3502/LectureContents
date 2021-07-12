import {
    ADD_TODO
} from './mutation-types'

export default {
    [ADD_TODO] (state, payload) {
        const { content } = payload
        state.todoItems.push({ id: state.nextTodoId, content, done: false })
        state.nextTodoId++
    }
}


// 여기는 동기 처리를 하기 때문에 데이터 무결성을 함