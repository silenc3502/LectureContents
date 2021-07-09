//오늘 날자 정보
var now = new Date();

//처음 만난 날자 정보
var firstDay = new Date("2015-03-29");

//오늘 날자 정보를 컴퓨터가 계산하는 숫자 정보로 변환(정확히는 ms단위로 바뀜)
var toNow = now.getTime();

//처음만난 날자를 컴퓨터가 게산하는 숫자 정보로 변환
var toFirst = firstDay.getTime();

//오늘 날자 - 첫만남
var passedTime = toNow - toFirst;

//다시 날자로 변환
//math.round(반올림)
var passedDay = Math.round(passedTime / (24 * 60 * 60 * 1000))+1;

document.querySelector('#accent').innerText = passedDay+"일";

calcDate(100);
calcDate(200);
calcDate(300);
calcDate(400);

function calcDate(days){
    var future = toFirst+days*(1000*60*60*24);
    var someday = new Date(future);

    var year = someday.getFullYear();
    var month = someday.getMonth()+1;
    var date = someday.getDate();

    document.querySelector('#date' + days).innerText =year+"년"+month+"월" +days+"일";
}