import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class SocketClientTest {
    public static void main(String[] args) {
        String hostname = "172.30.1.49";
        int port = 33333;

        for(int i =0; i < 10; i++){
            try {


                //클라이언트 자신의 소켓을 생성한다.
                //생성할 때 나는 서버의 ip 주소(hostname)에 서비스 (port)에  접속 요청
                //통신을 수행할 수 있도록 내 소켓을 만듬
                Socket sock = new Socket(hostname,port);
                OutputStream out = sock.getOutputStream();

                String str = "Hello Network Programming!";

                out.write(str.getBytes());

                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String time = reader.readLine();
                System.out.println(time);
            } catch (UnknownHostException e){
                System.out.println("Server not found" + e.getMessage());

            }catch (IOException e) {
                System.out.println("I/O Error : "+e.getMessage());
            }
        }
    }
}