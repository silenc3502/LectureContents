
import java.io.IOException;

// 서버: 클라이언트 통신
// 수신 스레드, 송신 스레드, 결과 출력 스레드
public class Prob62Server {
    // throws : 야 나 미치것다 ... 운영체제 니가 짱짱맨이잖아 이것 좀 처리해줘 죽것다 ㅠ
    public static void main(String[] args) throws IOException {
        GameStartProcess gsp = new GameStartProcess();

        gsp.createServer();
        gsp.startGame();
        gsp.startThread();
    }
}