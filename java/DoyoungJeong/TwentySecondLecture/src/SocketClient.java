import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
    public static void main(String[] args) {
        String hostName = "192.168.35.224";
        int port = 33333;

        for(int i=0; i<10; i++) {
            try{
                Socket sock = new Socket(hostName, port);
                OutputStream out = sock.getOutputStream();

                String str = "Hello Network Programmig!";

                out.write(str.getBytes());

                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String time = reader.readLine();
                System.out.println(time);

            } catch (UnknownHostException e) {
                System.out.println("Server Not Found : " + e.getMessage());
            } catch (IOException e) {
                System.out.println("I/O Error : " + e.getMessage());
            }
        }

    }
}
