import java.io.IOException;

// 서버: 클라이언트 통신
// 수신 스레드, 송신 스레드, 결과 출력 스레드
public class Quiz0609Prob62Server {
    public static void main(String[] args) throws IOException {
        GameStartProcess gsp = new GameStartProcess();

        gsp.createServer();
        gsp.startGame();
        gsp.startThread();
    }
}