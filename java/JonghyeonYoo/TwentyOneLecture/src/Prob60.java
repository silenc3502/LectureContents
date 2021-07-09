import java.util.*;

class FrequencyChecker {
    Set<Integer> frequencySet;
    Map<Integer, Integer> frequencyMap;
    int[] backup;

    public FrequencyChecker(int[] arr) {
        frequencySet = new HashSet<Integer>();
        frequencyMap = new HashMap<Integer, Integer>();

        backup = arr;

        for(Integer elem : arr){
            frequencySet.add(elem);
            frequencyMap.put(elem, 0);
        }

        System.out.println("frequencySet : " + frequencySet);
        System.out.println("frequencyMap : " + frequencyMap);
    }

    public void allocRandomFrequency (int num) {
        for(int i = 0; i < num; i++) {
            int tmp = (int)(Math.random() * 10) ;
            int key = backup[tmp];

            System.out.printf("%6d", key);

            if (i % 20 == 19) {
                System.out.println("");
            }
            if(frequencySet.contains(key)) {
                int cnt = frequencyMap.get(key);
                frequencyMap.put(key, ++cnt);
            }
        }
    }

    public Map<Integer, Integer> getFrequencyMap() {
        return frequencyMap;
    }
}

public class Prob60 {
    public static void main(String[] args) {
// 숫자값 2400, 5000, 그리고 아무 숫자나 8개 정도 추가한다.
// 이 난수들(총 8개)을 가지고 1000개의 데이터를 마구잡이로 생성한다.
// 각각의 데이터들이 몇 개씩 중복 되었는지 프로그래밍 해보도록 하자!
// 그리고 이 정보들을 정렬해보자!
 int[] num = {2400, 5000, 300, 400, 500 ,600 ,700, 80000, 900, 1000};
 FrequencyChecker fc = new FrequencyChecker(num);

 fc.allocRandomFrequency(100);

        System.out.println(fc.getFrequencyMap());
    }
}