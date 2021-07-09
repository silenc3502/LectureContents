import java.io.IOException;

public class Prob62Client {
    public static void main(String[] args) throws IOException {
        NetworkDiceGame ndg = new NetworkDiceGame();

        ndg.createClient();
    }
}