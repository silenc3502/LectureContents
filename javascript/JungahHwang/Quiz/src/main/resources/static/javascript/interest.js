calcInterest(1)
calcInterest(3)
calcInterest(10)

function calcInterest(year){
    let money = 1000000;
    
    for (var i = 0; i < year; i++){
        const interest = 0.04;
        money += money*interest;
    }
    money = Math.round(money);
    document.querySelector("#year" + year).innerText = money + "원";

}

