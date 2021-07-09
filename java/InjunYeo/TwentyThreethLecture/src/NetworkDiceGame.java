import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class ServerCriticalSection {   //서버크리티컬섹션이라는 클래스를 생성한다음 전역변수로 currentMyDice = 0 할당.
    static int currentMyDice = 0;
}

public class NetworkDiceGame {
    int myDice;
    int targetDice;

    ServerSocket servSock;  //서버소켓  객체
    Socket sock;    //소켓객체

    final String SERVER_IP = "192.168.0.13";
    final int PORT = 33333;

    public NetworkDiceGame () { //생성자에서 myDice 숫자 생성, targetDice는 0으로 초기화
        myDice = (int)(Math.random() * 6 + 1);
        targetDice = 0;
    }

    //서버 생성메소드 servSock
    public void createServer () throws IOException {
        servSock = new ServerSocket(PORT);  //새로운 서버소켓(포트번호)로 만든다.

        System.out.println("Server: Listening - " + PORT);
    }

    //클라이언트 생성메소드드
   public void createClient () throws IOException {
        sock = new Socket(SERVER_IP, PORT); //클라이언트 IP와 서버포트번호로 클라이언트 소켓을 만든다.
    }
}

class GameResultThread extends NetworkDiceGame implements Runnable {

    @Override
    public void run() {
        while (true) {  //반복
            if (targetDice != 0) {  //taget다이스가 0이 아니라면 승리 체크조건 확인
                if (myDice > targetDice) {
                    System.out.println("나의 승리");
                } else if (myDice < targetDice) {
                    System.out.println("상대편의 승리");
                } else {
                    System.out.println("무승부");
                }
            }

            targetDice = 0;
        }
    }
}

/*
서버 크리티컬섹션의 전역변수 커런트마이다이스에 주사위값을 할당한다음 주사위값을 아웃스트림객체를 통해담고
PrintWriter를 통해 주사위 값을 내보낸다. 수신은 sock객체 즉(받는사람)에게 내보낸다.
 */
class GameSendThread implements Runnable {  //게임센드 스레드

    int dice;
    Scanner scan;
    Socket sock;

    public GameSendThread (Socket sock, int dice) { //생성자 소켓을 받음
        scan = new Scanner(System.in);

        this.dice = dice;   //할당받은 다이스 저장
        this.sock = sock;   //소켓할당

        System.out.println("sock: " + sock);
    }

    @Override
    public void run() {

        OutputStream out = null;    //outputStream 객체 생성
        PrintWriter writer; //outStream으로 내보낼객체 writer 생성

        while (true) {
            System.out.print("게임을 진행하시겠습니까(y/n) ? ");
            String str = scan.nextLine();

            System.out.println("str: " + str);

            if (str.equals("y")) {  //대답이 y이면
                ServerCriticalSection.currentMyDice = (int)(Math.random() * 6 + 1); // 크리티컬섹션클래스안의 currentMyDice에 주사위값할당

                System.out.println("내 주사위 값: " + ServerCriticalSection.currentMyDice);

                try {
                    out = sock.getOutputStream();   //out객체를 할당 내보낼객체생성
                    writer = new PrintWriter(out, true);
                    writer.println(ServerCriticalSection.currentMyDice);    //주사위값 내보내기(송신신)
               } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {    //대답이 y가 아니라면 탈출
                break;
            }
        }
    }
}


/*
받은 다이스는 마이다이스에 할당하고 수신용객체를 생성해서 타겟다이스에 수산용객체로 들어온값을 할당한후
승리조건을 확인한다음 메시지 출력
 */

class GameRecvThread implements Runnable {  //게임을 받는 스레드
    int targetDice; //타겟다이스
    int myDice; //마이다이스

    Socket sock;    //소켓

    public GameRecvThread (Socket sock, int myDice) {   //생성자에서 소켓이랑 다이스를 입력받음
        this.sock = sock;   //받은 소켓할당
        this.myDice = myDice;   //받은주사위 할당
    }

    @Override
    public void run() {
        InputStream in; //수신용객체생성
        BufferedReader reader;

        while (true) {
            if (sock != null) { //만약 sock이 들어왔다면 아래 실행
                try {
                    in = sock.getInputStream(); //수신용객체 생성
                    reader = new BufferedReader(new InputStreamReader(in)); //수신용객체 읽어들임
                    targetDice = Integer.parseInt(reader.readLine());   //받은걸 Integer로 전환후 타켓다이스에 담음
                    System.out.println("msg: " + targetDice);

                    if (targetDice != 0) {  //만약 타켓다이스를 받았다면 승리조건확인
                        if (ServerCriticalSection.currentMyDice > targetDice) {
                            System.out.println("나의 승리");
                        } else if (ServerCriticalSection.currentMyDice < targetDice) {
                            System.out.println("상대편의 승리");
                        } else {
                            System.out.println("무승부");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class GameStartProcess extends NetworkDiceGame {
    Thread sender;  //센더스레드 생성
    Thread receiver;    //리시버스레드 생성

    public GameStartProcess () {
        super();    //NetworkDiceGame생성자 불러옴 myDice에는 숫자이미생성
    }

    public void startGame () throws IOException {
        sock = servSock.accept();   //수신을 받을때까지 대기상태
        System.out.println("[" + sock.getInetAddress() + "] client connected");
    }

    // public void startClientThread () {
    //     new GameSendClientThread();
    //     new GameRecvClientThread();
    // }

    // public void startServerThread
    public void startThread () {
        // new GameSendServerThread()
        sender = new Thread(new GameSendThread(sock, myDice));
        // new GameRecvServerThread()
        receiver = new Thread(new GameRecvThread(sock, myDice));

        sender.start();
        receiver.start();
    }
}


/*
게임을 돌려보니 상대편이 주사위를 굴릴때까지 기다리지않고 승패판정을 먼저한다. y를 누르지 않으면 sender가 실행되지않아
커런트 마이다이스의 다이스 값이 0이 나오기 때문이다. 그상태에서 비교를 진행하니

 */