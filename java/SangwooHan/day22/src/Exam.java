import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Test1{
    Integer [] Number = {1,2,3,4,5,6,7,8,9,10};
    ArrayList<Integer> Num = new ArrayList<Integer>(Arrays.asList(Number));
    HashMap<Integer,String> map  =new HashMap<Integer, String >();


    public Test1(){
        System.out.println("안녕하세요 반갑습니다.");
        map.put(3,"쓰레기");
        map.put(5, "분리수거함");
        map.put(6, "깡통,캔,비닐,종이");
        System.out.println(map);
        System.out.println(Num);
        Num.remove(0);
        System.out.println(Num);
        Num.add(1);
        System.out.println(Num);
        Num.clear();
        System.out.println(Num);
    }

//복습..
}
public class Exam {
    public static void main(String[] args) {
        Test1 gg =  new Test1();
    }
}
