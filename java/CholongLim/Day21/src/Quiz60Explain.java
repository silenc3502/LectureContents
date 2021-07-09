import java.util.*;


// 숫자값 2400, 5000, 그리고 아무 숫자나 8개 정도 추가한다.
// 이 난수들(총 8개)을 가지고 1000개의 데이터를 마구잡이로 생성한다.
// 각각의 데이터들이 몇 개씩 중복 되었는지 프로그래밍 해보도록 하자!
// 그리고 이 정보들을 정렬해보자!

class FrequencyChecker {
    Set<Integer> frequencySet;
    Map<Integer, Integer> frequencyMap;
    int[] backUp;

    public FrequencyChecker (int[] arr) {
        frequencySet = new HashSet<Integer>();
        frequencyMap = new HashMap<Integer, Integer>();

        backUp = arr;
        //backUp =  { 2400,  5000, 1000, 200, 6000,
        //                77000, 434,  768,  20,  50 }

        for (Integer elem : arr) {
            frequencySet.add(elem);
            frequencyMap.put(elem, 0);
            // Set과 Map 각각에 arr값(elem) 셋팅
            // frequencyMap을 통해 cnt할 것, 초기 값 = 노카운트 = 0
        }

        System.out.println("frequencySet: " + frequencySet);
        System.out.println("frequencyMap: " + frequencyMap);
    }

    public void allocRandomFrequency (int num) {
//        int num  : 몇개의 데이터를 할 것인지
        for (int i = 0; i < num; i++) {
            int tmp = (int) (Math.random() * 10);
            // 0 ~ 9 (10개)
            int key = backUp[tmp];
            //int backUp[] = { 2400 , ...} stack 배열
            //int backUp[tmp] 하여 값을 랜덤화

            System.out.printf("%6d", key);

            if (i % 20 == 19) {
                // 20으로 나눴을때 19개가 남는 i번째에서 enter,
                // i가 0부터 시작이므로 20개씩 마다 enter
                System.out.println();
            }

            if (frequencySet.contains(key)) {
                // contains ( ) :  HashSet 내의 객체가 존재하는지 확인하는 코드
                // frequencySet 내의 특정 랜덤값이 존재한다면 (if)
                int cnt = frequencyMap.get(key);
                // get ( ) : key에 해당하는 value를 리턴해준다.
//                           key가 존재하지 않으면 null을 리턴한다.
                frequencyMap.put(key, ++cnt);
                // put ( ) : 인자로 key와 value를 받는다.
                //           전달된 인자는 HashMap에 key-value 관계로 저장된다.

                // frequencySet 내의 특정 랜덤값이 존재한다면 (if)
                // frequencyMap의 value값을 cnt++ 카운트해준다.
            }
            /*
            else {
                frequencyMap.put(key, 1);
            }
             */
        }
    }

    public Map<Integer, Integer> getFrequencyMap() {
        return frequencyMap;
    }
}

public class Quiz60Explain {
    public static void main(String[] args) {
        int[] testSet = {
                2400,  5000, 1000, 200, 6000,
                77000, 434,  768,  20,  50
        };

        FrequencyChecker fc = new FrequencyChecker(testSet);

        fc.allocRandomFrequency(1000);

        System.out.println(fc.getFrequencyMap());
        //System.out.println(fc);
    }
}
