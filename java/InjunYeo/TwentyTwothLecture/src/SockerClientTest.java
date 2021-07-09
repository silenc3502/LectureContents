import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class SockerClientTest {
    //접속 시간에 대한 정보를 획득하고자 하는 서비스 이용자
    public static void main(String[] args) {

        //사설망이라 컴퓨터 털릴일 없으니 걱정 no!
        String hostname;
                //= "192.168.0.13";
        int port = 33333;

        for(int i=0;i<10;i++){
            try{
                hostname = InetAddress.getLocalHost().getHostAddress();
                //클라이언트 자신의 소켓을 생성한다.
                //생성할 때 나는 서버의 ip주소(hostname)에 서비스(port)에 접속하고 싶다는 요청을하면서 소켓을 만든다.
                Socket sock = new Socket(hostname,port);
                //서버에게 전송하기위한 객체를 준비함
                OutputStream out = sock.getOutputStream();
                //이내용을 서버에게 송신함(서버입장에선 InputSream()을 처리할때 읽음)
                String str = "Hello Network Programming!!!";
                out.write(str.getBytes());

                //서버에서 날아온 수신 정보를 받을 객체
                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                //입력이 들어올때까지 대기함
                //서버에서 전송한 출력정보를 표시함
                String time = reader.readLine();
                System.out.println(time);
            } catch (UnknownHostException e){//IP주소가 잘못됐을때의 대한 예외처리
                System.out.println("Server Not Found: "+e.getMessage());
            } catch (IOException e ){   //잘못된정보를 받아왔을때의 대한 예외처리리
                System.out.println("I/O Error: "+e.getMessage());
            }

        }

    }
}
