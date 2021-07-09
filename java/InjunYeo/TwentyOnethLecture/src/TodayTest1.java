import java.util.*;

/*
숫자값 2400,5000, 그리고 아무숫자나 8개정도 추가한다.
이난수들 (총10개) 를 가지고 1000개의 데이터를 마구잡이로 생성한다.
각각의 데이터들이 몇 개씩 중복 되었는지 프로그래밍 해보도록하자
그리고 이정보들을 정렬해보자.

 */
public class TodayTest1 {
    public static void main(String[] args) {

        Integer[] numbers = {2400, 5000, 356, 786, 9999, 212, 5898, 3323, 1178, 95};
        int[] numbersCount = new int[10];
        Integer[] numberIntegerCount = new Integer[10];
        int[] randNum = new int[1000];
        int[] randRealNum = new int[1000];

        Set<Integer> nums = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < 1000; i++) {
            int num = (int) (Math.random() * 10);
            randNum[i] = num;
            randRealNum[i] = numbers[randNum[i]];
        }

        for (int number : numbers) {
            nums.add(number);
        }

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 10; j++) {
                if (randRealNum[i] == numbers[j]) {
                    numbersCount[j]++;
                }
            }
        }
        System.out.println(numbersCount);

        for(int i =0;i<10;i++){
            numberIntegerCount[i]=numbersCount[i];
        }

        List<Integer> order = Arrays.asList(numbers);
        Collections.sort(order);
        System.out.println(order);

        List<Integer> sortCount = Arrays.asList(numberIntegerCount);
        Collections.sort(sortCount);
        System.out.println(sortCount);
    }
}
