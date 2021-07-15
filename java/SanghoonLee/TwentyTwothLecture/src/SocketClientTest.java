import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientTest {
    public static void main(String[] args) {
        // 사설망이라 컴퓨터 털릴일 없으니 걱정 no!
        String hostname = "192.168.30.141";
        int port = 33333;

        for (int i = 0; i < 1000; i++) {
            try {
                Socket sock = new Socket(hostname, port);
                OutputStream out = sock.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);

                String str = "Hello Network Programming!!!";
                //out.write(str.getBytes());
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
