<template>
    <button @click="addManyMonster">{{ counter }}</button>
</template>

<script>
export default {
    name: 'global-component',
    props: ['monsterBook'],
    data () {
        return {
            counter: this.monsterBook [
            { name: '슬라임', hp: 30, exp: 1000, money: 10 },
            { name: '고블린', hp: 50, exp: 2000, money: 20 },
            { name: '레드 슬라임', hp: 70, exp: 4000, money: 400 },
            { name: '홉 고블린', hp: 120, exp: 8000, money: 800 },
            { name: '그린 슬라임', hp: 150, exp: 12000, money: 1600 },
            { name: '스켈레톤', hp: 200, exp: 20000, money: 32000 },
            { name: '고블린 마법사', hp: 250, exp: 25000, money: 640 },
            { name: '블루 슬라임', hp: 300, exp: 35000, money: 1280 },
            { name: '트롤', hp: 500, exp: 50, money: 2000 },
            { name: '원혼', hp: 700, exp: 60, money: 4000 },
            { name: '고블린 족장', hp: 800, exp: 70, money: 5000 },
            { name: '스켈레톤 기사', hp: 1000, exp: 80, money: 10000 },
            { name: '오우거', hp: 1200, exp: 90, money: 12000 },
            { name: '오우거 메이지', hp: 1500, exp: 100, money: 15000 },
            { name: '스켈레톤 근위병', hp: 2000, exp: 120, money: 20000 },
            { name: '고블린 챔피언', hp: 2200, exp: 130, money: 30000 },
            { name: '고블린 대사장', hp: 2500, exp: 150, money: 25000 },
            { name: '귀인', hp: 2800, exp: 180, money: 28000 },
            { name: '킹 슬라임', hp: 3000, exp: 200, money: 30000 },
            { name: '고스트', hp: 3200, exp: 250, money: 32000 },
            { name: '리치', hp: 9000, exp: 500, money: 90000 },
            { name: '메탈 슬라임', hp: 12000, exp: 7000, money: 100000 },
            { name: '리치 킹', hp: 90000, exp: 2500, money: 900000 },
            { name: '뱀파이어 로드', hp: 150000, exp: 7500, money: 1200000 },
            { name: '이무기', hp: 300000, exp: 10000, money: 1500000 },
            { name: '악마', hp: 400000, exp: 15000, money: 1500000 },
            { name: '악마사냥꾼', hp: 500000, exp: 20000, money: 1500000 },
            { name: '날아다니는 스파게티 괴물', hp: 600000, exp: 30000, money: 1500000 },
            { name: '신?', hp: 666666, exp: 66666, money: 666666 },
            { name: '카오스 드래곤', hp: 99999999, exp: 10000000, money: 100000000 },
            { name: '리무루 템페스트', hp: 999999999999999, exp: 999999999, money: 9999999999 }
        ]
        }
    },
    methods: {
        addManyMonster () {
           for (var i=0; i<100; i++){
                var max = this.monsters.reduce(function(a, b) {
                    return a > b.id ? a: b.id
                }, 0)

                var monBookLen = this.monsterBook.length
                var idx = Math.floor(Math.random() * monBookLen)

                this.monsters.push({
                    id: max + 1,
                    name: this.monsterBook[idx].name,
                    hp: this.monsterBook[idx].hp,
                    money: this.monsterBook[idx].money
                })
            }
        }
    }
}


</script>