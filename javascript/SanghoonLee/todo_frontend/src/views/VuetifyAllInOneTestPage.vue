<template>
    <div>
        <p class="blue lighten-5 red--text">Test</p>
        <p class="blue white--text">Test</p>
        <p class="blue darken-3">Test</p>
        <v-btn class="teal" rounded @click="roundBtnClick">Round 버튼</v-btn>
    </div>
</template>

<script>

export default {
    methods: {
        roundBtnClick () {
            alert('Vuetify 버튼이라고 들어봤니 ?')
        }
    }    
}

</script>

<style scoped>

h1 {
    margin: 10px;
}
p {
    padding: 10px;
    margin: 5px 10px;
}

</style>