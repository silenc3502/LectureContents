<template>
  <v-main class="py-12">
    <v-container class="fill-height" fluid>
      <v-row align="center" justify="center">
        <v-col cols="12" sm="6">
          <v-card>
            <v-toolbar dark flat height="35px">
              <v-spacer />
                <v-toolbar-title>B o a r d</v-toolbar-title>
              <v-spacer />
            </v-toolbar>
          </v-card>
          <v-card-text>
            <v-text-field label="title" v-model="board.title" :rules="titleRule" type="text"></v-text-field>
            <v-textarea height="450px" v-model="board.contents" label="contents" :rules="contentsRule" type="text" :rows="16"></v-textarea>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn dark @click="boardWrite">글쓰기</v-btn>
            <v-btn dark @click="moveBack">취소</v-btn>
          </v-card-actions>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>
<script>

import { mapState, mapGetters } from 'vuex'
import router from '@/router/'
import axios from 'axios'

export default {
  name: 'boardWriteView',
  data: function () {
    return {
      board: {
        title: '',
        contents: ''
      }
    }
  },
  computed: {
    ...mapState([
      'titleRule',
      'contentsRule'
    ]),
    ...mapGetters([
      'getLoginInfo'
    ]),
    isValidateBoardInfo: function () {
      return this.board && this.board.title.trim() !== '' && this.board.contents.trim() !== ''
    }
  },
  methods: {
    boardWrite: function () {
      if (this.isValidateBoardInfo) {
        // console.log('title : ' + this.board.title)
        // console.log('contents : ' + this.board.contents)

        var info = this.getLoginInfo

        const { title, contents, writer } = {
          title: this.board.title,
          contents: this.board.contents,
          writer: info.nickName
        }

        axios.post('http://kainTime.iptime.org:7777/board', { title, contents, writer }).then(res => {
          if (res.status === 200 && res.data === 'Success') {
            alert('등록 성공')
          } else {
            alert('등록 실패')
          }
          router.push({ name: 'BoardMain' })
        }).catch(err => {
          console.log(err)
        })
      } else {
        alert('Title과 contents를 확인해주세요')
      }
    },
    moveBack: function () {
      router.go(-1)
    }
  }
}
</script>
