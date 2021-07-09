import java.util.*;
public class _99th_Sorting {
    public static void main(String[] args) {
        String[] words = { "apple", "I", "WALK", "LINE", "EVENT", "Thread", "HARD", "GROUND"};
        ArrayList<String> words_arrayList = new ArrayList<>(Arrays.asList(words));
        // = List<String> list = Arrays.asList(words)라고 해도 됨.
        Collections.sort(words_arrayList); // 대문자 우선 알파벳 순으로 정렬
        System.out.println(words_arrayList);

        Integer[] numbers = {1, 2, 3, 33, 212, 213, 5135, 341, 545345, 8787};
        ArrayList<Integer> numbers_arrayList = new ArrayList<>(Arrays.asList(numbers));
        // List<Integer> numbers_arrayList = Arrays.asList(numbers) 라고 해도 됨.
        Collections.sort(numbers_arrayList);
        System.out.println(numbers_arrayList);

        Set fruits = new HashSet();
        fruits.add("melon");
        fruits.add("orange");
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("watermelon");
        fruits.add("strawberry");

        List fruitsList = new ArrayList(fruits);
        fruitsList.add("List가 됐어도 ArrayList의 method 쓸 수 있음 왜냐하면..\n" +
                "List에서 미구현된 method들이 List를 implements하고 있는 ArrayList에서\n" +
                "구현되고 있기 때문. ");
        Collections.sort(fruitsList);
        System.out.println(fruitsList);
        //sort는 List의 method이기 때문에 쓰려면 List로 변환시켜야됨.
        //List는 Collection을 상속받는 interface.
    }
}
