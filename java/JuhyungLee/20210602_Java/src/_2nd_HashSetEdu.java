import java.util.HashSet;
import java.util.Set;

public class _2nd_HashSetEdu {
    public static void main(String[] args) {
        HashSet<String> food = new HashSet<String>();
         // = HashSet<String> food = new HashSet<String>();
        food.add("우유");
        food.add("빵");
        food.add("베이컨");
        food.add("Ham");
        food.add("소시지");
        food.add("파스타");
        food.add("Ham"); //  Ham 두개 써도 하나만 add 됨.
        food.add("ham");
        // HashSet의 핵심 특성중 하나 > java내에 존재하는 collection중 가장 속도가 빠르다.
        // HashSet의 집합(set)의 특성을 가지고 있어 중복을 허용하지 않는다. 위에서 Ham을 예시로.
        // 일종의 배열. 속도가 빠른 ArrayList라고 볼 수 있다.
        // 단 순서는 HashSet 자체의 알고리즘대로 순서가 정해짐. > 순서가 중요한 알고리즘에서는 사용하지 말 것.
        // 순서가 중요하다면 ArrayList 사용.
        // HashSet으로 만들어진 배열을 ArrayList로 만들 수 있기는 함. 단 순서 보장 안됨.
        System.out.println(food);
   }
}
