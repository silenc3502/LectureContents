<template>
    <div class="todo">
        <li>
            <!--Editing이 아니라면. 현재는 세팅(null, false)을 안해놔서 보이게되어있음.-->
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
    // bind로 연결한 값은 props로 받아온다.
    props: {
        todoItem: {
            //todoItem이 객체타입이다 (list, 배열)
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
        // editTodo의 이벤트를 갖고있는것이 event
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