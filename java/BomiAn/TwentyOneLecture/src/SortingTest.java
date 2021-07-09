import java.util.*;

public class SortingTest {
    public static void main(String[] args) {
        String[] sample = {"I", "walk", "the", "line", "Apple", "hit", "me", "Ground", "attack", "you"};

        List<String> list = Arrays.asList(sample);

        Collections.sort(list);

        System.out.println(list);

        Integer[] numbers = {1, 2, 3, 100, 77, 2314, 25540, 5};

        List<Integer> numList = Arrays.asList(numbers);

        Collections.sort(numList);

        System.out.println(numList);

        Set fruits = new HashSet();
        fruits.add("strawberry");
        fruits.add("apple");
        fruits.add("grape");
        fruits.add("banana");
        fruits.add("orange");

        List fruitList = Arrays.asList(fruits);

        Collections.sort(fruitList);

        System.out.println(fruitList);



    }
}
