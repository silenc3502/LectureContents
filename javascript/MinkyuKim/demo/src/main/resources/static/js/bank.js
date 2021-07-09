/*
var myMoney = 100000000;

document.querySelector('#accent').innerText = myMoney + "원";

calcMoney(1);
calcMoney(3);
calcMoney(10);

function calcMoney (years) {
    var tmpMoney = myMoney;

    for (var i = 0; i < years; i++) {
        tmpMoney *= 1.03;
    }

    document.querySelector("#money" + years).innerText =
        Math.round(tmpMoney) + "원";
}
*/

// 몇일이 되었습니다.(만난지 ~~~~일)
// document.querySelector('#accent').innerText = passedDay + "일";
var reserve = 1000000;
document.querySelector('#accent').innerText = reserve + "원";

calcMoney(1);
calcMoney(3);
calcMoney(10);


function calcMoney(years) {
    for(var i = 0; i < years; i++) {
        // var rate = 0.04
        // reserve += reserve * rate;
        var rate = 1.04;
        reserve *= rate;

    }
    reserve = Math.round(reserve);
    document.querySelector("#money" + years).innerText = reserve + "원";
    // document.querySelector("#money" + years).innerText = Math.round(reserve) + "원";
}