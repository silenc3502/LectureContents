import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
      //여기다가 그냥 Set<String> set = new HashSet<String>(); 으로 Hash를 뺴도 똑같이 작동하는데,
      // 그냥 Set이랑 Hashset이랑 근본적으로 뭐가 다른지 궁금하다.
        set.add("우유");
        set.add("짜짱면");
        set.add("피자");
        set.add("베이컨");
        System.out.println(set);




    }

}
