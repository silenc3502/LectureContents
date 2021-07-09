import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketCLientTest {
    //접속 시간에 대한 정보를 획득하고자 하는 서비스 이용자
    public static void main(String[] args) {
        // 사설망이라 컴퓨터 털릴일 없으니 걱정 no!
        String hostname = "192.168.1.136";
        //포트의 역할: 서비스번호
        // 결국 우리가 어떤 서비스에 접근하기 위해서는 아이피와 포트를 알아야한다
        int port = 33333;

        for(int i =0; i<10; i++){
            try{
                // 클라이언트 자신의 소켓을 생성한다.
                // 생성할 떄 나는 서버의 ip주소(hostname)에 서비스(part)에 접속하고 싶어!
                //라고 요청하면서 소켓을 만든다
                Socket sock = new Socket(hostname, port);

                //서버에게 전송하기 위한 객체를 준비함
                OutputStream out = sock.getOutputStream();
                // 이 내용을 서버에게 송신함
               String str = "Hello Network Programming";
                out.write(str.getBytes());

                // 서버로부터 날아온 수신 정보
                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in)); //서버가 보낸 메시지 출력

                String time = reader.readLine();
                System.out.println(time);  // 현재 시간출력
            } catch(UnknownHostException e){
                System.out.println("Server Not Found:"+ e.getMessage());
            } catch (IOException e){
                System.out.println("I/O Error:"+ e.getMessage());
            }
        }
    }
}
