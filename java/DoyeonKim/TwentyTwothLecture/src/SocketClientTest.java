import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientTest {
    public static void main(String[] args) {
        // 사설망이라 컴퓨터 털릴일 없으니 걱정 no!
        String hostname = "192.168.0.8";
        int port = 33333;

        for (int i = 0; i < 10; i++) {
            try {
                Socket sock = new Socket(hostname, port);
                OutputStream out = sock.getOutputStream();

                String str = "Hello Network Programming!!!";

                out.write(str.getBytes());

                InputStream in = sock.getInputStream();//서버쪽에 데이터 넘겨주는 소켓 스트림
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String time = reader.readLine(); //서버쪽에서 넘겨준 정보를 읽는다
                System.out.println(time);//서버쪽에서 date넘겨줌(시간정보)
            } catch (UnknownHostException e) { //ip주소가 없는곳에서 요청이 들어올때
                System.out.println("Server Not Found: " + e.getMessage());
            } catch (IOException e) { //
                System.out.println("I/O Error: " + e.getMessage());
            }
        }
    }
}