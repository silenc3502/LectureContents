import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class _2nd_SocketClient {
    public static void main(String[] args) {
        // 사설망이라 해킹 걱정 ㄴㄴ
        // router ip 알아야 해킹할 수 있음

        String hostname = "192.168.0.5"; //gitbash에서 ipconfig -all
        int port = 33333;
        for (int i = 0; i < 10; i++) {
            try {
                Socket sock = new Socket(hostname, port);
                OutputStream out = sock.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                String str = "Hello Network Programming";
                //    out.write(str.getBytes());
                writer.println(str);

                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String time = reader.readLine();
                System.out.println(time);
            } catch (UnknownHostException e) {
                System.out.println("Server Not Found: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("I/O Error: " + e.getMessage());
            }
        }
    }
}