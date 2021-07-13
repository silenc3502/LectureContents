import {
    ADD_TODO
} from './mutation-types'

// 보통 action에서 처리하는 것은 비동기 처리를 함
export default {
    // context는 동작의 흐름이라고 간단하게 생각하면 됨
    addTodo (context, payload) {
        context.commit(ADD_TODO, payload)
    },
    save ({ state }) {
        // 콘스트는 변수인데 자바에 final과 동일 즉, 값을 바꾸고 싶지 않을 때 사용한다.
        const data = {
            todoItems: state.todoItems,
            nextTodoId: state.nextTodoId
        }

        // DB 대신 임시적으로 사용하고 있음
        // 'todo-app-data'는 키값으로 생각하면 됨
        localStorage.setItem('todo-app-data', JSON.stringify(data))
    }
}