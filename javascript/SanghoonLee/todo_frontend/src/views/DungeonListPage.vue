<template>
    <div id="board">
        <h2>매번 새롭게 갱신되는 던전 원정 이벤트!</h2>
        <dungeon-list :dungeons="dungeons"/>
    </div>
</template>

<script>

import DungeonList from '@/components/dungeon/DungeonList.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'DungeonListPage',
    components: {
        MonsterList
    },
    computed: {
        ...mapState(['dungeons'])
    },
    mounted () {
        this.randomDugeonList()
    },
    methods: {
        ...mapActions(['randomDugeonList'])
    }
}

</script>