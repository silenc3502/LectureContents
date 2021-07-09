var toyRobot = {
    // 자바스크립트 내부에서 값을 배치하는 작업은 JSON 형식을 따른다.
    productId: "123-34",
    name: "Thunder Bird",
    price: "25,000,000",
    madeIn: "Korea",
    quantity: 1,
    showStock: function () {
        document.querySelector('#display').innerHTML =
        this.name + " 제품은 " + this.quantity + "개 남아있다.";
    }
};

toyRobot.showStock(); 