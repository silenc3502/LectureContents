<template>
  <v-main class="py-12">
    <v-container class="fill-height" fluid>
      <v-row align="center" justify="center">
        <v-col cols="12" sm="5">
          <v-card class="elevation-12">
            <v-toolbar dark flat>
              <v-spacer />
                <v-toolbar-title>Sign Up</v-toolbar-title>
              <v-spacer />
            </v-toolbar>
            <v-card-text>
              <v-form>
                <v-text-field label="id" v-model="info.id" :rules="idRules" :hint="idHint" :persistent-hint="true" @keyup="checkId" prepend-icon="mdi-account" type="text" :autofocus="true"></v-text-field>
                <v-text-field label="password" v-model="info.password" :rules="passwordRules" prepend-icon="mdi-lock" type="password"></v-text-field>
                <v-text-field label="nickName" v-model="info.nickName" :rules="nickNameRules" :hint="nickHint" :persistent-hint="true" @keyup="checkNickName" prepend-icon="mdi-contacts" type="text"></v-text-field>
                <v-text-field label="phone" v-model="info.phone" :rules="phoneRules" :hint="phoneHint" prepend-icon="mdi-phone" type="text"></v-text-field>
                <v-text-field label="email" v-model="info.email" :rules="emailRules" :hint="emailHint" prepend-icon="mdi-email" type="text"></v-text-field>
              </v-form>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn dark @click="signUp">Sign Up</v-btn>
              <v-btn dark @click="signUpCancel" style="margin-left: 10px;">Cancel</v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>
<script>
import router from '@/router'
import { mapState } from 'vuex'
import axios from 'axios'

export default {
  name: 'SignUpView',
  data: function () {
    return {
      info: {
        id: '',
        password: '',
        nickName: '',
        phone: '',
        email: ''
      },
      idHint: '',
      nickHint: '',
      phoneHint: '',
      emailHint: '',
      isCheckId: false,
      isCheckNickName: false
    }
  },
  computed: {
    ...mapState([
      'idRules',
      'passwordRules',
      'nickNameRules',
      'phoneRules',
      'emailRules'
    ]),
    isValidateMemberInfo: function () {
      // console.log('this.isCheckNickName : ' + this.isCheckNickName)
      console.log('this.phoneHint.trim() : ' + this.phoneHint.trim())
      console.log('this.isCheckNickName : ' + this.isCheckNickName)
      return this.info && this.info.password.trim() !== '' && (this.isCheckNickName && this.info.nickName.trim() !== '') &&
        (this.info.phone.trim() !== '' && /^\d{3}-\d{3,4}-\d{4}$/.test(this.info.phone.trim())) &&
        (this.info.email.trim() !== '' && /.+@.+\..+/.test(this.info.email.trim())) && (this.isCheckId && this.info.id.trim() !== '')
    }
  },
  methods: {
    signUp: function () {
      if (this.isValidateMemberInfo) {
        axios.post('http://kainTime.iptime.org:7777/member/register', this.info).then(res => {
          if (res.status === 200) {
            if (res.data === 'Success') {
              alert('회원가입 성공')
              router.push({ name: 'SignIn' })
            } else {
              alert('회원가입 실패')
            }
          } else {
            console.log('status : ' + res.status + ', data : ' + res.data)
          }
        }).catch(err => {
          console.log(err)
        })
      } else {
        alert('회원가입에 필요한 정보를 확인해 주세요')
      }
    },
    signUpCancel: function () {
      router.push({ name: 'SignIn' })
    },
    checkId: function () {
      // console.log('call check id')
      if (this.info.id.trim() !== '') {
        axios.get(`http://kainTime.iptime.org:7777/member/checkid/${this.info.id}`).then(res => {
          if (res.status === 200) {
            if (res.data === 'Success') {
              this.idHint = '이 id는 사용이 가능합니다.'
              this.isCheckId = true
            } else {
              this.idHint = '중복된 id 입니다. 다른 id를 사용해 주세요'
              this.isCheckId = false
            }
          } else {
            console.log('status : ' + res.status + ', data : ' + res.data)
          }
        }).catch(err => {
          console.log(err)
        })
      } else {
        this.isCheckId = false
        // console.log('id is empty value')
      }
    },
    checkNickName: function () {
      // console.log('call check id')
      if (this.info.nickName.trim() !== '') {
        axios.get(`http://kainTime.iptime.org:7777/member/checknick/${this.info.nickName}`).then(res => {
          if (res.status === 200) {
            if (res.data === 'Success') {
              this.nickHint = '이 nickName은 사용이 가능합니다.'
              this.isCheckNickName = true
            } else {
              this.nickHint = '중복된 nickName 입니다. 다른 nickName을 사용해 주세요'
              this.isCheckNickName = false
            }
            // console.log('check nick Name flag : ' + this.isCheckNickName)
          } else {
            console.log('status : ' + res.status + ', data : ' + res.data)
          }
        }).catch(err => {
          console.log(err)
        })
      } else {
        this.isCheckNickName = false
        // console.log('id is empty value')
      }
    }
  }
}
</script>
