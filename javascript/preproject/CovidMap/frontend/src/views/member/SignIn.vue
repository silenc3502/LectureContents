<template>
  <v-main>
    <v-container class="fill-height" fluid>
      <v-row align="center" justify="center">
        <v-col cols="12" sm="4">
          <v-card class="elevation-12">
            <v-toolbar dark flat>
              <v-spacer />
                <v-toolbar-title>L o g i n</v-toolbar-title>
              <v-spacer />
            </v-toolbar>
            <v-card-text>
              <v-form>
                <v-text-field label="id" v-model="info.id" prepend-icon="mdi-account" type="text" :autofocus="true"></v-text-field>
                <v-text-field label="Password" v-model="info.password" prepend-icon="mdi-lock" type="password" @keyup.enter="signInAction(info)"></v-text-field>
              </v-form>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn dark @click="signInAction(info)">Login</v-btn>
              <v-btn dark @click="moveSignUp" style="margin-left: 10px;">Sign up</v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>
<script>
import router from '@/router'
import { mapActions } from 'vuex'

export default {
  name: 'SignInView',
  data: function () {
    return {
      info: {
        id: '',
        password: ''
      }
    }
  },
  methods: {
    ...mapActions([
      'signInAction'
    ]),
    moveSignUp: function () {
      // console.log('signUp signUp')
      router.push({ name: 'SignUp' })
    }
  }
}
</script>
