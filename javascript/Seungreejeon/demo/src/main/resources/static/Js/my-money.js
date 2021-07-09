// 오늘 날자 정보
var now = new Date();
// 처음 만난 날자 정보
var firstDay = new Date("2008-10-23");
// 오늘 날자 정보를 컴퓨터가 계산하는 숫자 정보로 변환
var toNow = now.getTime();
// 처음 만난 날자를 컴퓨터가 계산하는 숫자 정보로 변환
var toFirst = firstDay.getTime();
// 오늘 날자 - 첫 만남
var passedTime = toNow - toFirst;
// 다시 날자로 변환
var passedDay = Math.round(passedTime / (24 * 60 * 60 * 1000));

document.querySelector('#accent').innerText = passedDay + "일";

calcDate(1);
calcDate(2);
calcDate(10);

function calcDate (days) {
    var future = toFirst + days * (1000 * 60 * 60 * 24 * 365);
    var someday = new Date(future);

    var year = someday.getFullYear();
    var month = someday.getMonth() + 1;
    var date = someday.getDate();
    var rate = days * 0.04 * 1000000;
    document.querySelector("#money" + days).innerText =
        year + "년 " + month + "월 " + date + "일" + rate + "(만원)이자";
}