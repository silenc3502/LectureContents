  // script 안에 자바스크립트를 적는다.
  // 동적인 작업내용
  // 자바스크립트 = 스레드 비동기 방식으로 동작한다.
  // 사실 상 모두 비동기 방식으로 동작함
    var heading = document.querySelector('#heading');

    heading.onclick = function () {
        heading.style.color = "red";
    }

    // 자바스크립트 UI에 영향을 줄 수 있는 동작의 데이터를 제어함