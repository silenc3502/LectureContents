import java.io.FileWriter;
import java.io.IOException;

class ddd{
//6월15일 시험문제 복습..!
    public  void output(){
        FileWriter fw = null;
        try{
            fw = new FileWriter("C:/Users/tkddn/OneDrive/바탕 화면/test.txt",true);
            fw.write("97");
            fw.write("65");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Exam05 {
    public static void main(String[] args) {
      ddd gg = new ddd();
      gg.output();
    }
}
