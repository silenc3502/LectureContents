import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientTest {
    public static void main(String[] args) {
        String hostname = "192.168.0.6";
        int port = 21002;

        for(int i = 0; i<10; i++){
            try{
                Socket sock = new Socket(hostname, port);
                OutputStream out = sock.getOutputStream();
                PrintWriter writer = new PrintWriter(out,true);

                String str = "Hello NetWork Programming!!!";
    writer.println(str);
                out.write(str.getBytes());

                InputStream in =sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String time = reader.readLine();
                System.out.println(time);


            } catch (UnknownHostException e) {
                System.out.println("Sever Not Found:"+e.getMessage());
            } catch (IOException e) {
                System.out.println("I/O Error"+e.getMessage());
            }
        }
    }
}
