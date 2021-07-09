import java.lang.reflect.Array;
import java.util.*;

public class Prob60 {
    public static void main(String[] args) {
        Integer[] arr = {1, 4, 0, 13, 88, 45, 104, 28};

        Set<Integer> numBox = new HashSet<Integer>();
        Map<Integer, Integer> numDox = new HashMap<Integer, Integer>();

        for(int element : arr) {
            numBox.add(element);
            numDox.put(element, 0);
        }


        for(int i=0; i<20; i++) {
            int random = (int)(Math.random()*8);
            int key = arr[random];

            if(numBox.contains(key)) {
                int cnt = numDox.get(key);
                //일단 numDox.get(key)에서 얻는 값은 0이다. value가 들어있지 않기 때문에.
                //get(key)는 Map안에서 key로 열어서 얻을 수 있는 value를 얻게한다.

                numDox.put(key, ++cnt);
                //전위 연산자를 사용해야한다!
                //cnt가 put되기 전에 미리 연산이 돼서 map안에 value로 들어가야하기때문이다!
                //후위 연산자(cnt++)이라면 ++되기 전 0값을 먼저 집어넣고 연산을 하기때문에, 연산하는 의미가 없어진다.
                //왜냐면 어쨋든 결국엔 put해서 들어간 값은 0이 남아있기 때문이다!
            }
        }

        System.out.println(numDox);

    }
}
