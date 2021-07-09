var state = 1;

function toggleButton () {
    //여러개(전부를) 알아내야 하기 때문에 SelectorAll
    // #vueapp p를 통해 id값 vueapp의 p값을 가져온다.
    var list = document.querySelectorAll('#vueapp p');
    // alert(list); 해당 경고가 나온다면 동작한다는 것을 확인. 디버깅

    for(var i = 0; i < list.length; i++) {
        // state 값이 0이면 짝수 번째, 1이면 홀수 번째
        // 루프 전체는 6개
        // 1이면 - 1, 3, 5 키고, 0, 2, 4 끄고
        // 0이면 - 0, 2, 4 키고, 1, 3, 5 끄고

        // 0이면 거짓, 0이 아니면 참 (나머지값을 의미, 자바와 달리 자바스크립트는 c언어를 기반으로 되어있어서 다른 문법)
        // 참이 부정ㅍ(!)이 되어 else로 가게됨.
        // (1-1 / 2-0
        if (!((i + state) % 2)) {                   // 0이면인데 !(부정)으로 0이아니어야 참. 0이어야 거짓
            list[i].style.visibility = "visible";
        } else {
            list[i].style.visibility = "hidden";
        }
    }

        // 여러번 눌러도 되게끔. 토글시킴.
        // 토글 : 하나의 설정 값으로부터 다른 값으로 전환하는 것이다. 토글 스위치는 두 가지 상태만을 가지고 있는 스위치

    if (state ==1) {
        state = 0;
    } else {
        state = 1;
    }
}
