var toyRobot = {
    productId: "123-34",
    name: "Thunder Bord",
    madeIn: "Korea",
    quantity: 1,
    showStock: function() {
        document.querySelector('#display').innerHTML =
        this.name + "제품은 " + this.quantity + "개 남아있다. ";
    }
};

toyRobot.showStock();