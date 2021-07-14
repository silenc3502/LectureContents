<template>
    <div class="todo">
        <li>
            <span v-if="isEditing">
                {{ todoItem.content }}
            </span>
            <input v-else type="text" ref="content"
                    v-bind:value="todoItem.content"
                    v-on:blur="handleBlur"
                    v-on:keydown.enter="editTodo"/>
            <button v-on:click="removeTodo">지우기</button>
            <!-- ref의 뜻? -->
            <!-- blur는 마우스 포커스를 뗐을 때 발동 -->
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
    computed: {
        isEditing() {
            return this.todoItem === this.editingId
        } //이부분 잘 모르겠다..
    },
    methods: {
        removeTodo() {
            const id = this.todoItem.id
            this.$emit('removeTodo', id)
        },
        editTodo(event) {
            const id = this.todoItem.id
            const content = event.target.value.trim()

            if(content.length <= 0) {
                return false
            }
            this.$emit('editTodo', content, id)
            this.$refs.content.blur()
            //위 refs blur()가 무슨뜻?
        },
        handleBlur() {
            this.$emit('resetEditingId')
        }
    }
}

</script>