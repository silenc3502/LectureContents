import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class SocketClientTest {
    public static void main(String[] args) throws IOException {
        String hostname = "192.168.55.4";
        int port = 33333;

        for (int i = 0; i< 10; i++) {
            try {
                Socket sock = new Socket(hostname, port);
                OutputStream out = sock.getOutputStream();

                String str = "Hello Network Programming!!!";

                out.write(str.getBytes());

                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String time = reader.r  eadLine();
                System.out.println(time);
            } catch (UnknownHostException e) {
                System.out.println("Server Not Found: " + e.getMessage());
            }
        }

    }
}
