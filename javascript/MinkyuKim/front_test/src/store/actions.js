import {
    // TODO
    ADD_TODO,
    REMOVE_TODO,
    EDIT_TODO,
    // 몬스터
    ADD_MONSTER,
    DEATH
} from './mutation-types'

// 보통 action에서 처리하는 것은 비동기 처리를 함
export default {
    // 여기있는 payload는 Todo.vue의 this.addTodo(todoItem)  todoItem이다
    addTodo (context, payload) {
        // 즉 여기서 payload는 창에서 입력한 데이터이다
        context.commit(ADD_TODO, payload)
    },
    save ({ state }) {
        const data = {
            todoItems: state.todoItems,
            nextTodoId: state.nextTodoId
        }
        // localstorage를 db대신 임시적으로 사용하고 있음
        // todoitem nextTodoId값을 저장하고 있음
        // 괄호안의 경우 hash set과 같이 키 벨류값을 의미함.
        // DB 대신 임시적으로 사용하고 있음음
        localStorage.setItem('todo-app-data', JSON.stringify(data))
    },
    removeTodo (context, payload) {
        context.commit(REMOVE_TODO, payload)
    },
    //그냥 commit으로 뮤테이션을 호출할거면 {commit}으로 작성해야하고,
    // 아니면 그냥 context.commit으로 호출하면 된다(동일하다)
    editTodo ({ commit }, payload) {
        commit(EDIT_TODO, payload)
    },
    addMonster (context, payload) {
        context.commit(ADD_MONSTER, payload)
    },
    death ({ commit }, payload) {
        commit(DEATH, payload)
    }
}