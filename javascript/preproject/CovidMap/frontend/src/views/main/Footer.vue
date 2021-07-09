<template>
  <div id="footer">
    <main-footer :footerHeight="footerHeight"></main-footer>
  </div>
</template>
<script>

import MainFooter from '@/components/main/FooterCompo.vue'

export default {
  name: 'FooterView',
  components: {
    MainFooter
  },
  props: {
    footerHeight: {
      type: Number,
      required: true,
      default: 70
    }
  }
}
</script>
