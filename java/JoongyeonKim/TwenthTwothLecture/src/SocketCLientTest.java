import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketCLientTest {
    public static void main(String[] args) {
        // 사설망이라 컴퓨터 털릴일 없으니 걱정 no!
        String hostname = "192.168.1.136";
        int port = 33333;

        for(int i =0; i<10; i++){
            try{
                Socket sock = new Socket(hostname, port);
                OutputStream out = sock.getOutputStream();

                String str = "Hello Network Programming";

                out.write(str.getBytes());

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
