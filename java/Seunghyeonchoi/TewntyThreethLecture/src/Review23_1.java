import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Review23_1 {
    public static void main(String[] args) {
        int port = 44444;

        try {
            ServerSocket servSock = new ServerSocket(port);
            System.out.println("Server: Listening - " + port);

            while (true) {
                Socket sock = servSock.accept();

                System.out.println("[" + sock.getInetAddress() + "] client connected");

                OutputStream out = sock.getOutputStream();

                PrintWriter writer = new PrintWriter(out, true);




                Scanner scan = new Scanner(System.in);

                System.out.print("상대에게 보낼 숫자를 입력해주세요 : ");

                int number = scan.nextInt();

                scan.nextLine();

                System.out.print("상대에게 보낼 문장을 입력해주세요 : ");

                String string = scan.nextLine();

                writer.println(number);
                writer.println(string);





                InputStream in = sock.getInputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                System.out.println("msg: " + reader.readLine());
            }
        } catch (IOException e) {
            System.out.println("Server Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}