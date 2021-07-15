<template>
  <div className="todo">
    <todo-header></todo-header>
    <!-- todo-input 컴포넌트가 emit(addTodo, ~~)를 하면 onAddTodo()가 동작 -->
    <todo-input v-on:addTodo="onAddTodo"></todo-input>
  </div>
</template>

<script>
import TodoHeader from '../components/todo/TodoHeader.vue'
import TodoInput from '../components/todo/TodoInput.vue'
import {mapActions} from 'vuex'

export default {
  name: 'Todo',
  components: {
    'todo-header': TodoHeader,
    'todo-input': TodoInput
  },
  methods: {
    // store에서 중앙 관리를 하고
    // 중앙 관리에 사용하는 동작들을 action에 몰아넣음
    ...mapActions([
      'addTodo',
      'save'
    ]),
    onAddTodo(content) {
      const todoItem = {content}
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