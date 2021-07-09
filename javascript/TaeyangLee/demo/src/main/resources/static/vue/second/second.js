var app = new Vue ({
    el: '#app',
    data: {
        message: '우왕 뷰 짱',
        initMsg: '양방향 연결이 뭔지 함 볼까 ?',
        list: ['사과', '바나나', '딸기', '수박', '참외', '포도', '망고', '블루베리', '체리'],
        show: true,
        num: 3,
        count: 0,
        radius: 50,
        randomNumber: 0,
        monsterName: '',
        monsterbook: [
            {id: 1, name: '슬라임', hp: 30},
            {id: 2, name: '고블린', hp: 50},
            {id: 3, name: '카오스 드래곤', hp: 9999999},
            {id: 4, name: '주황버섯', hp: 50},
            {id: 5, name: '골렘', hp: 5000},
            {id: 6, name: '달팽이', hp: 20},
            {id: 7, name: '켄타우로스', hp: 50000},
            {id: 8, name: '스켈레톤', hp: 200000},
            {id: 9, name: '리본돼지', hp: 200},
            {id: 10, name: '크림슨 발록', hp: 1000000}
        ],
        monsters: [
            {id: 1, name: '슬라임', hp: 30},
            {id: 2, name: '고블린', hp: 50},
            {id: 3, name: '카오스 드래곤', hp: 9999999},
            {id: 4, name: '주황버섯', hp: 50},
            {id: 5, name: '골렘', hp: 5000},
            {id: 6, name: '달팽이', hp: 20},
            {id: 7, name: '켄타우로스', hp: 50000},
            {id: 8, name: '스켈레톤', hp: 200000},
            {id: 9, name: '리본돼지', hp: 200},
            {id: 10, name: '크림슨 발록', hp: 1000000}

        ]
    },
    methods: {
        // event: 사용자가 어떤 이벤트를 발생시켰는지 알 수 있음
        buttonClickTest: function (event) {
            alert('뷰 짱')
        },
        // 작성 형식
        // 함수 이름: function () {} ===> 중괄호 내부는 일반 매서드 작성과 동일
        increment: function () {
            this.count += 1
        },
        addMonster: function() {
           /*샘플용
            var arr = [1,2,3,4];
            var sum = arr.reduce( function (accumulator, currentValue){
                    return accumulator+currentValue
            }, 0)
            alert(sum)*/
            //reduce()를 사용하면 알아서 내부에 있는 요소를 전부 낱개로 쪼개서
            //하나하나 비교하게됨
            //그래서 function(a,b)에 입력으로 들어가는 a,b는
            //모두 monsters 배열에 있는 각각의 낱개 요소들임

            //reduce는 전체 순회를 끝낼떄까지 동작이 값이 증발되지 않으며
            //최종 결과를 얻을때까진 이전결과를 유지하며 연산이 진행됨
            var max = this.monsters.reduce( function(a,b) {
                return a > b.id ? a : b.id
            }, 0)

           this.monsters.push({
                id: max+1,
                name: this.monsterName,
                hp: monster
            })
        },
        removeMonster: function(index) {
            //찾은 인덱스 값에서 1개를 지워라
            //즉 인덱스 값으 정보를 지워라
            this.monsters.splice(index, 1);
        },
        userAttack: function(index) {
            this.monsters[index].hp -= 10
        },
        
        randomGeneration () {
            //1부터 10까지 난수를 생성합니다.
            this.randomNumber = Math.floor(Math.random() * 10) + 1;
        }
    },
    beforeCreate() {
        console.log('Vue 객체를 만들기 이전입니다')
    },
    created() {
        console.log("Vue 객체를 만들었습니다")
    },
    beforeMount() {
        console.log('HTML 요소를 붙히기 전입니다')
    },
    mounted() {
        console.log('HTML 요소를 붙힙니다')
    },
    beforeUpdate() {
        console.log("VDOM의 변화를 감지합니다")
        var i
        for(i = 0; i < this.monsters.length; i++){
            if (this.monsters[i].hp <= 0){
                this.monsters.splice(i, 1)
            }
        }
    },
    updated() {
        console.log("VDOM의 변화를 적용합니다")
    },
    beforeDestroy() {
        console.log("Vue 객체를 파괴하기 이전입니다.")
    },
    destroyed() {
        console.log("Vue 객체를 파괴하였습니다.")
    }
})