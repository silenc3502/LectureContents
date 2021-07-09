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
            <v-text-field label="title" v-model="title" type="text" :disabled="isDisabled"></v-text-field>
            <v-textarea height="450px" v-model="contents" label="contents" type="text" :rows="16" :disabled="isDisabled" aria-multiline="true"></v-textarea>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn dark v-if="(isDisabled && getSameUser)" @click="setModify">수정</v-btn>
            <v-btn dark v-if="(!isDisabled && getSameUser)" @click="modifyBoard()">수정 완료</v-btn>
            <v-btn dark v-if="(isDisabled && getSameUser)" @click="removeBoard()">삭제</v-btn>
            <v-btn dark @click="moveBack">취소</v-btn>
          </v-card-actions>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>
<script>
import router from '@/router/'
import { mapGetters, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'BoardReadView',
  data: function () {
    return {
      isDisabled: true,
      title: '',
      contents: ''
    }
  },
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapGetters([
      'getSameUser',
      'getBoardTitle',
      'getBoardContents'
    ]),
    isValidateBoardInfo: function () {
      return this.title.trim() !== '' && this.contents.trim() !== ''
    }
  },
  methods: {
    ...mapActions([
      'getBoardAction'
    ]),
    setModify: function () {
      this.isDisabled = !this.isDisabled
    },
    moveBack: function () {
      if (!this.isDisabled) {
        this.isDisabled = !this.isDisabled
      } else {
        router.go(-1)
      }
    },
    modifyBoard: function () {
      if (this.isValidateBoardInfo) {
        const { title, contents } = { title: this.title, contents: this.contents }
        // console.log('modifyBoard() data - boardNo : ' + this.boardNo)
        axios.put(`http://kainTime.iptime.org:7777/board/${this.boardNo}`, { title, contents }).then(res => {
          if (res.status === 200 && res.data === 'Success') {
            alert('글 수정 성공')
          } else {
            alert('글 수정 실패')
          }
          router.push({ name: 'BoardMain' })
        }).catch(err => {
          console.log(err)
        })
      } else {
        alert('Title과 contents를 확인해주세요')
      }
    },
    removeBoard: function () {
      // console.log('removeBoard() data - boardNo : ' + this.boardNo)
      axios.delete(`http://kainTime.iptime.org:7777/board/${this.boardNo}`).then(res => {
        if (res.status === 200 && res.data === 'Success') {
          alert('글 삭제 성공')
        } else {
          alert('글 삭제 실패')
        }
        router.push({ name: 'BoardMain' })
      }).catch(err => {
        console.log(err)
      })
    }
  },
  mounted () {
    this.getBoardAction(this.boardNo)
  },
  updated () {
    if (this.title === '' && this.contents === '') {
      this.title = this.getBoardTitle
      this.contents = this.getBoardContents
    }
  }
}
</script>
