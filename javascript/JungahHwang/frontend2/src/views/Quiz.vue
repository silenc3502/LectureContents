<template>
  <div class="monster">
    <monster-header></monster-header>
    <monster-input v-on:addMonster="onAddMonster"></monster-input>
    <monster-list v-on:death="onDeath"></monster-list>
  </div>
</template>


<script>
import { mapActions } from 'vuex'
import MonsterHeader from '../components/quiz/MonsterHeader.vue'
// import MonsterAttack from '../components/quiz/MonsterAttack.vue'
import MonsterInput from '../components/quiz/MonsterInput.vue'
import MonsterList from '../components/quiz/MonsterList.vue'


export default {
  name: 'Monster',
  components: {
    'monster-header': MonsterHeader,
    // 'monster-attack': MonsterAttack
    'monster-input': MonsterInput,
    'monster-list': MonsterList
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
    onAttack (content) {
      // {}로 받으면 객체로 받게 됨
      const skill = { content }
      this.monsters.hp -= this.me.atk * skill.content
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
  background-color: rgb(255, 255, 248);
}

</style>