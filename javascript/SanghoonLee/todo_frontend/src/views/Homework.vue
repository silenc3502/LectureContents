<template>
    <div class="homework">
        <homework-header></homework-header>
        <homework-skill v-on:firstSkill="onFirstSkill"></homework-skill>
        <monster-list
                v-on:death="onDeath">
        </monster-list>
        <!-- <p>이름: {{ monsters.name }} hp: {{ monsters.hp }}</p> -->
    </div>
</template>

<script>

import HomeworkHeader from '../components/homework/HomeworkHeader.vue'
import HomeworkSkill from '../components/homework/HomeworkSkill.vue'
import MonsterList from '../components/monster/MonsterList.vue'

import { mapActions } from 'vuex'

export default {
    name: 'Homework',
    components: {
        'homework-header': HomeworkHeader,
        'homework-skill': HomeworkSkill,
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
            'death',
            'save'
        ]),
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