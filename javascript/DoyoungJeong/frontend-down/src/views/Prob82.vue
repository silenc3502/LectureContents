<template>
    <div>
        <fantasy-world></fantasy-world>
        <attack-monster v-on:useSkill="calcDamage"></attack-monster>
        <!-- useSkill이 동작함을 감지함과함께 도착하는 값은 AttackMonster컴포넌트에 메소드에서 emit의 첫 번째 인자값이다. -->
         <p>Monster.HP{{ monster.hp }}</p>
    </div>
</template>

<script>

import FantasyWorld from '../components/prob82/FantasyWorld.vue'
import AttackMonster from '../components/prob82/AttackMonster.vue'

export default {
    name: 'Prob82',
    components: {
        'fantasy-world': FantasyWorld,
        'attack-monster': AttackMonster,
    },
    data() {
        return {
            monster: {
                hp: 100
            }
        }
    },    
    methods: {
        calcDamage(content) {
            //calcDamge는 useSkill에서 emit 인자값으로 전송한 값을 ()안 content로 받는다.
            const skillDam = { content }     
            this.monster.hp -= skillDam.content
            //skillDam의 값에 인자값을 넣고 활용할 시에는 변수 이름 뒤에 .content을 붙어주어야한다.
        }
    }
}
</script>



