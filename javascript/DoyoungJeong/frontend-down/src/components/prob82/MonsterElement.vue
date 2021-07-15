<template>
    <div class="todo">
        <li>
            <span v-if="!isEditing">
                {{ monsterElem.name }}
            </span>
            <input v-else type="text" ref="name"
                    v-bind:value="monsterElem.name"
                    v-on:blur="handleBlur"
                    v-on:keydown.enter="editName"/>
            <button v-on:click="killMonster">몬스터 삭제</button>
            <!-- ref의 뜻? -->
            <!-- blur는 마우스 포커스를 뗐을 때 발동 -->
        </li>
    </div>        
</template>

<script>

export default {
        name: 'MonsterElement',
        props: {
            MonsterElem: {
                type: Object
        },
        editingId: {
            type: Number
        }
    },
    computed: {
        isEditing() {
            return this.MonsterElem === this.editingId
        } //이부분 잘 모르겠다..
    },
    methods: {
        killMonster() {
            const id = this.monsterElem.id
            this.$emit('killMonster', id)
        },
        editName(event) {
            const monsterId = this.monsterElem.monsterId
            const name = event.target.value.trim()

            if(name.length <= 0) {
                return false
            }
            this.$emit('editName', name, monsterId)
            this.$refs.name.blur()
            //위 refs blur()가 무슨뜻?
        },
        handleBlur() {
            this.$emit('resetEditingId')
        }
    }
}

</script>