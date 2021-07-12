<template>
    <div class="home">
        <div id="header">
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
        <div id="app">
            <p>{{ msg }}</p>

            <global-component v-bind:monsterBook-test="counter">
            </global-component>

            <local-component v-bind:num="value"></local-component>
            <button v-on:click="plus">몬스터 한마리 리젠</button>
        </div>
    </div>
</template>

<script>
import Vue from 'vue'
import GlobalComponent from '../components/GlobalComponent.vue'
import LocalComponent from '../components/LocalComponent.vue'
Vue.component(GlobalComponent.name, GlobalComponent)
export default {
    components: {
        'local-component': LocalComponent
    },
    data () {
        return {
            counter: 0,
            value: 0,
            msg: '몬스터 100마리 리젠'
        }
    },
    methods: {
        plus () {
            this.value++
        }
    }
}
</script>
