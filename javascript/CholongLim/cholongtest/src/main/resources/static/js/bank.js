var myMoney = 1000000;

document.querySelector('#accent').innerText = myMoney + "원";
calcMoney(1);
calcMoney(3);
calcMoney(10);

function calcMoney (years) {
    var nowMoney = myMoney;

    for (var i =0 ; i < years; i++){
        nowMoney *= 1.03;
    }
    document.querySelector("#money" + years).innerText = nowMoney + "원";
}

