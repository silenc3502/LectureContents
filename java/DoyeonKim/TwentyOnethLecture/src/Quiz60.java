import java.util.*;

class FrequencyChecker {
    Set<Integer> frequencySet;
    Map<Integer, Integer> frequencyMap;
    int[] backUp;

    public FrequencyChecker (int[] arr) {
        frequencySet = new HashSet<Integer>();//새로운 HashSet
        frequencyMap = new HashMap<Integer, Integer>(); //HashMap

        backUp = arr;

        for (Integer elem : arr) {
            frequencySet.add(elem);//중복되지 않는 형태로 들어감
            frequencyMap.put(elem, 0); //key값 elem value는 0
        }

        System.out.println("frequencySet: " + frequencySet);
        System.out.println("frequencyMap: " + frequencyMap);
    }

    public void allocRandomFrequency (int num) { //몇개를 만들것인지 지정
        for (int i = 0; i < num; i++) {
            int tmp = (int) (Math.random() * 10); //10개의 난수
            int key = backUp[tmp]; // 백업본

            System.out.printf("%6d", key); //77000까지 있어야하니 6자리 확보

            if (i % 20 == 19) {
                System.out.println();
            }
//백업본에 있는게 있냐 없냐
            if (frequencySet.contains(key)) { //tmp값에 대한 idx를 get
                int cnt = frequencyMap.get(key); //키값을 포함
                frequencyMap.put(key, ++cnt); //키값과 벨류값은 1
            }
            /*
            else {
                frequencyMap.put(key, 1);
            }
             */
        }
    }

    public Map<Integer, Integer> getFrequencyMap() { //getter
        return frequencyMap;
    }
}

public class Quiz60 {
    public static void main(String[] args) {
        int[] testSet = {
                2400,  5000, 1000, 200, 6000,
                77000, 434,  768,  20,  50
        };

        FrequencyChecker fc = new FrequencyChecker(testSet);

        fc.allocRandomFrequency(1000); //한계 할당

        System.out.println(fc.getFrequencyMap());
        //System.out.println(fc);
    }
}