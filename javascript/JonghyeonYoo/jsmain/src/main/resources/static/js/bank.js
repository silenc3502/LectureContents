// 오늘 날짜 정보
var myMoney = 1000000;
var interestRate = 0.04;

document.querySelector('#accent').innerText = myMoney + "원";

calcYear(1);
calcYear(3);
calcYear(10);


function calcYear(year) {
        var interestMoney = myMoney * year * interestRate;
    for(var i = 0; i < year; i++) {

            bankMoney = myMoney + interestMoney;
    }

    document.querySelector("#money" + year).innerText =
   bankMoney + "원";
};
