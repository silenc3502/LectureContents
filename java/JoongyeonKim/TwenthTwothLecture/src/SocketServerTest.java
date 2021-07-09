import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class SocketServerTest {
    public static void main(String[] args) {
        int port = Integer.parseInt("33333");  //포트 번호를 33333으로 지정한다

        try{
            ServerSocket servSock = new ServerSocket(port);
            System.out.println("Server: Listening-" + port);

            while (true){  //서버를 계속 유지해야하니 while문을 계속 반복시킨다
                Socket sock = servSock.accept();  //서버 생성

                System.out.println("[" + sock.getInetAddress()+"] clint Conected");

                OutputStream out= sock.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);

                writer.println(new Date().toString());  //Date: the milliseconds since January 1, 1970, 00:00:00 GMT 정보를 출력함

                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader((in)));  //서버가 보내는 메세지를 출력한다

                System.out.println("msg:"+reader.readLine());
            }
        } catch (IOException e){
            System.out.println("Server Exceprion:"+e.getMessage());
            e.printStackTrace();
        }
    }
}
