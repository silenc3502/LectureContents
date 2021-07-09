var money  = 1000000;
var profit = money*(4/100);


document.querySelector('#accent').innerText = money +"원";


calcMoney(1)
calcMoney(3)
calcMoney(10)

function calcMoney (days) {
    var finalMoney = money +(profit*days)

     document.querySelector("#money" +days).innerText =
      "나의돈은?"+finalMoney
 }
