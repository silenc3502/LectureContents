<template>
    <div class="homework">
        <homework-header></homework-header>
        <!-- v-on:firskill에서 firstskill은 이벤트 이름. 이 이벤트가 발생했을 때 동작할 것이 onFirstSkill-->
        <!-- <homework-skill v-on:firstSkill="onFirstSkill"></homework-skill> -->

        <monster-input v-on:addMonster="onAddMonster"></monster-input>
        <!-- <homework-skill v-on:firstSkill="onFirstSkill"></homework-skill> -->
        <monster-list
                v-on:death="onDeath">
        </monster-list>
        <!--<p>이름: {{ monsters.name }} hp: {{ monsters.hp }}</p>-->
        <!-- todo-input 컴포넌트가 emit(addTodo, ~~)를 하면 onAddTodo()가 동작
        <todo-input v-on:addTodo="onAddTodo"></todo-input>-->
    </div>
</template>

<script>
import HomeworkHeader from '../components/homework/HomeworkHeader.vue'
import MonsterInput from '../components/monster/MonsterInput.vue'
// import HomeworkSkill from '../components/homework/HomeworkSkill.vue'
import MonsterList from '../components/monster/MonsterList.vue'
import { mapActions } from 'vuex'
export default {
    name: 'Homework',
    components: {
        'homework-header': HomeworkHeader,
        'monster-input': MonsterInput,
        // 'homework-skill': HomeworkSkill,
        'monster-list': MonsterList
    },
    data () {
        return {
            character: {
                atk: 5
            },
            monsters: {
                name: '슬라임',
                hp: 30
            }
        }
    },
    methods: {
        ...mapActions ([
            'addMonster',
            'death',
            'save'
        ]),
        onAddMonster (name) {
            const monsterElement = { name }
            this.addMonster(monsterElement)
            this.save()
        },
        onFirstSkill (content) {
            // { } 로 받으면 객체로 받게됨
            const coefficient = { content }
            this.monsters.hp -= coefficient.content * this.character.atk
        },
        onDeath (id) {
            this.death(id)
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