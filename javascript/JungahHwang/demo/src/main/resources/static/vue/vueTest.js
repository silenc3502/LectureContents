var app = new Vue ({
    // id = "app"과 맵핑
    el: '#app',
    data: {
        message: '과일 리트스',
        initMsg: '양방향이란!!??',
        list: ["사과", "바나나", "망고", "딸기", "수박", "참외", "포도", "블루베리", "체리"],
        show: true,
        num: 3,
        randomNumber: 0,
        count: 0,
        radius: 50,
        monsterName: '',
        monsters: [
            { id: 1, name: '슬라임', hp: 30 },
            { id: 2, name: '고블린', hp: 50 },
            { id: 3, name: '드래곤', hp: 999999 }
        ]
    },
    methods: {
        buttonClickTest: function (event) {
            alert('신기해!')
        },
        increment: function() {
            this.count += 1
        },
        addMonster: function (){
            // 샘플용 코드
            var arr = [1, 2, 3, 4];
            // reduce (function(유지되는 값, 반복하며 비교하거나 연산대상이 되는 값))
            var sum = arr.reduce( function (accumulator, currentValue ){
                return accumulator + currentValue
            }, 0)

            alert(sum)

            // reduce(): 내부에 있는 요소를 전부 낱개로 쪼개서 하나하나 비교
            //           전제 순회를 끝낼 때까지 동작이 값이 증발되지 않으며 
            //           최종 결과를 얻을 때까지 이전 결과를 유지하며 연산이 진행
            // function(a, b)에 입력으로 들어가는 a, b는 모두 monsters 배열에 있는 각각의 낱개 요소들이다.
            // 낱개 단위로 끝까지 비교를 하면 마지막엔 제일 큰 숫자(마지막 요소)를 얻게 됨
            var max = this.monsters.reduce( function (a, b) {
                return a > b.id ? a : b.id
            }, 0)

            this.monsters.push(
                { id: max + 1, name: this.monsterName, hp: 500 }
            )
        },
        removeMonster: function (index) {
            // 찾은 인덱스 값에서 1개를 지워라
            // 인덱스 값의 정보를 지워라
            this.monsters.splice(index, 1)
        },
        userAttack: function (index) {
            this.monsters[index].hp -= 10
        },
        randomGeneration () {
            this.randomNumber = Math.floor(Math.random() * 10) + 1
        }
    },

    // create, mount: 창 실행과 동시에 동작하고 사라짐
    beforeCreate() {
        console.log('Vue 객체를 만들기 전입니다.')
    },
    created() {
        console.log('Vue 객제를 만들었습니다.')
    },
    beforeMount() {
        console.log('HTML 요소를 붙이기 전입니다.')
    },
    mounted() {
        console.log('HTML 요소를 붙입니다.')
    },

    // update: 창에서 동작하는 것들을 감지함
    beforeUpdate() {
        console.log('VDOM의 변화를 감지합니다.')

        // userAttack에 넣지 않고 update에 넣는 이유
        // -> update는 critical section을 보호해줌
        for(var i = 0; i < this.monsters.length; i++){
            if(this.monsters[i].hp <= 0){
                this.monsters.splice(i, 1)
            }
        }
    },
    updated() {
        console.log('VDOM의 변화를 적용합니다.')
    },
    beforeDestroy() {
        console.log('Vue 객체를 파괴하기 전입니다.')
    },
    destroyed() {
        console.log('Vue 객체를 파괴하였습니다.')
    }
})