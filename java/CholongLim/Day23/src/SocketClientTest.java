import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.rmi.UnexpectedException;

public class SocketClientTest {
    // 접속 시간에 대한 정보를 획득하고자 하는 서비스 이용자
    public static void main(String[] args) {
        String hostname = "192.168.123.101";
        int port = 33333;

        for(int i =0; i < 10; i++){
            try{
                // 클라이언트 자신의 소켓을 생성한다.
                // 생성할 때 나는 서버의 ip 주소(hostname)에 서비스(port)에 접속하고 싶어!
                // 라고 요청하면서 소켓을 만든다.
                Socket sock = new Socket(hostname, port);

                // 서버에게 전송하기 위한 객체를 준비함
                OutputStream out = sock.getOutputStream();
                // 이 내용을 서버에게 송신함
                String str = "Hello Network Programming";

                out.write(str.getBytes());

                // 서버에서 날아온 수신 정보
                // 서버가 아웃풋으로 보낸 시간 정보
                // 입력이 들어올 때 까지 대기 (InputStream)
                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String time = reader.readLine();
                System.out.println(time);
                // 주소가 잘못됐을때, 동작에러 시를 위한 코드
            } catch (UnexpectedException e){
                System.out.println("Server Not Found : " + e.getMessage());
            } catch (IOException e){
                System.out.println("I/O Error : " + e.getMessage());
            }
        }
    }
}
