<template>
  <div class="todo">
    <li>
      <span v-if="!isEditing">
        {{ todoItem.content }}
      </span>
      <!-- blur: 입력창의 포커싱 제거 -->
      <input v-else type="text" ref="content" v-bind:value="todoItem.content"
        v-on:blur="handleBlur" v-on:keydown.enter="editTodo">
      <button v-on:click="removeTodo">remove</button>
    </li>
  </div>
</template>


<script>

export default {
  name: 'TodoItem',
  // TodoList에서 전달한 값을 props로 받음
  props: {
    todoItem: {
      type: Object
    },
    editingId: {
      type: Number
    }
  },
  // computed: VDOM의 변화가 없어도 계산값이 적용되도록 서포트
  computed: {
    isEditing () {
      return this.todoItem.id === this.editingId
    }
  },
  methods: {
    removeTodo () {
      const id = this.todoItem.id
      this.$emit('removeTodo', id)
    },
    editTodo (event) {
      const id = this.todoItem.id
      const content = event.target.value.trim()

      if (content.length <= 0) {
        return false
      }

      this.$emit('editTodo', content, id)
      this.$refs.content.blur()
    },
    handleBlur () {
      this.$emit('resetEditingId')
    }
  }
}
</script>
