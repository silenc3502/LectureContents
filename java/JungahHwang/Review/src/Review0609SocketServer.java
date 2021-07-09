import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// 서버: 서비스 제공자
// 클라이언트 : 서비스 이용자

public class Review0609SocketServer {
    // 이 서버는 접속하면 접속한 시간을 알려주는 서비스를 제공함
    public static void main(String[] args) {
        int port = Integer.parseInt("33333");
        // port : 서비스 번호
        //        ex) 네이버 웹서버(443), 다른서비스A(273), 다른서비스B(2344)....
        // 우리가 어떤 서비스에 접근하기 위해서는 아이피(IP)와 포트(port)를 알아야 함

        try{
            // Socket: 전기에서 소켓에 전원코드를 연결하면 전기가 통하는 것처럼
            // 다른 컴퓨터와 내 컴퓨터를 연결하는 통로 역할
            // (소켓이 없으면 다른 컴퓨터와 내 컴퓨터의 통신연결이 안됨)
            // 이 코딩에서 통신을 수행할 수 있도록 내 소켓을 만든것
            ServerSocket servSock = new ServerSocket(port);
            System.out.println("Server: Listenig - " + port);

            while(true){
                Socket sock = servSock.accept();
                // sock: 접속한 client 소켓
                // .accept()에서 서버는 Blocking(블록킹) 연산을 수행(스레드의 spinlock과 비슷)
                // 클라이언트가 접속하기 전까지 계속 요청하면서 기다림
                // Blocking <-> Non-Blocking(비동기 처리와 관련있음)
                // Non-Blocking을 사용하면 속도가 빠르지만 자바에서는 사용하기 어려움

                System.out.println("[" + sock.getInetAddress() + "] client connected" );
                // 접속이 완료되었으면 접속한 클라이언트의 IP를 확인

                // -----------------------------------------------------------------------
                OutputStream out = sock.getOutputStream();
                // 클라이언트에게 출력(송신)할 객체를 생성할 준비
                // 서버(출력) -------> 클라이언트(입력)
                // 서버(입력) <------- 클라이언트(출력)

                PrintWriter writer = new PrintWriter(out, true);
                // PrintWriter에 송신용 객체를 배치하여 writer.println으로 구동시키는 것이 전송되게 함
                writer.println(new Date().toString());
                // 클라이언트에게 접속한 시간을 전송

                InputStream in = sock.getInputStream();
                // 클라이언트에게서 입력(수신)받을 객체를 생성할 준비
                // * 수신은 입력이 들어올 때까지 기다리고 있음(Blocking) *
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                // InputStream을 사용해서 들어오는 객체는 반드시 위와 같이 읽어야 함
                // InputStreamReader(): InputStream읽기
                // BufferedReader(): 데이터가 많이 들어오거나 빈번하게 지속적으로 들어올 수 있어
                //                   버퍼를 가진 상태에서 읽기를 지원하기 위함
                // -----------------------------------------------------------------------

                System.out.println("msg ; " + reader.readLine());
            }
        }catch (IOException e){
            System.out.println("Server Exception: " + e.getMessage());
            e.printStackTrace();
        }



    }
}

























