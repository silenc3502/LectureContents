import java.io.IOException;

public class Prob62Client {
    public static void main(String[] args) throws IOException {
        /*
        마이다이스 랜덤주사위 할당 타겟주사위 0할당
         */
        GameStartProcess gsp = new GameStartProcess();

        //클라이언트 IP와 서버포트번호로 클라이언트 소켓을 만든다
        gsp.createClient();

        /*
        센더와 리시버스레드를 만들고 start를 함
        센더 :서버 크리티컬섹션의 전역변수 커런트마이다이스에 주사위값을 할당한다음 주사위값을 아웃스트림객체를 통해담고
              PrintWriter를 통해 주사위 값을 내보낸다. 수신은 sock객체 즉(받는사람)에게 내보낸다.
        리시버: 받은 다이스는 마이다이스에 할당하고 수신용객체를 생성해서 타겟다이스에 수산용객체로 들어온값을 할당한후
                승리조건을 확인한다음 메시지 출력
         */
        gsp.startThread();
    }
}