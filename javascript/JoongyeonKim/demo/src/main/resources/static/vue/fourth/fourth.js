var app = new Vue ({
    el: "#app",  // html 파일에 있는 id랑 맵핑이 되는것이 el이다 (쿼리셀렉터 같은 느낌)
    data: {
        val: true,
        groupVal: [],
        radioGroupVal: '',
        selectVal: [],
        selectOnce: ''
    },
    methods: {

    },
    beforeCreate() {
        console.log("Vue 객체를 만들기 이전입니다")
    },
    created() {
        console.log("Vue 객체를 만들었습니다")
    },
    beforeMount() {
        console.log("HTML 요소를 붙이기 전입니다")
    },
    mounted() {
        console.log("HTML 요소를 붙입니다")
    },
    beforeUpdate() {
        console.log("VDOM의 변화를 감지합니다.")
    },
    updated() {
        console.log("VDOM의 변화를 적용합니다.")
    },
    beforeDestory() {
        console.log("Vue 객체를 파괴하기 이전입니다.")
    },
    destoryed() {
        console.log("Vue 객체를 파괴하였습니다.")
    }
})