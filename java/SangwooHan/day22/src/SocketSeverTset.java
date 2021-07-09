import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SocketSeverTset {
    public static void main(String[] args) {
        int port = Integer.parseInt("21002");

        try{
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Sever:Listening  - "+port);

            while (true){
                Socket sock = serverSocket.accept();
                System.out.println("["+sock.getInetAddress()+"]client connected");

                OutputStream out =  sock.getOutputStream();
                PrintWriter writer = new PrintWriter(out,true);

                writer.println(new Date().toString());

                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                System.out.println("msg:"+reader.readLine());


            }
        } catch (IOException e) {
            System.out.println("sever Exception:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
