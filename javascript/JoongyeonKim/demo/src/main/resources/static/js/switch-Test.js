var session = prompt("세션 선택! 1. 마케팅, 2. 개발, 3. 디자인", "1");
//prompt
//브라우저에서 제공하는 prompt 함수는 두 개의 인수를 받습니다.
//함수가 실행되면 텍스트 메시지와 입력 필드(input field), 확인(OK) 및 취소(Cancel) 버튼이 있는 모달 창을 띄워줍니다.

switch (session) {
    case "1":
        document.write("<p>마케팅 및 투자 전략: <strong>201호</strong> 오후 1시</p>");  //document.write는 sout랑 같은의미
        break;
    case "2":
        document.write("<p>tms570 펌웨어 개발: <strong>203호</strong> 오후 3시</p>");
        break;
    case "3":
        document.write("<p>UI/UX 디자인의 진수: <strong>201호</strong> 오전 10시</p>");
        break;  
    default:
        alert("똑바로 입력해라?");
        break;
}