<template>
    <div class="todo">
        <todo-header></todo-header>
        <!-- todoInput.vue에서 todo-input 컴포넌트가 emit(addTodo, ~~)을 요청하면 
        onAddTodo()가 동작 -->
        <todo-input v-on:addTodo="onAddTodo"></todo-input>
    </div>
</template>

<script>
import TodoHeader from '../components/todo/TodoHeader.vue'
import TodoInput from '../components/todo/TodoInput.vue'
import { mapActions } from 'vuex'
export default {
    name: 'Todo',
    components: {
        'todo-header': TodoHeader,
        'todo-input': TodoInput
    },
    methods: {
        ...mapActions ([
            'addTodo',
            'save'
        ]),
        onAddTodo (content) {
            const todoItem = { content }
            this.addTodo(todoItem)
            this.save()
        }
    }
}
</script>
<style>
body {
    text-align: center;
    background-color: #CEDEBD;
}
</style>