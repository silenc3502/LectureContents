import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientTest {
    // 접속 시간에 대한 정보를 획득하고자 하는 서비스 이용자
    public static void main(String[] args) {
        // 사설망이라 컴퓨터 털릴일 없으니 걱정 no!
        String hostname = "172.30.1.54";
        int port = 33333;

        for (int i = 0; i < 10; i++) {
            try {
                // 클라이언트 자신의 소켓을 생성한다.
                // 생성할 때 나는 서버의 ip 주소 (hostname)에 서비스(port)에 접속하고 싶어
                // 라고 요청하면서 소켓을 만듬.
                Socket sock = new Socket(hostname, port);

                // 서버에게 전송하기 위한 객체를 준비
                OutputStream out = sock.getOutputStream();
                // 이 내용을 서버에게 송신함.
                String str = "Hello Network Programming!!!";
                out.write(str.getBytes());

                // 서버에서 날아온 수신 정보
                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String time = reader.readLine();
                System.out.println(time);
            } catch (UnknownHostException e) {
                System.out.println("Server Not Found: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("I/O Error: " + e.getMessage());
            }
        }
    }
}