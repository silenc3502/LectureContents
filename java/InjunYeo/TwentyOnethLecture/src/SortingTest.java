import java.util.*;

public class SortingTest {
    public static void main(String[] args) {
        String[] sample ={"I","walk","the","line","Apple","hit","me","Ground","attack","you"};

        List<String> list = Arrays.asList(sample);

        Collections.sort(list);

        System.out.println(list);

        Integer[] number={1,2,3,4,1232,32321,54,32,122,33,45};
        List<Integer> sortNumber = Arrays.asList(number);


        Set fruits = new HashSet();

        fruits.add("strawberry");
        fruits.add("watermelon");
        fruits.add("banana");
        fruits.add("orange");
        fruits.add("apple");
        fruits.add("grape");

        List fruitList = new ArrayList(fruits);
        Collections.sort(fruitList);
        System.out.println(fruitList);

    }
}
