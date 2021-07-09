/*
var myMoney = 1000000;

for(var i=1; i<=10; i++)
{
    myMoney = myMoney + (myMoney * 0.04);

    var incresedMoeny= myMoney ;

    document.write("<p>" + i + "년 후의 금액: " + incresedMoeny + "</p>");
}*/


calcIncresedMoney(1);
calcIncresedMoney(3);
calcIncresedMoney(10);

function calcIncresedMoney(year)
{
    var myMoney= 1000000;

    for(var i=1; i<=year; i++)
    {
         myMoney= myMoney + (myMoney * 0.04);
         var incresedMoeny= myMoney;

    }
     document.querySelector('#calc').innerHTML = year + "년 후의 금액: " + incresedMoeny;

}

