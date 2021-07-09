import java.io.IOException;

public class Quiz0609Prob62Client {
    public static void main(String[] args) throws IOException {
        GameStartProcess gsp = new GameStartProcess();

        gsp.createClient();
        gsp.startThread();
    }
}