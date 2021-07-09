import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Review23_2 {
    public static void main(String[] args) {
        String hostname = "192.168.55.4";
        int port = 44444;

        for (int i = 0; i < 10; i++) {
            try {

                Socket sock = new Socket(hostname, port);

                OutputStream out = sock.getOutputStream();

                String str = "보내지긴 하나?";
                out.write(str.getBytes());


                InputStream in = sock.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));


                String number = reader.readLine();
                System.out.println(number);

                String string = reader.readLine();
                System.out.println(string);


            } catch (UnknownHostException e) {
                System.out.println("Server Not Found: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("I/O Error: " + e.getMessage());
            }

            //java.net.BindException : Address already in use : bind
            //1. cmd 실행
            //2. netstat -ano 명령어 입력 > 현재 떠 있는 process들의 정보를 보여줌
            //3. 아래 사진의 빨간색 부분 (:port) 에 :8080 이라고 되어 있는 부분을 찾고, 있다면 그 PID를 찾아냄
            //4. taskkill /f /pid 프로세스ID 명령어 실행
        }
    }
}