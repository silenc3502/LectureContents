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