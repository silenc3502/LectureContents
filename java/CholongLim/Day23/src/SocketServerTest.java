/*
 서버, 클라이언트 개념은 무엇일까 ?
 서비스는 뭐지?
 이거 내가 하기 너무 힘드니까 돈 줄테니깐 좀 해줘

 이 개념 하에서 서버란 것은 무엇인가 ?
  서비스 제공자
  클라이언트는 ?
  서비스 이용자
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SocketServerTest {
    // 누군가 접속하면 접속 시간을 알려주는 서비스
    public static void main(String[] args) {
        // 포트의 역할 : 서비스 번호
        // 결국 우리가 어떤 서비스에 접근하기 위해서는 무엇을 알아야 한다 ?
        // 아이피(192.168...)와 포트(80 / 443 ...)
        int port = Integer.parseInt("33333");

        try{
            // 소켓이란 ? 돼지코 구멍(콘센트)
            // 전기 분야에서 소켓에 전원 코드를 연결하면 거기 제품들이 구동 가능한것과 마찬가지로
            // 프로그래밍 분야에서 소켓이란 다른 컴퓨터와 내 컴퓨터를 연결하는 역할을 한다.
            // 소켓이 없으면 내 컴퓨터와 다른 컴퓨터의 통신 안된다.
            // 그러니까 통신을 수행할 수 있도록 내 소켓을 만들었음

            ServerSocket servSock = new ServerSocket(port);
            System.out.println("Server : Listening - " + port);

            while(true){
                // accept() 부분에서 서버는 Blocking(블록킹) 연산을 수행하고 있음
                // 블록킹 : 막는 것 = 무엇을 막는것인가?
                // accept = Thread spinlock같은 느낌이다.
                // 나올때 까지 화장실 문을 두드림
                // 니(클라이언트)가 준비될때까지 난 계속 기다린다. (문 두드리면서)
                // 클라이언트가 소켓을 요청할때까지 계속 문 두들긴다.

                // Blocking의 반대 개념도 있지 않을까 ?
                // Non - Blocking 이라고 하며 비동기 처리와 관계가 깊음

                // (여기에 있는 sock은 접속한 사용자 소켓임)
                Socket sock = servSock.accept();
                // 접속이 완료되었으면 접속한 클라이언트 IP를 확인한다.

                System.out.println("[" + sock.getInetAddress() + "] client connected");

                // 클라이언트를 향해 출력할 객체를 생성함
                OutputStream out = sock.getOutputStream();
                // PrintWriter에 송신용 객체를 배치함으로써
                // writer.println 으로 구동시키는 것이 전송되게 만들었음
                PrintWriter writer = new PrintWriter(out, true);

                writer.println(new Date().toString());

                // 입력이 들어올 때 까지 대기 (InputStream)
                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                System.out.println("msg : " + reader.readLine());
            }
        }catch (IOException e){
            System.out.println("Server Exception : "+ e.getMessage());
            e.printStackTrace();
        }
    }
}

