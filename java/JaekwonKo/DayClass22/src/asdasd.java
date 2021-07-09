import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class asdasd {
    public void output() {
        FileWriter fw = null;
        try {

            fw = new FileWriter("test.txt");
            fw.write(97);
            fw.write(65);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


// 맨마지막에 클로우즈
// 파이널리


// 중소기업, 종합광고마케팅
//



// 하나가 플룻이아니라 스트링
// 등호 포함하면 안됨