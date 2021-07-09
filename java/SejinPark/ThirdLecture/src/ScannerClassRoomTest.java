import java.util.Scanner;

// 클래스 배열을 사용하므로
// 1. 직원 정보에는 이름과 자신의 페이가 기록됨
//    여기서 페이는 배열로 작성하여 연별값을 얻을 수 있어야함
// 2. 초봉 설정은 2400 ~ 3500
// 3. 매년 인상률은 변동하며 1 ~ 20%임 (데이터가 궁금할 수 있으므로 배열로 관리한다)
// 4. 각각의 페이 정보(클래스 배열들)에 대한 합산 결과가 요구됨 ---> 연별 평균
//    새로운 개념인 유틸리티 매서드(static 매서드)를 사용
// 5. Scanner 사용이 필요하므로 학생 이름이 키보드로 넘어옴
// 6. 또 몇명을 입력할 것인지에 대한 정보가 추가로 필요함
class Employee {
    final float PERCENT = 0.01f;

    String name;
    int[] pay;
    float[] incRate;

    int curYear;

    public Employee (String name, int year) {     //생성자에서 파라미터로 입력을 받고, 변수들을 초기화만 해줌
        this.name = name;
        curYear = 0;

        pay = new int[year];
        incRate = new float[year];

        pay[0] = (int)(Math.random() * 1101 + 2400);
    }

    public void calcYearPay () {
        for (int i = curYear + 1; i < pay.length; i++) {
            pay[i] = pay[i - 1] + (int)(pay[i - 1] * getRandomIncRate() * PERCENT);
        }
    }

    public void printPay () {
        for (int i = 0; i < pay.length; i++) {
            System.out.printf("%s님의 %d년차 연봉은 %d입니다.\n", name, i + 1, pay[i]);
        }
    }

    public float getRandomIncRate () {
        return (float)(Math.random() * 20 + 1);
    }

    public int[] getPay() {
        return pay;
    }
    public int getYearPay(int year) {
        return pay[year];
    }
}

public class ScannerClassRoomTest {
    // static은 정적 변수로 메모리 레이아웃으로 치면 data 섹션에 잡힘

    // --------------
    // | Stack      |
    // --------------
    // | Heap       |
    // --------------
    // | Data       | <<<<<<<--- 이 영역에 잡히는 것은 전역 변수로서 역할을 수행함
    // --------------
    // | Text(Code) |
    // --------------

    // 그렇기 때문에 static 으로 선언된 녀석들은 new가 없어도 사용이 가능한 것임
    // 대표적으로 ? main() 매서드가 new 없이 사용했었고 static이 붙어있음

    static final Scanner scan = new Scanner(System.in);                 //Q.이 줄이 입력받는 Scanner를 heap영역이 아닌
                                                                        //static 정적으로 미리 할당해놓은 것인가요?

    public static String inputName () {                                 //Q.final키워드는 바꿀수없는 상수를 표시하는데,
        System.out.print("학생 이름을 입력하세요: ");                      //계속 달라질수있는 Scanner클래스에 final이 붙여진 이유가
        return scan.nextLine();                                         //무엇인지 궁금합니다.

    }
    public static int inputYear () {
        Boolean isTrue = false;
        int num;

        do {
            System.out.print("몇 년치를 계산할까요 ? ");

            num = scan.nextInt();

            if (num <= 0) {
                System.out.println("0 보다 큰 숫자를 입력해주세요!");
                isTrue = true;
            }
        } while (isTrue);

        return num;
    }

     public static void main(String[] args) {
        final int YEAR = 10;

        System.out.print("몇 명의 학생 정보를 입력할까요 ? ");
        int studentNum = scan.nextInt();
        scan.nextLine();                                //바로 다음으로 넘어가지않게 하기위해 scan.nextLine()을 꼭 넣어줌

        Employee[] emp = new Employee[studentNum];

        for (int i = 0; i < studentNum; i++) {
           // emp[i] = new Employee(inputName(), YEAR);

            emp[i] = new Employee(inputName(), inputYear());
            //scan.nextLine();

            emp[i].calcYearPay();
            emp[i].printPay();
        }
    }
}