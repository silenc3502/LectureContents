function showPrice () {
    //++ document.querySelector를 통해 객체를 가져오고 value를 통해 객체안의 값을 가져왔다.
    // 가격정보를 획득
    var originPrice = document.querySelector('#productPrice').value;
    var rate = document.querySelector('#rate').value;
    //할인 금액
    var savedPrice = originPrice * ( rate / 100 );
    var resultPrice = originPrice - savedPrice;

    document.querySelector('#showResult').innerHTML =
    "사품의 원가는 " + originPrice + "원이고, 할인율은 " + rate + "%이다." +
    savedPrice + "원을 절약하여" +  resultPrice + "원에 구매할 수 있다.";
}