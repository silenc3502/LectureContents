<template>
    <div class="homework">
        <homework-header></homework-header>
        <monster-input v-on:addMonster="onAddMonster"></monster-input>
        <!-- <homework-skill v-on:firstSkill="onFirstSkill"></homework-skill> -->
        <monster-list
                v-on:death="onDeath">
        </monster-list>
        <!-- <p>이름: {{ monsters.name }} hp: {{ monsters.hp }}</p> -->
    </div>
</template>

<script>
import HomeworkHeader from '../components/homework/HomeworkHeaderBackup.vue'
import MonsterInput from '../components/monster/MonsterInputBackup.vue'
// import HomeworkSkill from '../components/homework/HomeworkSkill.vue'
import MonsterList from '../components/monster/MonsterListBackup.vue'
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
        onDeath (monsterId) {
            this.death(monsterId)
            this.save()
        }
    }
}
</script>

<style>
body {
    text-align: center;
    background-color: #5e9b1c;
}
</style>