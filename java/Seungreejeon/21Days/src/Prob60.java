import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class FrequencyChecker {
    HashSet<Integer> frequencySet;
    Map<Integer, Integer> frequancyMap;
    int[] backup;

    public FrequencyChecker(int[] arr) {
        frequencySet = new HashSet<Integer>();
        frequancyMap = new HashMap < Integer, Integer > ();

        backup = arr; //입력받은 배열 백업배열에 저장

        for (Integer elem : arr) { //입력받은 배열 set과 map의 key값에 추가
            frequencySet.add(elem);
            frequancyMap.put(elem, 0);

        }
    }

    public Map<Integer, Integer> getFrequancyMap() { //중복된 수 확인하기위한 getter
        return frequancyMap;
    }

    public void allocRandomFrequency(int num) {
        for (int i = 0; i < num; i++) {
            int tmp = (int) (Math.random() * 10);
            int key = backup[tmp]; //랜덤생성번호에 위치한 배열정보를 key 값에 대입

            System.out.printf("%6d",key);

            if (i % 5 == 4) { //줄 바꿈
                System.out.println();
            }

            if (frequencySet.contains(key)) { //키값이 포함되어있으면 true
                int cnt = frequancyMap.get(key);//해당 key 해당하는 value 값을 가져온다는 것이다
                frequancyMap.put(key, ++cnt); // 값 증가
            }
        }
    }
}

public class Prob60 {
    public static void main(String[] args) {
        int[] testSet = {
                2400, 5000, 1000, 200, 6000,
                77000, 434, 768, 20, 50
        };
        FrequencyChecker fc = new FrequencyChecker(testSet);
        fc.allocRandomFrequency(20);
        System.out.println(fc.getFrequancyMap());
    }
}
