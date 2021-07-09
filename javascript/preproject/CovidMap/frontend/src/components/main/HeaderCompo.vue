<template>
  <v-app-bar app v-bind:height="headerHeight" flat dark>
    <div class="header-div-logo">
      <v-btn max-width="200px" max-height="100px" height="100px" @click="logClickEvent" :depressed="true">
        <v-img :contain="true" max-width="200px" max-height="100px" height="100px" src="@/assets/logo.png" position="left center"/>
      </v-btn>
    </div>
    <div class="header-div-title">
      <v-toolbar-title position="center center">COVID19 MAP</v-toolbar-title>
    </div>
    <div class="header-div-items">
      <slot name="headerItems"></slot>
    </div>
  </v-app-bar>
</template>
<script>
export default {
  name: 'HeaderCompo',
  props: {
    headerHeight: {
      type: Number,
      required: true,
      default: 120
    }
  },
  methods: {
    logClickEvent: function () {
      this.$router.push({ name: 'Index' })
    }
  },
  computed: {
  }
}
</script>
<style scope>
  .header-div-logo {
    width: 300px;
  }
  .header-div-title {
    text-align: center;
    width: 1200px;
  }
  .header-div-items {
    width: auto;
  }
</style>
