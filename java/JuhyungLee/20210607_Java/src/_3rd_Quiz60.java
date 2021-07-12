import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
class Duplicate_check{

    private Set<Integer> duplicateCheckSet;
    private Map<Integer, Integer> duplicateCheckMap;
    int[] backup;

    public Duplicate_check(int[] arr_want_check){
        // '10개의 숫자를 값으로 가지는 '배열'을 인자로 하는 생성자
        duplicateCheckSet = new HashSet<Integer>();
        duplicateCheckMap = new HashMap<Integer, Integer>();
        backup = arr_want_check;
        // 인자로 받은 배열을 백업할 수 있는 'backup' 배열을 만든다면
        // 굳이 HashSet을 이용할 필요가 있을까??
        // HashSet 없이 푸는 방법 >> 3rd_Quiz_withoutHashSet
        for (Integer element : arr_want_check){
            duplicateCheckSet.add(element);
            duplicateCheckMap.put(element, 0);
            // HashSet과 HashMap setting
            // HashMap의 key값은 10개의 숫자들로 setting되고
            // 그 value의 초기값을 0으로 setting한다.
        }
        System.out.println("SET: " + duplicateCheckSet);
        System.out.println("MAP: " + duplicateCheckMap);
    }
    public void allocRandomDuplicate (int num) {
        // num번을 실행시켜서 중복이 몇 번 나오는지 알아보는 method.
        for (int i = 0; i < num; i++) {
            int tmp = (int) (Math.random() * 10);
            int key = backup[tmp];
            // backup에 저장되어 있는 숫자를 random으로 뽑는 code
            // 뽑힌 수를 int key에 대입.

            System.out.printf("%6d", key);
            if (i % 20 == 19) { // 20개씩 나열 후 줄바꾸기
                System.out.println();
            }
            // if문을 굳이 돌릴 필요가 없는 것 같다.
            if (duplicateCheckSet.contains(key)) {
                int cnt = duplicateCheckMap.get(key);
                duplicateCheckMap.put(key, ++cnt);
                // 지금까지 count되어 있는 value값을 불러와서(초기에는 0부터 시작)
                // +1을 해주고 다시 그 값을 해당 key에 맞는 value에 대입.
            }
        }
    }
    public Map<Integer, Integer> getDuplicateCheckMap() {
        return duplicateCheckMap;
    }
}
public class _3rd_Quiz60 {
    public static void main(String[] args) {
     /*
    아무 숫자 10개 설정.
    이 난수들을 가지고 100개의 data를 마구잡이로 생성한다.
    각각의 데이터들이 몇 개씩 중복되었는지 프로그래밍.
    그리고 이 정보들을 정렬
     */
        // HashSet이용하는 방법으로 풀이
        // 아무 숫자 10개를 int[]에 setting 하고
        // 그 배열을 HashSet으로 만든다.
        // 그리고 HashMap을 이용해서 key 값에 10개의 숫자들을 setting하고
        // value 초기값을 0으로 하고 중복될 때마다 1씩 증가(++cnt)하는 method를 만들고
        // 그 method를 100번 돌린다.

        int[] testSet = {100, 200, 5, 15, 22, 50, 1245, 23331, 77777, 77};
        Duplicate_check dc = new Duplicate_check(testSet);
        dc.allocRandomDuplicate(100);
        System.out.println("MAP: " + dc.getDuplicateCheckMap());
    }
}
