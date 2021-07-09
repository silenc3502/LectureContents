//현재 가지고있는 돈
var money = 100;


document.querySelector('#accent').innerText = money+"만원";

calcmoney(1);
calcmoney(3);
calcmoney(10);

function calcmoney(days){

    for(var i = 0; i<days;i++){
        money +=money*0.04;

    }

    document.querySelector('#money' + days).innerText = Math.round(money)+"만원";
}