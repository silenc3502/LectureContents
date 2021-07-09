
    var password = document.querySelector("#aboveNumber").length;

    function error () {
        if(password < 8) {
        document.write("<button onclick="alert('오류 ?')">"+"틀림"+"</button>");
        }
        else {
        document.write("적절한 비밀번호");
        }
    }


