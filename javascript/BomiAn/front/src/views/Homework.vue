<template>
  <div class="homework">
    <homework-header></homework-header>
    <monster-attack></monster-attack>
    <homework-skill v-on:firstSkill="onFirstSkill"></homework-skill>
        <p>이름: {{ monsters.name }} hp: {{ monsters.hp }}</p>
  </div>
</template>

<script>
import HomeworkHeader from '../components/homework/HomeworkHeader.vue'
import MonsterAttack from '../components/homework/MonsterAttack.vue'
export default {
  name: 'Homework',
  components: {
    'homework-header': HomeworkHeader,
    'monster-attack': MonsterAttack,
    'homework-skill' : MonsterAttack
  
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
        onFirstSkill (content) {
            const coefficient = { content }
            this.monsters.hp -= coefficient.content * this.character.atk
        }
    }
}
</script>