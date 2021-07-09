import java.util.Scanner;

// 30. Student 클래스 만들기
class Student{
    int age;
    String name;
    String major;}

public class Quiz0517 {
    public static void main(String[] args) {

// 28. 1, 2, 4, 8, 16, 32, 64, 128, 256 ... n을 입력했을 때 n번째 값을 구하도록 배열을 사용하여 만들기

        System.out.print("몇 번째 항을 구할까요? ");
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();

        if (a <= 0) {
            System.out.println("계산할 수 없습니다.");}
            // 0번째 항은 없음
        else if (a < 2) {
            System.out.println("1번째 항은 = 1");}
            // 1번쨰 항은 계산 할 필요 없이 1
        else {
            int arra[] = new int[a];
            // 입력된 a값 만큼 배열 생성

            arra [0] = 1;
            // 첫번째 항은 인덱스가 0이고 값은 1

            for (int i = 1; i < a; i++) {
                // i < a 대신에 i < arr.length를 입력해도 됨
                arra[i] = arra[i - 1] * 2;}
                // 인덱스는 0번 부터 시작하고 결과 값은 1부터 시작하기 떄문에 결과값에 -1을 해주어야 함

            System.out.printf("%d번째 항은 = %d\n", a, arra[a - 1]); }
            // 마찬가지로 인덱스는 0부터 시작하기 때문에 원하는 위치의 결과를 알고 싶으면 -1을 해주어야 함



// 29. 1, 3, 9, 27, 81, 243, 729, 2187, ... n을 입력했을 때 n번째 값을 구하도록 Math.pow를 사용해서 만들기

        Scanner scan1 = new Scanner(System.in);

        System.out.print("몇 번째 항을 구할까요? ");
        int b = scan1.nextInt();

        if (b <= 0) {
            System.out.println("계산할 수 없습니다."); }

        // Math.pow를 사용하면 0제곱은 1이라는 조건을 따로 설정하지 않아도 결과값이 나옴

        else {
            int arrb[] = new int[b];

            arrb[0] = 1;

            for (int i = 1; i < b; i++) {
                arrb[i] = (int)Math.pow(3, i);}
                // Math.pow(A, B)는 A^B(A의 B승)을 계산
                // Math.pow는 double을 결과로 내놓기 때문에 강제로 int 타입으로 변형


            System.out.printf("%d 번째 항은 = %d\n", b, arrb[b - 1]);}




// 30. Student 클래스 만들기 ------------------------------------------------------------------
        Student stu = new Student();
        System.out.println("학생의 신상을 입력해주세요.");

        Scanner scan2 = new Scanner(System.in);

        System.out.print("학생의 이름을 입력하세요: ");
        stu.name = scan2.nextLine();

        System.out.print("학생의 나이를 입력하세요: ");
        stu.age = scan2.nextInt();

        scan2.nextLine();

        System.out.print("학생의 전공을 입력하세요: ");
        stu.major = scan2.nextLine();


        System.out.printf("이름: %s, 나이: %d, 전공: %s\n", stu.name, stu.age, stu.major );

}
}
