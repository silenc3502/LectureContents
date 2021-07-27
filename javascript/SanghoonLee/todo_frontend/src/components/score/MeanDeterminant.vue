<template>
    <div>
        <p>{{ students }}</p>
        <!--
        <ul v-for="(dd, idx) in dungeons_details" :key="idx">
            <li v-if="dd.monsterAmount == dungeons[0]">
                던전명: {{ students[1] }}, 몬스터수량: {{ students[0] }}<br>
                {{ dd.text }}
            </li>
        </ul>
        -->
    </div>
</template>

<script>

import EventBus from '@/eventBus.js'

export default {
    data () {
        return {
            mean,
            students: []
        }
    },
    created: function() {
        EventBus.$on('calcMean', (payload) => {
            this.mean = payload.mean
            this.students = { payload }
        })
    }
}

</script>

<style scoped>

div {
    background: #ff4081;
    color: white;
    padding: 10px;
    font-weight: bold;
}
ul {
    list-style: none;
}

</style>