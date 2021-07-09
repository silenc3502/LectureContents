import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DummyServer {
    public static void main(String[] args) {
        int port = Integer.parseInt("12344");


        try {
            System.out.println("Server Listening - " + port);
            ServerSocket svrSocket = new ServerSocket(port);
            Socket sock = svrSocket.accept();
            System.out.println("[" + sock.getInetAddress() + "Client Connected");

            while (true) {
                OutputStream out = sock.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println(new Date().toString());

                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                System.out.println("msg" + reader.readLine());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}