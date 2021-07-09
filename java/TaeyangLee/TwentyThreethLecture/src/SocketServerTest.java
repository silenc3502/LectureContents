import javax.swing.text.DefaultEditorKit;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


//서버는 서비스 제공자
//클라이언트는 서비스 이용자
public class SocketServerTest {
    //누군가 접속하면 시간을 알려주는 서비스
    public static void main(String[] args) {

        //포트의 역할 : 서비스 번호
        int port = Integer.parseInt("33333");

        try {
            //소켓은 다른 컴퓨터와 내 컴퓨터를 이어주는 통로
           ServerSocket servSock = new ServerSocket(port);
            System.out.println("Server ; Listening - " +port);

            while (true){

                //accept부분에서 블로킹 작업을수행
                //클라이언트가 소켓을 요청할 때 까지 문두드린다

                //accept부분에서 서버는 블로킹 연산을 수행하고 있음


                //블로킹의 반대개념
                // 논블로킹이라고 하며 비동기 처리와 관계가 깊음음
                //여기에있는 sock는 접속한 사용자 소켓
                Socket sock = servSock.accept();
                //접속이 완료되었으면 접속한 클라이언트의 IP를 확인한다
                System.out.println("[" + sock.getInetAddress() + "] client connected");

                //클라이언트를 향해 출력할 객체를 생성함
                //클라이언트 < ---------------- 서버

               OutputStream out = sock.getOutputStream();

               //PrintWriter에 송신용 객체를 배치함으로써
                // writer.println으로 구동시키는 것이 전송되게 만들었음
               PrintWriter writer = new PrintWriter(out);

               //현재 시각정보를 클라이언트에 전송



                //클라이언트로 부터 입력받을 객체를 생성함(수신)
                InputStream in = sock.getInputStream();
                //InputStreamㅇ르 사용해서 들어오는 객체는 반드시 아래와 같이읽어야함
                //InputStreamReader() : InputStream읽읽기
               //BufferedReader() : 데이터가 많이 들어오거나 빈번하게 지속적으로 들어올 수 있다
                //                   버퍼를 가진 상태에서 읽기를 지원하기 위함
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                System.out.println("msg : "+reader.readLine());

            }
        } catch (IOException e) {
            System.out.println("Server Exception : "+e.getMessage());
            e.printStackTrace();
        }

    }

}