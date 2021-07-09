var app = new Vue ({

    el: '#app',
    //el은 쿼리셀렉터같은 역할이다.

    data: {
        message: 'ㄹㄹㄹㄹㄹㄹㄹㅌㅌㅌㅌ ',
        initMsg: "This is bothways connection.",
        list: ['A', 'B', 'C', 'D', 'E'],
        show: true,
        num: 3,
        count: 0,
        radius: 50,
        color: 'red', //' '를 해주어야했다.
        monsterName: "크앙",
        monsters: [
            { id: 1, name: 'Balog', hp: 90 },
            { id: 2, name: 'Zombie', hp: 15 },
            { id: 3, name: 'Goul', hp: 30 }
        ]
    },
    methods: {
        buttonClickTest() {
            //alert(event.target)
            alert("나는 정상 쑤")
        },
        increment() {
            this.count += 1
        },
        addMonster: function() {
            var arr = [1, 2, 3, 4];
            var sum = arr.reduce(function (num, target) {
                alert(num + ", " + target)
                return num + target
            }, 4)
            alert(sum)

            var max = this.monsters.reduce( function (a, b) {
                return a > b.id ? a : b.id
                //a < b.id ? a : b.id --> 요렇게하면 가장 작은 숫자가 출력됨.
                //위 방식으로 해석하면 b가 더 크면 a를 반환하라는 뜻이다. 그래서 계속 결과값은 0이된다.
                }, 0) //마지막에 0은 시작값!

                this.monsters.push({
                    id: max + 1,
                    name: this.monsterName,
                    hp: 600
            })
        },
        removeMonster: function(index) {
            this.monsters.splice(index, 1);
        },
        userAttack: function(index)  {
            this.monsters[index].hp -= 10
            if(this.monsters[index].hp <= 0) {
                this.monsters.splice(index, 1)
            }
        }
    },
     beforeCreate() {
            console.log('Vue 객체를 만들기 이전입니다.')
        },
        created() {
            console.log('Vue 객체를 만들었습니다.')
        },
        beforeMount() {
            console.log('HTML 요소를 붙이기 전입니다.')
        },
        mounted() {
            console.log('HTML 요소를 붙입니다.')
        },
        beforeUpdate() {
            console.log('VDOM의 변화를 감지합니다.')
//            var i
//                    for (i = 0; i < this.monsters.length; i++) {
//                        if (this.monsters[i].hp <= 0) {
//                            this.monsters.splice(i, 1)
//                        }
//                    }
        },
        updated() {
            console.log('VDOM의 변화를 적용합니다.')
        },
        beforeDestroy() {
            console.log('Vue 객체를 파괴하기 이전입니다.')
        },
        destroyed() {
            console.log('Vue 객체를 파괴하였습니다.')
        } //얘네는 vue에서 기본으로 만들어진 메소드, beforeDestroy(), destroyed()는 확인할 수 없나?
})