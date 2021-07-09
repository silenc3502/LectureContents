import java.sql.Array;
import java.util.*;

public class SortingPrac {
    public static void main(String[] args) {
        String wds[] = {"Sun", "Moon", "Star", "Wind", "Earth", "Fall"};

        ArrayList<String> wdsList = new ArrayList<String>(Arrays.asList(wds));
        //System.out.println(wdsList); //ArrayList는 기존 배열의 순서대로 값이 들어가있고 출력된다.

        List<String> list = Arrays.asList(wds); //Arraylist와 List는 다르다. List는 new를 하지 않아도 만들 수 있다.
        System.out.println(list);

        Collections.sort(list);
        Collections.sort(wdsList); //Arraylist형식 배열도 Collections.sort가 가능하다.

        //System.out.println(wdsList);
        System.out.println(list);
        //Collections.sort를 한 배열들은 알파벳, 숫자 순으로 정렬되는걸 볼 수 있다.

        int[] numArr = {1, 33, 4, 95, 83, 27, 105, 64};

        Set<Integer> numSet = new HashSet<Integer>();
        for(int element : numArr) {
            numSet.add(element);
        }
        System.out.println(numSet);

        ArrayList<Integer> numList = new ArrayList<Integer>(numSet);

        Collections.sort(numList);
        System.out.println(numList);




    }
}

