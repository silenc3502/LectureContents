<template>
  <v-main class="py-0">
    <v-container class="fill-height" fluid>
      <v-row align="center" justify="center">
        <v-col cols="12" sm="10">
          <v-card>
           <v-card-title>
                <v-spacer/>
                B o a r d
                <v-spacer/>
                <v-text-field v-model="search" append-icon="mdi-magnify" label="Title Search" single-line hide-details />
           </v-card-title>
           <v-card-text>
            <v-data-table @click:row="rowClick" :headers="headers" :items="getBoardList" :search="search" :footer-props="footerProps" :sort-by="['boardNo']" :sort-desc="[true]" :fixed-header="true" height="530px"/>
            <div class="table-footer-prepend d-flex pl-2 align-center">
              <v-tooltip top>
                <template v-slot:activator="{ on }">
                  <v-btn width="30px" height="30px" icon outlined color="primary" class="mr-3" v-on="on" @click="getBoardListAction">
                    <v-icon :small="true">mdi-refresh</v-icon>
                  </v-btn>
                </template>
                <span>Refresh Board</span>
              </v-tooltip>
              <v-tooltip top>
                <template v-slot:activator="{ on }">
                  <v-btn width="30px" height="30px" icon outlined color="primary" class="mr-3" v-on="on" @click="moveWriteBoard">
                    <v-icon :small="true">mdi-plus</v-icon>
                  </v-btn>
                </template>
                <span>Add Board</span>
              </v-tooltip>
            </div>
           </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>
<script>

import router from '@/router/'
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'MainBoardView',
  data: function () {
    return {
      headers: [
        { text: 'No.', align: 'center', sortable: false, filterable: false, value: 'boardNo', width: '10%' },
        { text: 'Title', align: 'center', sortable: false, filterable: true, value: 'title', width: '50%' },
        { text: 'Writer', align: 'center', sortable: false, filterable: false, value: 'writer', width: '20%' },
        { text: 'date', align: 'center', sortable: false, filterable: false, value: 'regDate', width: '20%' }
      ],
      footerProps: {
        itemsPerPageText: '',
        lastIcon: '$last',
        nextIcon: '$next',
        itemsPerPageOptions: [10]
      },
      search: ''
    }
  },
  computed: {
    ...mapGetters([
      'getBoardList'
    ])
  },
  methods: {
    ...mapActions([
      'getBoardListAction'
    ]),
    rowClick: function (item, row) {
      // console.log('boardNo : ' + item.boardNo)
      router.push({ name: 'BoardRead', params: { boardNo: item.boardNo.toString() } })
    },
    moveWriteBoard: function () {
      router.push({ name: 'BoardWrite' })
    }
  },
  mounted () {
    this.getBoardListAction()
  }
}
</script>
<style scope>
tr.v-data-table__selected {
  background: #7d92f5 !important;
}

div.table-footer-prepend {
  margin-top: -44px;
  height: 58px;
}

</style>
