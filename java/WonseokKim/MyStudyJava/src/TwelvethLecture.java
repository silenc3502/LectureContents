import java.util.Arrays;
import java.util.Random;

public class TwelvethLecture {
    // package와 import의 관하여

    // java.lang  --> 자바.랭이라는 임포트 클래스임
    public double piExam() {
        double d = Math.PI;
        return d;
    }

    // java.util Random class
    public int randomExam(int ran){
        Random r = new Random();
        int i = r.nextInt(ran);
        return i;
    }

    // java.util Arrays class sort 메소드 사용
    public String sortExam() {
        int[] arr = {1, 8, 3, 2, 6, 7, 0};
        Arrays.sort(arr);
        return Arrays.toString(arr);

    }
}
