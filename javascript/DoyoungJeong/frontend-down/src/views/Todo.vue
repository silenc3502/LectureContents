<template>
    <div class="todo">
        <todo-header>

        </todo-header>
        <todo-input v-on:addTodo="onAddTodo"></todo-input>
        <!-- TodoInput 컴포넌트에서 addTodo메소드가 작동하면 여기 Todo.vue에 있는 onAddTodo를 실행하란 뜻??? -->
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
        //mapActions은 store에서 중앙 관리를 한다.
        ...mapActions ([
            'addTodo',
            'save'
        ]),
        onAddTodo(content) {
            const todoItem = { content }
            //const는 final변수 같은 것이다.
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