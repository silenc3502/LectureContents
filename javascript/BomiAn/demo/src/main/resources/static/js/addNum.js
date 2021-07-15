function addNumber() {
    var num1 = parseInt(prompt("첫 번째 수는?"));
    var num2 = parseInt(prompt("두 번째 수는?"));
    var result = add(num1, num2);

    document.write("<p>" + num1 + "+" + num2 + "=" +result +"</p>");
}
function add(a,b){
var sum = a + b;
return sum;
}


