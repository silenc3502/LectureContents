import java.util.*;

public class SortingTest {
    public static void main(String[] args) {
        String[] sample = {"I", "walk", "the", "line", "Apple", "hit", "me", "Ground", "attack", "you"};

        List<String> list = Arrays.asList(sample);

        //정렬 법칙(대문자 우선, 그 다음 소문자)
        Collections.sort(list);

        System.out.println(list);

        Integer[] numbers = {1, 2, 3, 100, 77, 2342, 2342354, 345, 12323, 12, 4};

        List<Integer> numlist = Arrays.asList(numbers);

        Collections.sort(numlist);

        System.out.println(numlist);

        //set을 활용한 콜렉션 소트 (알파벳 순으로 정렬 시켜줌)
        Set fruits = new HashSet();

        fruits.add("strawberry");
        fruits.add("watermelon");
        fruits.add("grape");
        fruits.add("orange");
        fruits.add("apple");
        fruits.add("banana");

        List fruitsList = new ArrayList(fruits);

        Collections.sort(fruitsList);


        System.out.println(fruitsList);
    }
}
