<template>
    <div>
        <h3>몬스터 소환</h3>
        <input type="text" v-on:press.enter="summonMonter">
        <button v-on:click="summonManyMonster">몬스터 100마리 소환</button>
    </div>
</template>

<script>

export default {
    methods: {
        summonManyMonster() {
            console.log('summonManyMonster')
            this.$emit('summonManyMonster')
        }
    }
}
</script>


