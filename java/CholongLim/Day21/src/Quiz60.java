import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//숫자값 2400, 5000, 그리고 아무 숫자나 8개 정도 추가한다.
//이 난수들(총 8개)을 가지고 1000개의 데이터를 마구잡이로 생성한다.
//각각의 데이터들이 몇 개씩 중복 되었는지 프로그래밍 해보도록 하자!
//그리고 이 정보들을 정렬해보자!
class RandGame {
    Set<Integer> num;
    Map<Integer,Integer> check;
    int randNum;
    int whatIsNum[];

    public RandGame(int arr[]){
        num = new HashSet<Integer>();
        check = new HashMap<Integer,Integer>();

        whatIsNum = arr;
        for(Integer idx : arr){
            num.add(idx);
            check.put(idx,0);
        }
    }

    public Map<Integer, Integer> getCheck() {
        return check;
    }

    // 1000개의 데이터를 랜덤으로
    public void thousandNum(){
        for(int i = 0; i < 1000; i++){
            randNum = (int)(Math.random() * 6);
            int key = whatIsNum[randNum];
            if(num.contains(key)){
                int cnt = check.get(key);
                check.put(key,++cnt);
            }
        }
    }
}
public class Quiz60 {
    public static void main(String[] args) {

        int num[] = {480, 720, 1080, 1920, 2048, 4096};

        RandGame rg = new RandGame(num);
        rg.thousandNum();

        System.out.println(rg.getCheck());
        }
}

