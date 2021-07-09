var myMoney = 100;
var interestRate = 4;
var futMoney;

var targetYear = [1, 3, 10];

getBankInterest(1);
getBankInterest(3);
getBankInterest(10);

function getBankInterest(years) {
    for(var i=1; i<=years; i++) {
        if(i===1) {
            futMoney = Math.round(myMoney + (myMoney * interestRate * 0.01));
        } else {
            futMoney = Math.round(futMoney + (futMoney * interestRate * 0.01));
        }
        for(var j=0; j<targetYear.length; j++) {
            if(years===targetYear[j]) {
                //document.write("<p>" + i + "년 후의 금액은 " + futMoney + "백 만 원입니다.</p>");
                document.querySelector("#year" + years).innerText =
                    i + "년 후의 금액은 " + futMoney + "백 만 원입니다.";
            }
        }
    }
}

//쿼리셀렉터로 출력하는게 아니라면 메소드 실행코드가 필요하다.

