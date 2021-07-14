<template>
    <div>
        <fantasy-world></fantasy-world>
        <attack-monster v-on:useSkill="calcDamage"></attack-monster>
        <!-- useSkill이 동작함을 감지함과함께 도착하는 값은 AttackMonster컴포넌트에 메소드에서 emit의 첫 번째 인자값이다. -->
         <p>Monster.HP{{ monster.hp }}</p>
         <monster-input
            v-on:addMonster="onAddMonster">
         </monster-input>
         <monster-list
            v-on:killMonster="onkillMonster"  
            v-on:editName="onEditName">
        </monster-list>
    </div>
</template>

<script>

import FantasyWorld from '../components/prob82/FantasyWorld.vue'
import AttackMonster from '../components/prob82/AttackMonster.vue'
import MonsterList from '../components/prob82/MonsterList.vue'
import MonsterInput from '../components/prob82/MonsterInput.vue'
import { mapActions } from 'vuex'

export default {
    name: 'Prob82',
    components: {
        'fantasy-world': FantasyWorld,
        'attack-monster': AttackMonster,
        'monster-list': MonsterList,
        'monster-input': MonsterInput
    },
    data() {
        return {
            monster: {
                hp: 100
            }
        }
    },    
    methods: {
        ...mapActions([
            'addMonster',
            'killMonster',
            'save'
        ]),
        calcDamage(content) {
            //calcDamge는 useSkill에서 emit 인자값으로 전송한 값을 ()안 content로 받는다.
            const skillDam = { content }     
            this.monster.hp -= skillDam.content
            //skillDam의 값에 인자값을 넣고 활용할 시에는 변수 이름 뒤에 .content을 붙어주어야한다.
        },
        onkillMonster(monsterId) {
            this.killMonster(monsterId)
            this.save()
        },
        onAddMonster() {
            const monsterElement = { name }
            this.addMonster(monsterElement)
            this.save()
        }
    }
}
</script>



