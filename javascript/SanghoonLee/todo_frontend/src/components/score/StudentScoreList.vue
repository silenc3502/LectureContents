<template>
    <div>
        <h3>학생 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="50">번호</th>
                <th align="center" width="150">이름</th>
                <th align="center" width="150">성적</th>
            </tr>
            <tr v-if="!students || (Array.isArray(students) && students.length === 0)">
                <td colspan="3">
                    학생이 없습니다! 폐교합니다!
                </td>
            </tr>
            <tr v-else v-for="(student, idx) in students" :key="idx">
                <td align="center">{{ student.studentNo }}</td>
                <td align="center">{{ student.name }}</td>
                <!--
                <td align="center" v-on:click="measureMonsterAmount(student.monsterAmount, $event)">
                    {{ dungeon.name }}
                </td>
                -->
                <td align="center">{{ student.score }}</td>
            </tr>
        </table>
    </div>
</template>

<script>

import EventBus from '@/eventBus.js'

export default {
    name: 'StudentScoreList',
    props: {
        students: {
            type: Array
        }
    },
    methods: {
        measureMonsterAmount(monsterAmount, $event) {
            const payload = [ monsterAmount, $event.target.innerHTML ]
            EventBus.$emit('measureMonsterAmount', payload)
        }
    }
}

</script>