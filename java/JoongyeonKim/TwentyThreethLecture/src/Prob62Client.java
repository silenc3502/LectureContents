
import java.io.IOException;

public class Prob62Client {
    public static void main(String[] args) throws IOException {
        GameStartProcess gsp = new GameStartProcess();

        gsp.createClient();
        gsp.startThread();
    }
}
