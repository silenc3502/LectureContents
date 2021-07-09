import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.lang.reflect.Array;
import java.util.*;

public class SortingTest {
    public static void main(String[] args) {
        String [] sample = {"I", "walk", "the", "line", "Apple", "hit", "me", "Ground", "attack", "you"};

        List<String> list = Arrays.asList(sample);

        // 정렬 법칙(대문자 우선 , 그 다음 소문자)
        Collections.sort(list);

        System.out.println(list);

        Integer[] sample1 = {1,2,3,4,100,77,22,2434,432,543,13};

        List<Integer> numList = Arrays.asList(sample1);

        Collections.sort(numList);

        System.out.println(numList);

        Set fruits = new HashSet();

        fruits.add("딸기");
        fruits.add("포도");
        fruits.add("참외");
        fruits.add("수박");
        fruits.add("파인애플");
        fruits.add("사과");

        List fruitsList = new ArrayList(fruits);

        Collections.sort(fruitsList);

        System.out.println(fruitsList);

    }
}
