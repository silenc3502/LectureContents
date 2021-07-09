import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class DummyClient {
    public static void main(String[] args) {
        int port = Integer.parseInt("12344");
        String hostname = "192.168.1.14";


        try {

            Socket sock = new Socket(hostname, port);

                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                System.out.println(reader.readLine());

                OutputStream out = sock.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                String str = "Hi Server";
                writer.println(str);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}