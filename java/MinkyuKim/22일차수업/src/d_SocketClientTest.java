import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class d_SocketClientTest {
    public static void main(String[] args) {
        // 사설망이라 컴퓨터 털릴일 없으니 걱정 no!
        String hostname = "1.239.171.243";
        int port = 33333;

        for (int i = 0; i < 10; i++) {
            try {
                // 클라이언트 자신의 소켓을 생성한다.
                // 생성할 때 나는 서버의 ip 주소(hostname)에 서비스(port)에 접속하고 싶어!
                // 라고 요청하면서 소켓을 만든다.
                // 클라이언트가 소켓을 받는 순간은
                Socket sock = new Socket(hostname, port);

                // 서버에게 전송하기 위한 객체를 준비함
                OutputStream out = sock.getOutputStream();
                // 이 내용을 서버에게 송신함. ( 이 내용이란 서버의 inputStream)
                String str = "Hello Network Programming!!!";
                out.write(str.getBytes());


                //++ 수신이 들어올때까지 대기한다.(blocking)

                // 서버에서 날아온 수신 정보(서버가 아웃풋으로 보낸 시간정보)
                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String time = reader.readLine();
                System.out.println(time);

                // 아이피가 잘못되었을 때, 동작하다 실수가 발생하였을 때 작동
            } catch (UnknownHostException e) {
                System.out.println("Server Not Found: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("I/O Error: " + e.getMessage());
            }
        }
    }
}