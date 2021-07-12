<template>
    <div>
    <button v-on:click="addMonster">몬스터 추가하기</button>
    <button v-on:click="addManyMonster">몬스터 100마리씩 리젠시키기</button>
    <ul>
        <li v-for="(monster, index) in monsters"
            v-bind:key="monster.id"
            v-bind:class="{ strong: monster.hp > 300 }">
            ID.{{ monster.id }} {{ monster.name }} HP.{{ Math.floor(monster.hp) }}
            <span v-if="monster.hp > 300">짱쎄다</span>
            <button v-on:click="userAttack(index)">평타</button>
            <button v-on:click="spiritChaosDevilBlade(index)">혼돈의악마영혼검</button>
            <button v-on:click="removeMonster(index)">몬스터 삭제</button>
        </li>
    </ul>
    </div>
</template>



<script>
import { component } from 'vue/types/umd'
import Monster from "../components/Monster.vue"

export default {
    name: monster-add,
    components: Monster,
    data() {
        return {
            var :max = Monster.reduce( function (a, b) {
                return a > b.id ? a : b.id
            }, 0)

            :randNum = Math.floor(Math.random() * this.monsterBook.length)

            Monster   push({
                id: max + 1,
                name: this.monsterBook[randNum].name,
                hp: this.monsterBook[randNum].hp
            })
        }
       
    }
}
</script>



<style scoped>

</style>