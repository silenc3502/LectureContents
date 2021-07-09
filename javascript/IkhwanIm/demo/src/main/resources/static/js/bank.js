var myMoney = 1000000;
var interest = 1.04;

document.querySelector('#accent').innerText = myMoney + "원";

calcMoney(1);
calcMoney(3);
calcMoney(10);

function calcMoney (year) {
    var temp = myMoney;
    for(var i = 0; i < year; i++) {
        temp *= interest;
    }
    temp = Math.round(temp);
    document.querySelector("#money" + year).innerText =
        "후의 잔고는?? " + temp + "원";
}