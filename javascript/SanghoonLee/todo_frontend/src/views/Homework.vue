<template>
    <div class="homework">
        <homework-header></homework-header>
    </div>
</template>

<script>

import HomeworkHeader from '../components/homework/HomeworkHeader.vue'

export default {
    name: 'Homework',
    components: {
        'homework-header': HomeworkHeader,
    }
}

</script>

<style>

body {
    text-align: center;
    background-color: #CEDEBD;
}

</style>