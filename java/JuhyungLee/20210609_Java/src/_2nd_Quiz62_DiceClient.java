import java.io.IOException;

public class _2nd_Quiz62_DiceClient {
    public static void main(String[] args) throws IOException {
        GameStartProcess gsp = new GameStartProcess();

        gsp.createClient();
        gsp.startThread();
    }
}