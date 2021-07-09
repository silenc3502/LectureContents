public class Quiz0514Prob25 {
    public static void main(String[] args) {
// 25. 1-100까지의 숫자 중 2의 배수는 모두 더한다. 5의 배수는 모두 뺸다. 11의 배수는 모두 더한다.
//     (중복은 무시한다.)

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 2 ==0 && i % 5 == 0 && i % 11 == 0) {}
            else if(i % 2 == 0 && i % 5 == 0){}
            else if(i % 2 == 0 && i % 11 == 0){}
            else if(i % 5 == 0 && i % 11 == 0 ){}
            else if(i % 2 ==0){sum += i;}
            else if(i % 5 == 0){sum -= i;}
            else if (i % 11 == 0){sum += i;}}
        System.out.println(sum);





    }




}