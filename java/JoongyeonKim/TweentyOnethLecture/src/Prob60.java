//숫자값 2400, 5000, 그리고 아무 숫자나 8개 정도 추가한다.
//이 난수들(총 8개)을 가지고 1000개의 데이터를 마구잡이로 생성한다.
//각각의 데이터들이 몇 개씩 중복 되었는지 프로그래밍 해보도록 하자!
//그리고 이 정보들을 정렬해보자
import java.util.*;

class FrequencyChecker {
    Set<Integer> frequencySet; //전역변수로 지정만하고 값은 생성자에서 초기화한다
    Map<Integer, Integer> frequencyMap;
    int[] backUp;  // frequencySet을 직접 key에 대입하면 에러걸려서 만듬

    public FrequencyChecker (int[] arr) {  //생성자에 값을 초기화 해준다  int[] arr에 testSet을 대입한다
        frequencySet = new HashSet<Integer>();
        frequencyMap = new HashMap<Integer, Integer>();  //HashMap의 특징은 (Key, Value)를 입력하고 key값으로 value값을 얻는다

        backUp = arr; 

        for (Integer elem : arr) {  //frequencySet에 인덱스값을  frequencyMap의 key값에 인덱스값을 지정한다
            frequencySet.add(elem);
            frequencyMap.put(elem, 0); //put은 HashMap의 (Key, Value)을 입력하는 역할을 한다
        }

        System.out.println("frequencySet: " + frequencySet);  //frequencySet 값이 제대로 입력됐는지 확인한다
        System.out.println("frequencyMap: " + frequencyMap);  //frequencyMap 값이 제대로 입력됐는지 확인한다
    }

    public void allocRandomFrequency (int num) {  //지역변수 num을 만든다
        for (int i = 0; i < num; i++) {
            int tmp = (int) (Math.random() * 10);
            int key = backUp[tmp];

            System.out.printf("%6d", key);  //6은 간격을 6칸 띄우는 것을 의미한다

            // 0~19: 20개
            // 20~39: 20개
            if (i % 20 == 19) {  // 20개씩 나열하기
                System.out.println();
            }

            if (frequencySet.contains(key)) {  
                int cnt = frequencyMap.get(key); //Map에 나왔던 인덱스 값을 cnt에 대입한다
                frequencyMap.put(key, ++cnt);  // 인덱스값이 나올때마다 +1을 하여 얼마나 나왔는지 확인한다
            }
        }
    }

    public Map<Integer, Integer> getFrequencyMap() {
        return frequencyMap;
    }
}

public class Prob60 {
    public static void main(String[] args) {
        int[] testSet = {
                2400,  5000, 1000, 200, 6000,
                77000, 434,  768,  20,  50
        };

        FrequencyChecker fc = new FrequencyChecker(testSet);

        fc.allocRandomFrequency(1000);  //메소드의 소괄호안에 변수를 만든 후 값을 설정한다

        System.out.println(fc.getFrequencyMap());  //각 인덱스 값이 얼마나 나왔는지 출력한다
        //System.out.println(fc);
    }
}