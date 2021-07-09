function calcDeposit () {
    var interestRate = 1.04;
    var myMoney = document.querySelector('#checkMoney').value;

    var money1 = Math.round(myMoney * Math.pow(interestRate, 1));
    var money3 = Math.round(myMoney * Math.pow(interestRate, 3));
    var money10 = Math.round(myMoney * Math.pow(interestRate, 10));

    document.querySelector('#showMoney1').innerHTML =
    + money1 + "원"
    document.querySelector('#showMoney3').innerHTML =
    + money3 + "원"
    document.querySelector('#showMoney10').innerHTML =
    + money10 + "원"

    console.log(money1);
    console.log(money3);
    console.log(money10);

}