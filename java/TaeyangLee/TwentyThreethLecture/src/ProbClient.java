import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class ProbClient {

        public static void main (String[]args) throws IOException {
            GameStartProcess gsp = new GameStartProcess();

            gsp.createClient();
            gsp.startThread();
        }

}