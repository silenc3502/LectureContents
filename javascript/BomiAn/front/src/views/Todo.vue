<template>
  <div class="todo">
   <todo-header></todo-header>
  <!-- todo-input 컴포넌트가 emit (add, ~~)를 하면 onAddTodo()가 동작
  emit은 자기 자식을 감싸고 있는 컴포논트에게 값을 전달-->
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
    // store에서 중앙 관리를 하고
    // 중앙관리에서 사용하는 동작들을 action에 붙여넣음
    ...mapActions([
      'addTodo',
      'save'
    ]),
    //content 는 emit으로 전달받은 value임 
    onAddTodo (content) {
      const todoItem = { content }
      this.addTodo(todoItem);
      this.save()
    }
  },
}
</script>

<style>
  body{
    text-align: center;
    background-color: #CEDCBD;
  }
</style>