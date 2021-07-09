var myMoney = 1000000; // 예치금


document.querySelector('#accent').innerText = myMoney + "원";

calcMoney(1);
calcMoney(3);
calcMoney(10);

function calcMoney(years) {
    var tmpMoney = myMoney;

    for(var i = 0; i < years; i++){
        tmpMoney *= 1.04;
    }

    document.querySelector("#money" + years).innerText = "만기 : " + Math.round(tmpMoney) + "원";


}

