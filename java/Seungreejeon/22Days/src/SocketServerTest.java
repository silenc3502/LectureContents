import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SocketServerTest {
    public static void main(String[] args) {
        int port = Integer.parseInt("3333");

        try {
            ServerSocket serverSock = new ServerSocket(port);
            System.out.println("Server : Listening - " + port);

            while (true) {
                Socket socket = serverSock.accept();

                System.out.println("[" + socket.getInetAddress() + "] client connected");

                OutputStream out = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);

                writer.println(new Date().toString());

                InputStream in = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                System.out.println("msg : " + reader.readLine());

            }
        } catch (IOException e) {
            System.out.println("server Exception" + e.getMessage());
            e.printStackTrace();
        }
    }
}
