var app = new Vue ({
    el: '#app',
    data: {
        val: true,
        groupVal: [],
        // radio는 보통 단일선택 하기 때문에 배열이 아닌 문자로
        radioGroupVal: '',
        selectVal: [],
        selectOnce: ''
    }
})
