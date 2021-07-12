<template>
    <div class="todo">
        <todo-header></todo-header>
    </div>
</template>

<script>

import TodoHeader from '../components/todo/TodoHeader.vue'

export default {
    name: 'Todo',
    components: {
        'todo-header': TodoHeader
    }
}

</script>

<style>

body {
    text-align: center;
    background-color: #CEDEBD;
}

</style>