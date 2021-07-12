//숫자값 2400, 5000, 그리고 아무 숫자나 8개 정도 추가한다.
//이 난수들(총 8개)을 가지고 1000개의 데이터를 마구잡이로 생성한다.
//각각의 데이터들이 몇 개씩 중복 되었는지 프로그래밍 해보도록 하자!
//그리고 이 정보들을 정렬해보자

//배열을 사용하여 풀어낸 문제
import java.util.Arrays;

public class NewProb60 {
    public static void main(String[] args) {
        int[] testSet = {2400, 5000, 1,2,3,4,5,6,7,8};
        int[] number = new int[1000];
        int[] count = new int[10];

        for(int i=0; i<1000; i++){
            int j=(int)(Math.random() * 10);
            number[i]= testSet[j];
            if(number[i]==testSet[j]);{  
                count[j]++;  //중복되는 만큼 카운트시킴
            }
        }
        Arrays.sort(testSet);  //Arrays.sort : 전달받은 배열의 모든 요소를 오름차순으로 정렬
        for(int i=0; i<10; i++){
            System.out.println(testSet[i] +"중복개수"+count[i]);
        }
    }
}
