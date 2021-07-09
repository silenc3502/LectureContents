
public class Quiz0512 {
    public static void main(String[] args) {
        //11. 1-10까지 출력하는 프로그램 만들기

        for(int i=1; i<=10 ;i++)
        {System.out.println("i= " + i);}

        //------------------------------------------------
        for(int i=1; i<=10 ;i++)
        {System.out.printf("%3d", i);
            //%3d는 3칸 띄우기(숫쟈 10은 2칸을 차지하므로 3칸을 띄어야 함)
        if(i % 5 ==0){ System.out.println();
            //i값이 5로 나눠 떨어지면 엔터(println() 아무것도 입력하지 않음) 적용
        }}
        //-------------------------------------------------


        //12. 1-20에서 3의 배수를 출력하는 프로그램 만들기

        for(int i=3; i<=20 ; i+=3){
            System.out.println("3의 배수= " +i);}


        //13. 1-30까지 숫자 중 짝수와 홀수를 각각 모두 판정하도록 프로그램 만들기

         for (int i = 1; i <= 30; i++) {
            if (i % 2 == 0) {
                System.out.printf("%d 는 짝수\n", i); }
            else {
                System.out.printf("%d 는 홀수!\n", i); } }

}}
