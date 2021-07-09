import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SocketServerTest {
    public static void main(String[] args) {
        int port = Integer.parseInt("33333");

        try {
            ServerSocket servSock = new ServerSocket(port);
            System.out.println("Server: Listening - " + port);

            while (true) {
                Socket sock = servSock.accept();
                System.out.println("[" + sock.getInetAddress() + "] client connected");

                OutputStream out = sock.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);

                writer.println(new Date().toString());

                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                System.out.println("msg: " + reader.readLine());
            }
        } catch (IOException e) {
            System.out.println("Server Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

/*
BroadCasting(브로드 캐스팅)은? - 전구간으로 데이터를 뿌리는것
스위치는 한번 찾아놓으면 그 아이피주소와 맥 주소를 저장해놓는다
= 브로드 캐스팅을 다시 할 필요x

아이피의 종류 - 공인 IP, 사설 IP

공유기의 역할?
하나의 공인 IP를 가지고 여러대의 사설 IP가 인터넷을 할 수 있게 해주는 역할

 */