
<template>
    <div class="todo">
        <li>
            <span v-if="!isEditing">
                {{ todoItem.content }}
            </span>
            <input v-else type="text" ref="content"
                    v-bind:value="todoItem.content"
                    v-on:blur="handleBlur"
                    v-on:keydown.enter="editTodo"/>
            <button v-on:click="removeTodo">지우기</button>
        </li>
    </div>
</template>

<script>
export default {
    name: 'TodoItem',
    props: {
        todoItem: {
            type: Object
        },
        editingId: {
            type: Number
        }
    },
    // VDOM 변화가 없어도 계산값이 적용되도록 서포트함
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