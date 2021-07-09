// 숫자값 2400, 5000, 그리고 아무 숫자나 8개 정도 추가한다.
// 이 난수들(총 10개)을 가지고 1000개의 데이터를 마구잡이로 생성한다.
// 각각의 데이터들이 몇 개씩 중복 되었는지 프로그래밍 해보도록 하자!
// 그리고 이 정보들을 정렬해보자!
import java.util.*;

// int[] test = {2400,5000,123,34242,5315,432424,4321424,111,45345,6544}
class FrequencyChecker {
    Set<Integer> frequecySet;
    Map<Integer,Integer> frequencyMap;
    int[] backUp;

    public FrequencyChecker(int[] arr){
        frequecySet = new HashSet<Integer>();
        frequencyMap = new HashMap<Integer,Integer>();

        backUp = arr;

        for (Integer elam : arr){
            frequecySet.add(elam);
            frequencyMap.put(elam,0);
        }

        System.out.println("Set : " + frequecySet);
        System.out.println("Map : " + frequencyMap);
    }
    public void allocRandomFrequency(int num){
        for (int i = 0; i < num; i++){
            int tmp = (int)(Math.random() * 10);
            int key = backUp[tmp];

           // System.out.println(key);

            System.out.printf("%6d", key);

            if (i % 20 == 19) {
                System.out.println();
            }

            if (frequecySet.contains(key)){

                int cnt = frequencyMap.get(key);

                frequencyMap.put(key, ++cnt);

            }//else {
             //   frequencyMap.put(key, 1);
         //   }
        }
    }

    public Map<Integer, Integer> getFrequencyMap() {
        return frequencyMap;
    }
}
public class Prob60 {
    public static void main(String[] args) {
        int[] testSet = {
                2400,5000,1000,200,400,200,2121,333,412,777
        };

        FrequencyChecker fc = new FrequencyChecker(testSet);

        fc.allocRandomFrequency(200);

        System.out.println(fc.getFrequencyMap());

    }
}
