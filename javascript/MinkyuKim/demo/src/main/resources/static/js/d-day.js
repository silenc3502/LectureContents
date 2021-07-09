// 오늘 날짜 정보
var now = new Date();
// 처음 만난 날짜 정보
var firstDay = new Date("2008-10-23");
// 오늘날짜 정보를 컴퓨터가 계산하는 숫자 정보로 변환(정확하게 ms 단위로 바꿈)
var toNow = now.getTime();
// 처음 만난 날짜를 컴퓨터가 계산하는 숫자 정보로 변환
var toFirst = firstDay.getTime();
// 오늘 날짜 - 첫 만남
var passedTime = toNow - toFirst;
//다시 날짜로 변환
// Math.round(반올림) : 12시간이 지나면 반올림 처리
var passedDay = Math.round(passedTime / (24 * 60 * 60 * 1000));

// 몇일이 되었습니다.(만난지 ~~~~일)
document.querySelector('#accent').innerText = passedDay + "일";

calcDate(100);
calcDate(200);
calcDate(365);
calcDate(500);

function calcDate(days) {
    var future = toFirst + days * (1000 * 60 * 60 * 24);
    // 날짜로 변환시키기 위해
    var someday = new Date(future);

    var year = someday.getFullYear();
    var month = someday.getMonth() + 1;
    var date = someday.getDate();

    document.querySelector("#date" + days).innerText =
          year + "년 " + month + "월 " + date + "일";

    // <li class="item-date" id="date100"></li> 의 비어있는 곳에 들어가게된다.
}

