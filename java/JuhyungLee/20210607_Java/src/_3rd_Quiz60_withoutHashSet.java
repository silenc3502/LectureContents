import java.util.*;

class Duplicate_check2{

    private Map<Integer, Integer> duplicateCheckMap;
    ArrayList<Integer>backup;

    public Duplicate_check2(Integer[] arr_want_check){
        duplicateCheckMap = new HashMap<Integer, Integer>();
        backup = new ArrayList<Integer>(Arrays.asList(arr_want_check));

        for (Integer element : arr_want_check){
            duplicateCheckMap.put(element, 0);
        }

        System.out.println("MAP: " + duplicateCheckMap);
    }
    public void allocRandomDuplicate (int num){
        for(int i = 0; i < num; i++){
            int tmp = (int)(Math.random()*10);
            int key = backup.get(tmp);

            System.out.printf("%6d", key);
            if (i % 20 == 19){ // 줄바꾸기용
                System.out.println();
            }

            if(backup.contains(key)){
                int cnt = duplicateCheckMap.get(key);
                duplicateCheckMap.put(key, ++cnt);
            }
        }
    }
    public Map<Integer, Integer> getDuplicateCheckMap() {
        return duplicateCheckMap;
    }
}

public class _3rd_Quiz60_withoutHashSet {
    public static void main(String[] args) {
     /*
    아무 숫자 10개 설정.
    이 난수들을 가지고 1000개의 data를 마구잡이로 생성한다.
    각각의 데이터들이 몇 개씩 중복되었는지 프로그래밍.
    그리고 이 정보들을 정렬
     */

        Integer[] testSet = {100, 200, 5, 15, 22, 50, 1245, 23331, 77777, 77};

        Duplicate_check2 dc2 = new Duplicate_check2(testSet);
        dc2.allocRandomDuplicate(100);
        System.out.println("MAP: " + dc2.getDuplicateCheckMap());
    }
}