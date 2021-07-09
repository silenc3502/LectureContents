import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Review0609SocketClient {
    // 서버에 접속해서 (접속시간을 알려주는)서비스를 제공받음
    public static void main(String[] args) {
        String hostname = "172.30.1.51";
        int port = 33333;

        for(int i=0; i < 10; i++){
            try{
                // 클라이언트 자신의 소켓을 생성해서 서버와 연결함
                // 생성할 때 서버의 ip주소(hostname)에 서비스(port)에 접속하고 싶어 라고 요청
                // 하면서 소켓을 만든다
                Socket sock = new Socket(hostname, port);
                OutputStream out = sock.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                // 서버에게 전송(송신)하기 위한 객체를 준비

                String str = "Hollo Network Programming!!";
                // 이 내용을 서버에게 write를 이용하여 전송함\
                // 서버는 이 내용을 InputStream에서 읽는다
                writer.println(str);

                InputStream in = sock.getInputStream();
                // 서버에서 입력(수신)받을 객체 생성을 준비
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String time = reader.readLine();
                System.out.println(time);
            }catch (UnknownHostException e){
                // hostname이 잘못되었을 때 방지
                System.out.println("Server Not Found: " + e.getMessage());
            }catch (IOException e){
                System.out.println("I/O Error: " + e.getMessage());
            }
        }
    }
}



































