<template>
  <div class="quiz">
    <quiz-header></quiz-header>
    <p>{{ monsters.name }} - hp: {{ monsters.hp }}</p>
    <monster-attack v-on:attack="onAttack"></monster-attack>
  </div>
</template>


<script>
import QuizHeader from '../components/quiz/QuizHeader.vue'
import MonsterAttack from '../components/quiz/MonsterAttack.vue'

export default {
  name: 'Quiz',
  components: {
    'quiz-header': QuizHeader,
    'monster-attack': MonsterAttack
  },
  data () {
    return {
      me: {
        atk: 10
      },
      monsters: {
      name: '슬라임',
      hp: 3000
      }
    }
  },
  methods: {
    onAttack (content) {
      // {}로 받으면 객체로 받게 됨
      const skill = { content }
      this.monsters.hp -= this.me.atk * skill.content
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