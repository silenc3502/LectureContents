import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientTest {
    public static void main(String[] args) {
        // 사설망이라 컴퓨터 털릴일 없으니 걱정 no! // 172.xxx는 사설망 아니고 공인IP이니 노출되면 xxx
        String hostname = "172.30.1.38"; // 깃배쉬에서 "ifconfig -a11" 입력 -> IPv4 Address의 아이피를 입력
        int port = 33333;

        for (int i = 0; i < 10; i++) {
            try {
                Socket sock = new Socket(hostname, port);
                OutputStream out = sock.getOutputStream();

                String str = "Hello Network Programming!!!";

                out.write(str.getBytes());

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