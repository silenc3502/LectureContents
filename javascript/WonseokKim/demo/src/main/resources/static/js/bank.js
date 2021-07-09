var myMoney = 100000000;

document.querySelector('#accent').innerText = myMoney + "원";

calcDate(1);
calcDate(3);
calcDate(10);

function calcDate (years) {
    var tmpMoney = myMoney;

    for (var i = 0; i < years; i++) {
        tmpMoney *= 1.03;
    }

    document.querySelector("#money" + years).innerText =
        Math.round(tmpMoney) + "원";
}