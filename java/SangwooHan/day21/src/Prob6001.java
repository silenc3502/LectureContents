import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class exam0202{
    int [] captureNum;
    HashSet<Integer> Nums;
    HashMap<Integer, Integer> overlapingNums;


    exam0202(int[] arr){
        Nums = new HashSet<Integer>();
        overlapingNums = new HashMap<Integer, Integer>();
        captureNum = arr;


        for(Integer elem : captureNum){
            Nums.add(elem);
            overlapingNums.put(elem, 0);
        }
        System.out.println("내가 가지고있는 숫자들 ="+Nums);
        System.out.println("0번 돌렸을때 가지고있는 숫자들과 중복된 값들 ="+overlapingNums);
    }


    public void overlapStart(int num){
        for (int i = 0 ; i <num; i++){
             int RandomN = (int)(Math.random()*10);
             int key = captureNum[RandomN];

            if(Nums.contains(key)){
                int cnt = overlapingNums.get(key);
                overlapingNums.put(key,++cnt);
            }
        }
    }

    public HashMap<Integer, Integer> getOverlapingNums() {
        return overlapingNums;
    }
}
public class Prob6001 {
    public static void main(String[] args) {
        int[] Number =  {1,2,3,4,5,6,7,8,9,10};
        exam0202 tv = new exam0202(Number);

       tv.overlapStart(1000);

        System.out.println("1000번돌렸을때 중복된값들"+tv.getOverlapingNums());


    }
}
