function addNumber () {
    var num1 = parseInt(prompt("첫 번째 숫자는 ?"));
    var num2 = parseInt(prompt("두번째 숫자는 ?"));
    var rusult = add(num1, num2);

    document.write("<p>" + num1 + " + " + num2 + " = " + result + "</p>");
}

function add(a, b)  {
    var sum = a + b;
    return sum;
}