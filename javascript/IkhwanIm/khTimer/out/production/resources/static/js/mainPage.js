const daysEl = document.getElementById('days');
const hoursEl = document.getElementById('hours');
const minsEl = document.getElementById('mins');
const secondsEl = document.getElementById('seconds');
// var : 재선언이 가능하기에 값이 바뀔 우려가 있음
// let : 재선언이 불가능하지만 재할당 가능
// const : 재선언, 재할당 모두 불가능

// 종강 날짜
const end = new Date("2021-12-08,00:00:00");

function countdown() {
    const endDate = new Date(end).getTime();
    const currentDate = new Date().getTime();
    //컴퓨터가 계산하는 숫자 정보로 변환하여 뺌 (밀리세컨)
    const timeLeftSec = (endDate - currentDate)/1000;
    //24 hours, 60minutes, 60 seconds, 1000milliseconds
    const seconds = Math.floor(timeLeftSec)%60;
    const minutes = Math.floor(timeLeftSec/60)%60;
    const hours = Math.floor(timeLeftSec/(60*60))%24;
    const days = Math.floor(timeLeftSec/(60*60*24));

    daysEl.innerHTML = days;
    hoursEl.innerHTML = addZero(hours);
    minsEl.innerHTML = addZero(minutes);
    secondsEl.innerHTML = addZero(seconds);

}
function addZero(time) {
    return time < 10 ? `0${time}` :time;
}
function init(){
    setInterval(countdown, 1000);
}
init();




