<template>
    <div id="board">
        <h2>Vue + Spring 게시판 구현</h2>
        <router-link :to="{ name: 'BoardRegisterPage' }">
            게시물 작성
        </router-link>
        <!-- <board-list/> -->
    </div>
</template>

<script>

// import { mapState, mapActions } from 'vuex'

export default {
    name: 'BoardListPage',
    components: {
    },
    computed: {
    }
}

</script>