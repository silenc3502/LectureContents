import java.util.HashSet;
import java.util.Set;

// 60. 랜덤 중복체크 하기 -------------------------------------------------------------------------
// 숫자값 2400, 5000 ... 총 10개의 난수 만들기
// 이 난수를 가지고 1000개의 데이터를 랜덤으로 생성
// 각각의 데이터들이 몇 개씩 중복 체크하고 정렬하기

public class Quiz0607Prob60 {
    public static void main(String[] args) {
        int randNum;
        Integer[] num = {2400, 5000, 6850, 4851, 2314, 1254, 3265, 8542, 9485, 5624};
        int[] dup = new int[10];
        Set<Integer> set = new HashSet<Integer>();


        for(int i = 0; i < 1000; i++){
            randNum = (int)(Math.random() * 10);
            System.out.println("num = " + num[randNum]);
            set.add(num[randNum]);

            if (!set.add(num[randNum])){
                dup[randNum]++;
                System.out.println("중복된 num = " + num[randNum]);
            }

        }
        for(int i = 0; i < 10; i++){
            System.out.printf("%s의 중복된 개수 : %s\n", num[i], dup[i]);
        }



    }
}
