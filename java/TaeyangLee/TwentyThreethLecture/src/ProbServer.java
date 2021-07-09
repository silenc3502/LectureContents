import sun.nio.ch.Net;

import java.io.IOException;

public class ProbServer {
    public static void main(String[] args) throws IOException {
        GameStartProcess gsp = new GameStartProcess();

        gsp.createServer();
        gsp.startGame();
        gsp.startThread();
    }
}