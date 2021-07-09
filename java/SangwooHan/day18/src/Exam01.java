import java.util.HashMap;
import java.util.Map;

class inSect{
    int age;
    String name;

    public inSect(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "inSect{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Exam01 {
    public static void main(String[] args) {
        Map<Integer,inSect> et = new HashMap<Integer,inSect>();
        et.put(1 , new inSect(2,"나비"));
        et.put(2, new inSect(3,"왕사슴벌레"));
        et.put(3,new inSect(5,"대충오래사는벌레"));
        System.out.println(et);
//map 안에서의  Integer가 key를 말하는거 같고 inscect가 value를 말하는 것같다.
    }
}
