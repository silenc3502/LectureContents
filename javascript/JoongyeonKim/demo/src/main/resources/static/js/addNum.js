function addNumber() {   // method를 js에서는 function이라고 한다 (클래스없는 메소드라 생각하면 된다)
    var num1 = parseInt(prompt("첫 번째 숫자는?"))

    var num2 = parseInt(prompt("두 번째 숫자는?"))
    var result = add(num1, num2);
    
    document.write("<p>" + num1 + "+" + num2 + "=" + result + "</p>");
    //document.write는 sout와 같은 의미라고 보면 된다.
}

function add(a,b){
    var sum = a+b;
    return sum;
}

