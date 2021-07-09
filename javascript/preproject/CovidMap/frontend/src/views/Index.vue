<template>
  <v-main class="py-12">
    <v-container class="fill-height" fluid>
      <v-row align="center" justify="center">
        <v-col cols="4" md="12" class="pa-0">
          <v-card>
            <v-card-title>
              <v-spacer/>
              COVID STATUS
              <v-spacer/>
            </v-card-title>
            <v-card-text>
              <div id="status" style="height: 100px">
                <v-col cols="3" sm="3" md="2" class="text-center status-data" >
                  <p>확진자</p>
                  <p>{{covidStatus != null ? covidStatus.totalAcc : 0}}</p>
                  <p v-bind:class="this.checkContainsStr(covidStatus != null ? covidStatus.totalDiff : '')">{{covidStatus != null ? covidStatus.totalDiff : '-'}}</p>
                </v-col>
                <v-col cols="3" sm="3" md="1" class="text-center status-data">
                  <p>사망자</p>
                  <p>{{covidStatus != null ? covidStatus.deathAcc : 0}}</p>
                  <p v-bind:class="this.checkContainsStr(covidStatus != null ? covidStatus.deathDiff : '')">{{covidStatus != null ? covidStatus.deathDiff : '-'}}</p>
                </v-col>
                <v-col cols="3" sm="3" md="1" class="text-center status-data">
                  <p>격리해제</p>
                  <p>{{covidStatus != null ? covidStatus.freeAcc : 0}}</p>
                  <p v-bind:class="this.checkContainsStr(covidStatus != null ? covidStatus.freeDiff : '')">{{covidStatus != null ? covidStatus.freeDiff : '-'}}</p>
                </v-col>
                <v-col cols="3" sm="3" md="2" class="text-center status-data">
                  <p style="height: 44px">치명률</p>
                  <p>{{covidStatus != null ? covidStatus.fatalityRate : '-'}}</p>
                </v-col>
                <v-col cols="4" sm="4" md="2" class="text-center status-data">
                  <p>총검사자</p>
                  <p>{{covidStatus != null ? covidStatus.totalInspectionAcc : 0}}</p>
                  <p v-bind:class="this.checkContainsStr(covidStatus != null ? covidStatus.totalInspectionDiff : '')">{{covidStatus != null ? covidStatus.totalInspectionDiff : '-'}}</p>
                </v-col>
                <v-col cols="4" sm="4" md="2" class="text-center status-data">
                  <p>검사중</p>
                  <p>{{covidStatus != null ? covidStatus.inspectionAcc : 0}}</p>
                  <p v-bind:class="this.checkContainsStr(covidStatus != null ? covidStatus.inspectionDiff : '')">{{covidStatus != null ? covidStatus.inspectionDiff : '-'}}</p>
                </v-col>
                <v-col cols="4" sm="4" md="2" class="text-center status-data">
                  <p>결과음성</p>
                  <p>{{covidStatus != null ? covidStatus.totalNegativeAcc : 0}}</p>
                  <p v-bind:class="this.checkContainsStr(covidStatus != null ? covidStatus.totalNegativeDiff : '')">{{ covidStatus != null ? covidStatus.totalNegativeDiff : '-'}}</p>
                </v-col>
              </div>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
      <v-row align="center" justify="center" class="mt-8 pa-0">
        <v-col cols="3" md="8" class="pt-0 pr-0 pb-0">
          <v-card>
            <v-card-title>
              <v-spacer/>
              COVID MAP
              <v-spacer/>
            </v-card-title>
            <v-card-text>
              <div id="map" style="height: 325px"></div>
            </v-card-text>
          </v-card>
        </v-col>
        <v-col cols="3" md="4" class="pt-0 pr-0 pb-0">
          <v-card>
            <v-card-title>
              <v-spacer/>
              Place List
              <v-spacer/>
            </v-card-title>
            <v-card-text>
              <div id="list" style="height: 325px; overflow: auto">
                <div>
                  <div style="display: inline-block;" class="place-width">
                    장소명
                  </div>
                  <div style="display: inline-block;" class="place-width">
                    확인일자
                  </div>
                  <div style="display: inline-block;" class="place-width">
                    보러가기
                  </div>
                </div>
                <div v-for="(marker, index) in covidMarkers" v-bind:key="index" class="maker-data" style="width: 100%" v-bind:class="checkCurrentIndex(index)">
                  <div class="place-width">{{marker.locationName}}</div>
                  <div class="place-width">{{marker.confirmDate}}</div>
                  <div class="icon-width" v-on:click="updateMarker(index)">
                    <v-img :contain="true" max-width="25px" max-height="25px" height="100px" src="@/assets/location.svg" position="center center" align="center" v-on:click="updateMarker(index)"/>
                  </div>
                </div>
              </div>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>

