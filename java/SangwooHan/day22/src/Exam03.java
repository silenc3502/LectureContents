import java.util.ArrayList;


public class Exam03 {
    public static void main(String[] args) {
            Fruits gg = new Fruits();
//6월15복습..
        ArrayList<Fruits> list = new ArrayList<Fruits>();
        list.add(new Fruits("사과","빨강"));
        list.add(new Fruits("멜론","초록"));
        list.add(new Fruits("포도","보라"));
        list.add(new Fruits("맛있는 과일"));

        for(int i = 0; i<= list.size();i ++){
            System.out.println(list.get(i));
        }
    }
}
