<template>
    <div>
        <ul>
            <h4>THINGS TO DO</h4>
            <todo-item v-for="todoItem in todoItems"
                v-bind:key="todoItem.id"
                v-bind:todoItem="todoItem"
                v-bind:editingId="editingId"
                v-on:removeTodo="onRemoveTodo"
                v-on:editTodo="onEditTodo"
                v-on:setEditingId="SET_EDITTING_ID"
                v-on:resetEditingId="RESET_EDITTING_ID"/>           
        </ul>
        <!-- 위에 배열처리된 리스트이 나열되면 항목마다 자동으로 v-on:removeTodo 등이 실행되고,
        그에 따라서 onRemoveTodo 등도 같이 실행이 된다는 뜻인가요?? -->

        <!-- setEditingId는 TodoItem 컴포넌트에 없던데 어디서 실행이 시작되는건지 모르겠습니다. -->
    </div>    
</template>

<script>
import TodoItem from './TodoItem.vue'
import { mapState, mapMutations, mapGetters } from 'vuex'
import { RESET_EDITTING_ID, SET_EDITTING_ID } from '../../store/mutation-types'

export default {
    components: {
        'todo-item': TodoItem
    },
    computed: {
        ...mapGetters ([
            'filteredTodoItems'
            // state에 있는 filter가 null이 아니면 값이 기록된 todoItems반환??
        ]),
        ...mapState ([
            'editingId'
        ]),
        todoItems() {
            return this.filteredTodoItems
        }
    },
    methods: {
        ...mapMutations ([
            SET_EDITTING_ID,
            RESET_EDITTING_ID
        ]),
        onRemoveTodo(id) {
            this.$emit('removeTodo', id)
        },
        onEditTodo(content, id) {
            this.$emit('editTodo', content, id)
        }
    }
}
</script>


// 맵 액션을 사용해 removeTodo, editTodo를 사용하는 이유는
// 중앙인 state에서 정보를 관리하기 위함이다.
// state에는 핵심 데이터들이 들어있다.

// computed는 vdom에 변화가 없어도 계산을 적용시킨다.