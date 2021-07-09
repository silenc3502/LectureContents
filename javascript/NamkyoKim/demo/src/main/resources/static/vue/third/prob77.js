var app = new Vue ({ 
    el: '#app',
    data: {
        randomNumber: 0,
        monsters: [
            { id: 1, name: '슬라임', hp: 30 },
            { id: 2, name: '고블린', hp: 50 },
            { id: 3, name: '카오스 드래곤', hp: 9999999 },
            { id: 4, name: '자쿰', hp: 1500 },
            { id: 5, name: '주황버섯', hp: 100 },
            { id: 6, name: '머쉬맘', hp: 300 },
            { id: 7, name: '빨간달팽이', hp: 10 },
            { id: 8, name: '핑크빈', hp: 99999999 },
            { id: 9, name: '발록', hp: 1000 },
            { id: 10, name: '드레이크', hp: 800 }
        ]
    },

    methods: {
        randomGeneration (){
            this.randomNumber = Math.floor(Math.random() * 10) + 1;
        },
        summonsMonster: function(){
            monsters[randomNumber]
            }
        },
        userAttack: function(index){
            this.monsters[index].hp -= 10
        },
        

    })
