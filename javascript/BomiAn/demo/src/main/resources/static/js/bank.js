var myMoney = 1000000;
var rate = 4;
document.querySelector('#accent').innerText = myMoney + "원";

bankMoney(1);
bankMoney(3);
bankMoney(10);

function bankMoney (term) {
    var myInterest = myMoney * term * rate / 100;
    var totalMoney = myMoney + myInterest;

    document.querySelector('#money' + term).innerText =
           totalMoney + "원";
};


