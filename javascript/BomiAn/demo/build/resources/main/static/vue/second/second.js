var app = new Vue ({
  el: '#app',
  data: {
    message: "우왕 뷰 짱",
    initMsg: '양방향 연결이 뭔지 함 볼까 ?',
    list: ['사과', '바나나', '딸기', '수박', '참외', '포도', '멜론', '망고', '블루베리', '체리'],
    show: true,
    num: 3,
    count: 0,
    randomNumber: 0,
    usersPoint: 1000,
    radius: 50,
    monsterName: '',
    monsters: [
      {id: 1, name: '슬라임', hp: 30, point: 100},
      {id: 2, name: '고블린', hp: 50, point: 250},
      {id: 3, name: '카오스드래곤', hp: 99999999, point: 1000000 }
    ],
    showMonsters: [
      { name: '슬라임', hp: 30, point: 100}, 
      { name: '고블린', hp: 50, point: 250},
      { name: '카오스드래곤', hp: 99999999, point: 1000000},
      { name: '고블린', hp: 800, point: 2400},
      { name: '울프도그', hp: 500, point: 1800},
      { name: '타이거', hp: 99999, point: 30000},
      { name: '샤카라', hp: 200, point: 2000},
      { name: '킹콩', hp: 10000, point: 20000},
      { name: '푸링', hp: 40, point: 100},
      { name: '파이리', hp: 100, point: 500}
    ],

  },
  methods: {
    buttonClickTest: function (event) {
      alert('뷰형님 짱')
    },
    increment: function() {
      this.count += 1
    },
    randMonster: function() {
      this.usersPoint -= 50
      var randMon = this.showMonsters[Math.floor(Math.random() * 10 + 1)]
      var max = this.monsters.reduce(function (a, b) {
        return a > b.id ? a : b.id
      }, 0)

      this.monsters.push({
        id:max + 1,
        name: randMon.name,
        hp: randMon.hp,
        point: randMon.point
      })
      alert(randMon.name + ' 몬스터를 추가했습니다.')
    },
    addMonster: function() {
      this.usersPoint -= 100
      var max = this.monsters.reduce(function (a, b) {
        return a > b.id ? a : b.id
      }, 0)

      this.monsters.push({
        id:max + 1,
        name: this.monsterName,
        hp: Math.floor(Math.random() * 100000 + 10),
        point: Math.floor(Math.random() * 1000000 + 20)
      })
    },
    removeMonster: function(index) {
      this.monsters.splice(index, 1)
    },
    
    userAttack: function (index) {
      this.monsters[index].hp -= 10
    },
    randomGeneration () {
      this.randomNumber = Math.floor(Math.random() * 10) + 1
    }

  },

  beforeCreate() {
    console.log('Vue 객체 만들기 이전입니다.')
    
  },
  created() {
    console.log('Vue 객체를 만들었습니다.')
  },
  beforeMount() {
    console.log('HTML 요소를 붙이기 전입닙니다.')

  },

  mounted() {
    console.log('HTML 요소를 붙입니다.')
  },
  beforeUpdate() {
    console.log('VDOM의 변화를 감지합니다.')
    
  },
  updated() {
    console.log('VDOM의 변화를 적용합니다.')
    var i 
    for (let i = 0; i< this.monsters.length; i++) {
      if(this.monsters[i].hp <= 0) {
        this.usersPoint += this.monsters[i].point
        alert(this.monsters[i].name + '을 공략했습니다. 획득 point = ' + this.monsters[i].point)
        this.monsters.splice(i, 1)
      }
     
    }
  },
  beforeDestroy() {
    console.log('Vue 객체를 파괴하기 이전입니다.')
  },
  destroyed() {
    console.log('Vue 객체를 파괴합니다.')
  },
})