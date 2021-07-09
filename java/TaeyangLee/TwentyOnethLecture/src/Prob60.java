import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class FrequencyChecker{
    Set<Integer> frequencySet;
    Map<Integer, Integer> frequencyMap;
    int[] backUp;

    public FrequencyChecker (int[] arr){
        frequencySet = new HashSet<Integer>();
        frequencyMap = new HashMap<Integer,Integer>();
        backUp = arr;


        for(Integer elem : arr){
            frequencySet.add(elem);
            frequencyMap.put(elem, 0);
        }
        System.out.println("frequencySet : "+frequencySet);
        System.out.println("frequencyMap : " + frequencyMap);
    }

    public Map<Integer, Integer> getFrequencyMap() {
        return frequencyMap;
    }

    public void allocRandomFrequency(int num){
        for(int i = 0; i < num; i++){
            int tmp = (int)(Math.random()*10);
            int key = backUp[tmp];
            if(frequencySet.contains(key)){
                int cnt = frequencyMap.get(key);
                frequencyMap.put(key, ++cnt);
            }
           /* else{
                frequencyMap.put(key,1);
            }*/

        }
    }
}



public class Prob60 {
    public static void main(String[] args) {
        int[] testSet = {2400, 5000, 1000, 200, 6000, 7700, 8600, 42, 2, 13};

        FrequencyChecker fc = new FrequencyChecker(testSet);

        fc.allocRandomFrequency(1000);

        System.out.println(fc);
        System.out.println(fc.getFrequencyMap());
    }
}
