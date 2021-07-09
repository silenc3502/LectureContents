<template>
<v-app>
  <div id="header" :style="headerViewStyle">
    <main-header :headerHeight="headerHeight"/>
  </div>
  <div id="contents" :style="contentsViewStyle">
    <div id="router-view-div" :style="routerViewStyle">
      <router-view/>
    </div>
  </div>
  <div id="footer" :style="footerViewStyle">
    <main-footer :footerHeight="footerHeight"/>
  </div>
</v-app>
</template>

<script>
import MainHeader from '@/views/main/Header.vue'
import MainFooter from '@/views/main/Footer.vue'

export default {
  name: 'App',
  components: {
    MainHeader,
    MainFooter
  },
  data: function () {
    return {
      headerHeight: 120,
      footerHeight: 70,
      defaultPadding: 40,
      headerViewStyle: {
        height: '120px'
      },
      footerViewStyle: {
        height: '70px'
      },
      contentsViewStyle: {},
      routerViewStyle: {}
    }
  },
  computed: {
    getContentsStyle () {
      return window.innerHeight - this.headerHeight - this.footerHeight
    },
    getRouterViewWidth () {
      return window.innerWidth - (this.defaultPadding * 2)
    },
    getRouterViewHeight () {
      return this.getContentsStyle - (this.defaultPadding * 2)
    }
  },
  methods: {
    onResize: function () {
      this.contentsViewStyle = {
        height: this.getContentsStyle + 'px',
        padding: this.defaultPadding + 'px'
      }

      this.routerViewStyle = {
        // border: 'solid 1px gray',
        width: this.getRouterViewWidth + 'px',
        height: this.getRouterViewHeight + 'px'
      }
    }
  },
  mounted: function () {
    this.$nextTick(() => {
      this.onResize()
    })
  }
}
</script>
