<template>
  <div class="todo">
    <todo-header></todo-header>
    <!-- 하위 컴포넌트(TodoInput) emit(addTodo, -) 이벤트가 발생하면 
         상위 컴포넌트(Todo)가 onAddTodo()를 수신 -->
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
    // store에서 중앙관리를 하고 중앙관리하여 사용할 동작들을 actions에 넣음
    // ...mapActions: strore의 actions에 맵핑
    ...mapActions ([
      // addTodo: store/actions의 addTodo
      'addTodo',
      'save'
    ]),
    onAddTodo (content) {
      // content: TodoInput의 value값
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
  background-color: rgb(255, 255, 248);
}

</style>