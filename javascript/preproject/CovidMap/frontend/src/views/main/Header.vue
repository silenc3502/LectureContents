<template>
  <main-header :headerHeight="headerHeight">
    <template #headerItems>
     <v-btn @click="goMainView()" text color="white" class="header-item">COVID Map</v-btn>
     <v-btn @click="goBoardView()" text color="white" class="header-item">Board</v-btn>
     <v-btn v-if="!getIsLogin" @click="goSignIn()" text color="white" class="header-item">Sign in</v-btn>
     <v-btn v-if="getIsLogin" @click="logout()" text color="white" class="header-item">Logout</v-btn>
    </template>
  </main-header>
</template>
<script>

import MainHeader from '@/components/main/HeaderCompo.vue'
import router from '@/router'
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'HeaderView',
  components: {
    MainHeader
  },
  computed: {
    ...mapGetters([
      'getIsLogin'
    ])
  },
  props: {
    headerHeight: {
      type: Number,
      required: true,
      default: 120
    }
  },
  methods: {
    ...mapActions([
      'logoutAction'
    ]),
    goMainView () {
      // console.log('goMainView')
      if (window.location.pathname !== '/') {
        router.push('/')
      }
    },
    goBoardView () {
      // console.log('goBoardView')
      if (window.location.pathname !== '/board') {
        router.push({ name: 'BoardMain' })
      }
    },
    goSignIn () {
      // console.log('signIn')
      if (window.location.pathname !== '/signIn') {
        router.push({ name: 'SignIn' })
      }
    },
    logout () {
      // console.log('logout')
      this.logoutAction()
    }
  }
}
</script>
