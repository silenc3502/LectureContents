<template>
    <div class="home">
        <div>
            <router-link :to="{ name: 'Home' }"
                class="nav-link"
                active-class="active">
            Home
        </router-link>
        <router-link :to="{ name: 'Test' }"
                class="nav-link"
                active-class="active">
            Test
        </router-link>
    </div>
    <h2>테스트 페이지</h2>
    </div>
</template>

<script>

export default {
    components: {
    },
    data () {
        return {
            msg: 'Test'
        }
    },
    methods: {
    }
}

</script>