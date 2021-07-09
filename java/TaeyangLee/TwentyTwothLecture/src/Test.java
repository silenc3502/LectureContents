import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public void output() throws IOException {
        FileWriter fw = null;

        try {
            fw = new FileWriter("test.txt");
            fw.write(97);
            fw.write(65);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fw.close();
        }
    }
    public static void main(String[] args) {

    }
}
