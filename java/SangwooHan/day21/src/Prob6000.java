import java.util.*;

class Prob60Test {
    Set<Integer> frequencySet;
    Map<Integer, Integer> frequencyMap;
    int[] backup;

    public Prob60Test(int[] arr) {
        frequencySet = new HashSet<Integer>();
        frequencyMap = new HashMap<Integer, Integer>();
        backup = arr;

        for (Integer elem : arr) {
            frequencySet.add(elem);// Set에다가 원소하나씩 넣어주고있다.
            frequencyMap.put(elem, 0);// key값에다가 하나씩 넣어주고있다.
        }
            System.out.println("frequencySet:" + frequencySet);
            System.out.println("frequencyMap:" + frequencyMap);
    }


        // 정수 1000넘겨받고
    public void allocRandomFrequency(int num) {
        for (int i = 0; i < num; i++) {
            int tmp = (int) (Math.random() * 10);
            //tmp가 매포문 마다 난수 0~9까지 난수뿌림 ,즉 10개 난수

            int key = backup[tmp];  //key값은  backup[tmp]즉,{2400,5000,1000,4433,2333,7886,4565,1500,3000,1800};중 하나를
            //키값으로 지정.

            //만약 frequencySet에 key가 있으면~
            if (frequencySet.contains(key)) {
                // cont 는 frequencyMap.get(key)   key를 불렀을떄 value가 오니까 밸류는 최초 0
                int cont = frequencyMap.get(key);

                frequencyMap.put(key, ++cont); // 만약 2400이걸렸다하면,  이프문에서 2400일때~
                //  2400이 걸릴떄마다 cont라는 밸류값을 1씩 올리겠다.
                //이값을 겟터로 넘겨줄 장치를만들고 넘겨받으면 끝~!
                /*

            }else{
                frequencyMap.put(key,1);
            }
                 */

            }
        }




    }
    public Map<Integer, Integer> getFrequencyMap() {
        return frequencyMap;
    }
}
public class Prob6000 {
    public static void main(String[] args) {
        int[]testset = {2400,5000,1000,4433,2333,7886,4565,1500,3000,1800};
        Prob60Test fc = new Prob60Test(testset);

        fc.allocRandomFrequency(1000);
        System.out.println(fc.getFrequencyMap());
    }
}
