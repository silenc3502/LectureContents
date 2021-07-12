<template>
  <div>
    <h3>Monster Attack!</h3>
    <p id="target">name: {{ monster.name }} hp: {{ monster.hp }}</p>
    <button v-on:click="attackMonster">공격 -10</button> <br><br>
    <h3>스킬 사용</h3>
        <input type="text" v-on:keypress.enter="firstSkill">
        <button v-on:click="firstSkill">파이어볼</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      monster: {
        name: 'gogomon',
        hp: 200
      },
      atk_coefficient: 3.7
    }
  },
  methods: {
    attackMonster() {
      if(this.monster.hp > 0) {
        this.monster.hp -= 10;
      } else {
        alert('몬스터를 잡았습니다.');
        const target = document.querySelector('#target');
        target.classList.add('clear');
      }
    },
     firstSkill () {
            console.log('firstSkill')
            this.$emit('firstSkill', this.atk_coefficient)
     }
  },
}
</script>

<style>
  .clear {
   text-decoration: line-through; 
  }
</style>