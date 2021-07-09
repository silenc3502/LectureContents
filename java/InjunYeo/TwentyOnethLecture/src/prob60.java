import java.util.*;

class FrequecyChecker{

    Set<Integer> frequencySet;
    Map<Integer,Integer> frequencyMap;
    int[] backUp;

    public FrequecyChecker(int[]arr){
        frequencySet = new HashSet<Integer>();
        frequencyMap = new HashMap<Integer,Integer>();

        backUp = arr;

        for(Integer elem : arr){
            frequencySet.add(elem);
            frequencyMap.put(elem,0);
        }


    }

    public void allocRandomFrequency(int num){
        for(int i=0;i<num;i++){
            int tmp = (int)(Math.random()*10);
            int key = backUp[tmp];

            System.out.printf("%6d",key);

            if(i%20 == 19){
                System.out.println();
            }

            if (frequencySet.contains(backUp[tmp])){
                int cnt = frequencyMap.get(key);
                frequencyMap.put(key,++cnt);
            }
            /*
            else{
                frequencyMap.put(key,1);
            }

             */
        }
    }

    public Map<Integer, Integer> getFrequencyMap() {
        return frequencyMap;
    }

    public void setFrequencyMap(Map<Integer, Integer> frequencyMap) {
        this.frequencyMap = frequencyMap;
    }
}


public class prob60 {
    public static void main(String[] args) {
        int[] testSet = {2400,5000,777,7777,123,432,7565,3212,60,999};

        FrequecyChecker fc = new FrequecyChecker(testSet);
        fc.allocRandomFrequency(1000);
        //System.out.println(fc);
        System.out.println(fc.getFrequencyMap());

    }
}
