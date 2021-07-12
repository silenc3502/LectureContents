//구매하기 인벤토리 넣기
//장비 장착 그림 보기
//장착하고 나서 해제 한후에 장착 가능
//능력치 올리기

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
        shopView: false,
        purchaseSum: 0,
        totalsum: 0,
        InvenView: false,
        bugFix: 0,
        addList: [],
        shopList: [],
        shopListValue: [],
        addAtk: 0,
        equipment: [],
        Inventory: [
            { name: "기본칼", desc: "무기", atk: 5, price: 200}
        ],
        characterStatus:
            {
                level: 1,
                hp: 70,
                mp: 30,
                atk: 10,
                str: 10,
                int: 10,
                def: 10,
                dex: 10,
                vit: 10,
                men: 0,
                money: 50,
                totalLevelBar: 10,
                currentLevelBar: 0,
                needExp: 0,
                //레벨업하면 초기화
                //hp만큼 레벨 바 증가
                //레벨업하면 데미지 증가 *1.25
            }
        ,

        monsters: [
            { id: 1, name: '슬라임', hp: 30 , exp: 1, money: 5},
            { id: 2, name: '고블린농민', hp: 50, exp: 50, money: 5},
            { id: 3, name: '카오스 드래곤', hp: 99999999, exp: 5555555, money: 5}
        ],

        monsterBook: [
            { name: '슬라임', hp: 30 , exp: 1, money: 5},
            { name: '고블린농민', hp: 350,  exp: 21, money: 20},
            { name: '레드 슬라임', hp: 70, exp: 50, money: 30},
            { name: '홉 고블린', hp: 120, exp: 40, money: 55},
            { name: '스켈레톤', hp: 200, exp: 30, money: 100},
            { name: '고블린 마법사', hp: 250, exp: 50, money: 200},
            { name: '고블린 제사장', hp: 500, exp: 100, money: 300},
            { name: '오우거 메이지', hp: 1500, exp: 200, money: 3500},
            { name: '귀인', hp: 2000, exp: 880, money: 3500},
            { name: '킹 슬라임', hp: 3000, exp: 85, money: 2500},
            { name: '고스트', hp: 3200, exp: 4, money: 3500},
            { name: '카오스 드래곤', hp: 99999999 , exp: 3000, money: 1500},
            { name: '리무르', hp: 999999999999999 , exp: 5000000, money: 2500}
        ],

        itemBook: [
            { name: '포션I', price: 200, effect: {desc: 'hp회복', amount: 200}},
            { name: '포션II', price: 700, effect: {desc: 'hp회복', amount: 700}},
            { name: '포션III', price: 2000, effect: {desc: 'hp회복', amount: 2000}},
            { name: '포션IV', price: 4000, effect: {desc: 'hp회복', amount: 4000}},   
            { name: '포션V', price: 6000, effect: {desc: 'hp회복', amount: 6000}},
            { name: '검', price: 5000, effect: {desc: '무기', atk: 100}},
            { name: '강철검', price: 5000000, effect: {desc: '무기', atk: 200}},
            { name: '환두대도', price: 500000000, effect: {desc: '무기', atk: 350}},
            { name: '발라리아 강철검', price: 1200000000, effect: {desc: '무기', atk: 500}},
            { name: '칠지도', price: 100000000000, effect: {desc: '무기', atk: 1000}},


        ]




    },
    methods: {
        equip() {
            for ( var i = 0 ; i < this.equipment.length; i++) {
                this.addAtk = parseInt(this.equipment[i])
            }
            alert(this.addAtk)
            this.characterStatus.atk += this.addAtk

        },
        shuffleShopList(){
            if (!this.shopView){
                this.shopListValue = []
            }
            for( var i = 0; i < 10; i++) {
                // var randIdx = Math.floor(Math.random() * this.itemBook.length)
                this.shopList[i] = this.itemBook[i]
            }
        },
        MDG () {
            for (var i = 0; i < this.monsters.length; i++){
                this.monsters[i].hp = parseInt(this.monsters[i].hp - this.characterStatus.atk * 3.5)
            }
        },

        purchase() {
            this.purchaseSum == 0
            
            for (var j = 0 ; j < this.shopListValue.length; j++) {
                this.purchaseSum += this.shopListValue[j].price
                alert(this.purchaseSum)
            }
            if (this.characterStatus.money >= this.purchaseSum){
                for (var i = 0 ; i <= this.shopListValue.length ; i++) {
                    this.Inventory.push( {
                        name: this.shopListValue[i].name,
                        desc: this.shopListValue[i].effect.desc,
                        atk: this.shopListValue[i].effect.atk,
                        price: this.shopListValue[i].price
                    })
                    this.characterStatus.money -= this.shopListValue[i].price
                    alert("구매완료")   
            }   
            alert(this.shopListValue.length)
            }else {
                alert("소지금 부족")
                alert(this.shopListValue.length)
   
            }



        },

        // addManyMonster: function () {
        //     for (var i = 0 ; i < 100; i++){
        //         this.addMonster();
        //     }
        // },
      
        // purchase() {
 
        //         for (var i ; i < this.shopListValue.length; i++){
        //             this.purchaseSum += this.shopListValue[i].price
        //             alert(this.purchaseSum)
        //     }
        //     // if ( this.characterStatus.money <= this.purchaseSum ) {
        //     //     alert("소지금 부족")
        //     // } else {
        //     //     this.characterStatus.money -= this.purchaseSum
        //     // }
        //     // this.purchaseSum == 0

      
        // },


        buttonClickTest: function (event) {
            alert('뷰 짱')
        },
        increment: function () {
            this.count += 1
        },
        
          

        addMonster: function () {
        
        
            var max = this.monsters.reduce( function (a, b) {
                return a > b.id ? a : b.id
            }, 0)
            
  
            var randNum = Math.floor(Math.random() * 10) + 1;

            this.monsters.push( {
                id: max + 1,
                name: this.monsterBook[randNum].name,
                hp: this.monsterBook[randNum].hp,
                exp: this.monsterBook[randNum].exp
            })
        },

        // addInventory: function() {
        //     var r_num = Math.floor(Math.random() * 5) + 1
        //     return this.Inventory[this.itemList[r_num]
        // },

        addManyMonster: function () {
            // 100마리씩 추가
            for (var i = 0; i < 100; i++) {
                var max = this.monsters.reduce( function (a, b) {
                    return a > b.id ? a : b.id
                }, 0)

                var monBookLen = this.monsterBook.length
                var idx = Math.floor(Math.random() * monBookLen)

                this.monsters.push({
                    id: max + 1,
                    name: this.monsterBook[idx].name,
                    hp: this.monsterBook[idx].hp
                })
            }
        },
        removeMonster: function (index) {
            this.monsters.splice(index, 1);
        },
        userAttack: function (index) {
            this.monsters[index].hp -= this.characterStatus.atk
        },
        randomGeneration () {
            this.randomNumber = Math.floor(Math.random() * 10) + 1;
            
        },
        // itemRandomNumberGeneration () {
        //     return this.randomGeneration = Math.floor(Math.random() * this.itemList.length) + 1;
        // }
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

        var i
        for (i = 0; i < this.monsters.length; i++) {
            if (this.monsters[i].hp <= 0) {
                // 몬스터 제거 이전에 무엇을 해야할까요 ? 경험치 획득
                for (var j = 0; j < this.monsterBook.length; j++) {
                    if (this.monsters[i].name === this.monsterBook[j].name) {
                        this.criteria += this.monsterBook[j].exp
                        this.characterStatus.money += this.monsterBook[j].money
                    }
                }

                this.monsters.splice(i, 1)
            }
        }


    
  
  

        var criteria = this.characterStatus.currentLevelBar

        for (; this.criteria >= this.characterStatus.totalLevelBar; ) {
            this.criteria =
                parseInt(this.criteria - 
                    this.characterStatus.totalLevelBar)
            this.characterStatus.level += 1
            this.characterStatus.hp *= 1.2
            this.characterStatus.atk += 3
            this.characterStatus.def += 1

            // 레벨링 시스템 구축
            if (this.characterStatus.level < 10) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.1)
            } else if (this.characterStatus.level < 20) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.2)
            } else if (this.characterStatus.level < 30) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.3)
            } else if (this.characterStatus.level < 40) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.4)
            } else if (this.characterStatus.level < 50) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.5)
            } else if (this.characterStatus.level < 80) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.7)
            } else if (this.characterStatus.level < 100) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 2)
            }
           
        }
        this.characterStatus.needExp = Math.abs(this.characterStatus.totalLevelBar - this.criteria) 

    },
    
    updated() {
        console.log('VDOM의 변화를 적용합니다.')
    },
    beforeDestroy() {
        console.log('Vue 객체를 파괴하기 이전입니다.')
    },
    destroyed() {
        console.log('Vue 객체를 파괴하였습니다.')
    }
})