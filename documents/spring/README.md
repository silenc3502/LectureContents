## Spring 환경 설정

HTML/CSS, Vue, React, JavaScript 뭐가 됫건 일단 서버에 붙어야 멋지게 실행가능하다.  
기본적으로 서버에 붙을 수 있게 Controller 정도만 만들어놓도록 한다.  

### Spring 초기 설정

```make
1. 구글에서 spring initializr 를 검색한다.
   https://start.spring.io/
2. Project: Gradle Project
   Language: Java
   Spring Boot: 2.5.0
   Project Metadata: 변경 없음
   Dependencies: Lombok, Spring Web, Thymeleaf, 
                 JDBC API, Spring Data JPA, MySQL Driver
3. Generate를 누르면 다운이 받아짐
4. 다운 받은 내용을 압축해제한다(내용이 바이러스라면서 사라지면 동작 안되니 주의)
5. 압축 해제한 폴더를 우리의 git 경로상 javascript에 있는 이름 폴더로 이동시킨다.
6. IntelliJ를 킨다.
7. Open을 눌러서 javascript상에 있는 이름 폴더의 demo를 선택한다.
8. 신뢰(Trust)하냐고 묻는데 당연히 Trust를 누르면 된다.
9. IntelliJ가 gradle을 구동시켜 프로젝트를 빌드하기 시작하는데
   시간이 꽤 걸리니 커피 혹은 차나 한 잔 하도록 한다.
10. 준비가 완료되면 Project 쪽 상단의 메뉴가 바뀐다.
11. 진입하자마자 src/main/resources/application.properties의 이름을 Refactor로 변경한다.
    application.yaml로 변경한다.
12. 그리고 내부의 내용을 아래와 같이 작성한다.

server:
  port: 7777
  
13. src/main/java/com.example.demo 폴더의 DemoApplication을 실행한다.
14. 콘솔창에 포트 번호 7777로 서버가 구동된다는 것이 나오면 OK!
15. 만약 구동이 안된다면 build.gradle 폴더에 sourceCompatibility = '8' 부분을 버전에 맞춰서 작성한다.
```
