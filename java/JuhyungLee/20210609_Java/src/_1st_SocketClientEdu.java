import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
public class _1st_SocketClientEdu {
    // 접속 시간에 대한 정보를 획득하고자 하는 서비스 이용자
    public static void main(String[] args) {

        String hostname = "192.168.0.5"; //gitbash에서 ipconfig -all
        int port = 33333;
        // 포트의 역할: 서비스 번호  (PID랑 같은거 아님 주의)
        // 결국 어떤 서비스에 접근하기 위해서는 IP와 포트를 알아야 함.
        for (int i = 0; i < 10; i++) {
            try {
                // server와 마찬가지로 client쪽에도 통신을 수행할 수 있도록 내 sokcet을 만듬.
                // clinet쪽에는 접속하고 싶은 server의 ip(hostname)와 서비스(port)를 인자로 하는 socket만듬.
                // 이 socket이 생성되는 시점은 server에서 accept()했을 때 생김.
                Socket sock = new Socket(hostname, port);

                // 서버에게 전송하기 위한 객체 'out'
                OutputStream out = sock.getOutputStream();
                String str = "Hello Network Programming";
                out.write(str.getBytes());

                //서버에서 송신한 정보 읽는 로직
               InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String time = reader.readLine();
                System.out.println(time);

            } catch (UnknownHostException e) { //ip주소 잘못 적었을 때의 catch
                System.out.println("Server Not Found: " + e.getMessage());
            } catch (IOException e) { // 동작하다가 error가 났을 때의 catch
                System.out.println("I/O Error: " + e.getMessage());
            }
        }
    }
}