var prob77 = new Vue ({

    el: '#prob77',

    data: {
        ranNum: Math.floor(Math.random() * 10) + 1,
        summonedCreatures: [

        ],
        creatures: [
            { id: 1, name: 'crow', hp: 50},
            { id: 2, name: 'skeleton', hp: 70},
            { id: 3, name: 'zombie', hp: 80},
            { id: 4, name: 'balog', hp: 180},
            { id: 5, name: 'demon', hp: 160},
            { id: 6, name: 'andariel', hp: 750},
            { id: 7, name: 'duriel', hp: 1400},
            { id: 8, name: 'mephisto', hp: 1800},
            { id: 9, name: 'diablo', hp: 3000},
            { id: 10, name: 'baal', hp: 2600}
        ]
    },
    methods: {

        showCreature(ranNum) {
            this.ranNum = Math.floor(Math.random() * 10) + 1;
            //1~10까지 나옴. 그러나 배열은 0~9 칸으로 구성됐기 때문에, -1을 해주어야함.

            var max = this.summonedCreatures.reduce( function(a, b) {
                return a > b.id ? a : b.id
            }, 0)

            this.summonedCreatures.push({
                id: max + 1,
                name: this.creatures[ranNum-1].name,
                hp: this.creatures[ranNum-1].hp
            })
        },

        normalAttack(index) {
            this.summonedCreatures[index].hp -= 25
        },
        ultimateAttack(index) {
            this.summonedCreatures[index].hp -= 500
        }
    },
    beforeUpdate() {
        for(var i=0; i<this.summonedCreatures.length; i++) {
            if(this.summonedCreatures[i].hp <= 0) {
                this.summonedCreatures.splice(i, 1)
            }
        }
    }
})