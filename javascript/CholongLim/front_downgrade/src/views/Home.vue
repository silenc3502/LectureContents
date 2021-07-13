<template>
  <div class="home">
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
</template>

<script>
// @ is an alias to /src

export default {
  name: 'Home',
  components: {
  }
}
</script>
