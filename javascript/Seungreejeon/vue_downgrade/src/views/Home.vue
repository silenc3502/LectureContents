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
            <monster></monster>
            <router-link :to="{ name: 'Todo' }"
                          class="nav-link"   
                          active-class="active">
                          Todo
            </router-link>
              <router-link :to="{ name: 'Homework' }"
                          class="nav-link"   
                          active-class="active">
                          Homework
            </router-link>
        </div>
    </div>
</template>

<script>
import Monster from "../components/Monster.vue"

  export default {
    name: 'Home',
    components: {
        'monster': Monster
    },
  }
</script>