<script>

import { mapGetters } from 'vuex'
import axios from 'axios'

export default {
  name: 'Index',
  data: function () {
    return {
      covidStatus: null,
      covidMarkers: null,
      current: 0
    }
  },
  computed: {
    ...mapGetters([
      'getLoginId'
    ])
  },
  methods: {
    getCovidStatus: function () {
      axios.get('http://127.0.0.1:7777/craw/status').then(res => {
        if (res.status === 200) {
          this.covidStatus = res.data
        }
      }).catch(err => {
        console.log(err)
      })
    },
    getCovidMarkers: function () {
      axios.get('http://127.0.0.1:7777/craw/markers').then(res => {
        if (res.status === 200) {
          this.covidMarkers = res.data
          this.firstInitMap(res.data[0].positionX, res.data[0].positionY)
        }
      }).catch(err => {
        console.log(err)
      })
    },
    firstInitMap: (x, y) => {
      window.kakao.maps.load(function () {
        const mapContainer = document.getElementById('map')
        const position = new window.kakao.maps.LatLng(x, y)

        const mapOption = {
          center: position,
          level: 3
        }

        const map = new window.kakao.maps.Map(mapContainer, mapOption)
        window.map = map

        const marker = new window.kakao.maps.Marker({
          position: position
        })

        marker.setMap(map)
        window.center = marker
      })
    },

    updateMarker: function (index) {
      console.log('is event')
      if (window.map !== null) {
        window.center.setMap(null)

        const x = this.covidMarkers[index].positionX
        const y = this.covidMarkers[index].positionY

        const position = new window.kakao.maps.LatLng(x, y)
        const marker = new window.kakao.maps.Marker({
          position: position
        })

        marker.setMap(window.map)
        window.center = marker
        window.map.setCenter(position)
        this.current = index
      }
    },
    checkContainsStr: function (str) {
      if (str.includes('+')) {
        return 'red-text'
      } else {
        return 'blue-text'
      }
    },
    checkCurrentIndex: function (index) {
      if (this.current === index) {
        return 'select-item'
      } else {
        return ''
      }
    }
  },
  mounted: function () {
    const script = document.createElement('script')
    script.type = 'text/javascript'
    script.src = '//dapi.kakao.com/v2/maps/sdk.js?appkey=27182d803bc31145e52687dda5546c30&autoload=false&libraries=services'
    // script.src = '//dapi.kakao.com/v2/maps/sdk.js?appkey=27182d803bc31145e52687dda5546c30&libraries=services'
    document.head.append(script)
    this.getCovidStatus()
    this.getCovidMarkers()
  }
}
</script>
<style>
  .status-data {
    display: inline-block;
  }

  .status-data > p {
    margin-bottom: 5px;
  }

  .marker-data {
    width: 100%;
    height: 100px;
  }

  .red-text {
    color: red;
  }

  .blue-text {
    color: blue;
  }

  .place-width {
    width: 30%;
    text-align: center;
    display: inline-block;
  }

  .icon-width {
    width: 10%;
    text-align: center;
    display: inline-block;
  }

  .select-item {
    background: lightskyblue;
  }
</style>
