<template>
    <div class="todo">
        <todo-header>

        </todo-header>
        <todo-input v-on:addTodo="onAddTodo"></todo-input>
        <!-- TodoInput 컴포넌트에서 addTodo메소드가 작동하면 여기 Todo.vue에 있는 onAddTodo를 실행하란 뜻??? -->
        <todo-list
            v-on:removeTodo="onRemoveTodo"
            v-on:editTodo="onEditTodo">
        </todo-list>
    </div>
</template>

<script>

import TodoHeader from '../components/todo/TodoHeader.vue'
import TodoInput from '../components/todo/TodoInput.vue'
import TodoList from '../components/todo/TodoList.vue'

import { mapActions } from 'vuex'

export default {
    name: 'Todo',
    components: {
        'todo-header': TodoHeader,
        'todo-input': TodoInput,
        'todo-list': TodoList
    },
    methods: {
        //mapActions은 store에서 중앙 관리를 한다.
        ...mapActions ([
            'addTodo',
            'removeTodo',
            'editTodo',
            'save'
        ]),
        onAddTodo(content) {
            const todoItem = { content }
            //const는 final변수 같은 것이다.
            this.addTodo(todoItem)
            this.save()
        },
        onRemoveTodo(id) {
            this.removeTodo(id)
            this.save()
        },
        onEditTodo(content, id) {
            this.editTodo({ id, content })
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