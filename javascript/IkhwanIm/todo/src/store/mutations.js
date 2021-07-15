import {
    ADD_TODO
} from "./mutation-types";

// 여기는 동기 처리를 하기때문에 데이터 무결성이 보장됨
export default {
    [ADD_TODO] (state,payload) {
        const { content } = payload
        state.todoItems.push({ id: state.nextTodoId, content, done:false })
        state.nextTodoId++
    }
}