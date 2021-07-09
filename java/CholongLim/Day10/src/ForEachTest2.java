import java.util.Scanner;
class ArrPrintTest{
    int[] arr;
    int i = 0;


    public ArrPrintTest(int[] inputArr) {

        int len = inputArr.length;
        arr = new int[len];
//        int i = 0;
//        수업때는 i값이 한번만 있으면 오류가 안났는데
//        제가 코드 작성한 이후로 아래에도 i값을 주지않으면 오류가 나서 클래스에
//        int i = 0; 를 선언했습니다.

        for(int data : inputArr) {
            arr[i++] = data;
        }
    }

    public void scanPrint() {
        Scanner scan = new Scanner(System.in);
        System.out.print("몇 개를 입력하시겠습니까?");
        int num = scan.nextInt();
//      int i = 0;
        arr = new int [num];

        for(i = 0 ; i < num; i++) {
            System.out.print("숫자를 입력하세요");
            arr[i] = num;
        }
    }

    public void printArr() {
        for(int data : arr) {
            System.out.println("입력값 = " + data);
        }
    }

}


public class ForEachTest2 {
    public static void main(String[] args) {
        int[] ap = {1, 2, 3, 4, 5, 6, 7};
        ArrPrintTest apt = new ArrPrintTest(ap);
        apt.printArr();

//        ArrPrintTest apt2 = new ArrPrintTest();
//        apt2.printArr();

//        new ArrPrintTest()부분에서 ()안에 빨간줄 오류가 생기며
//        입력값을 받을 수 없습니다.
//        이유가 무엇일까요?


    }
}
