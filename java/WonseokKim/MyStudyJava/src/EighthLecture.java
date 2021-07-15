import java.util.Scanner;

public class EighthLecture {
    public static void main(String[] args) {

       //--------실습 문제-----------//
        //2. 문자형 2차원 배열 5행 5열을 만들고 행과 열을 입력 받아 해당 좌표의 값을 'X'로 변환해 2차원 배열을 출력하시오.
        //또한 계속해서 반복 실행 하도록 구현하고 행이나 열 입력시 0미만 5이상의 수가 입력되면 프로그램을 종료하시오.

        Scanner sc = new Scanner(System.in);

        char[][] arr = new char[5][5];
        int row;
        int column;

        while (true){
            System.out.print("행 인덱스 입력 >> ");
            row = sc.nextInt();
            System.out.print("열 인덱스 입력 >> ");
            column = sc.nextInt();

            if ((row < 0 || row > 4) || (column < 0 || column > 4)){
                break;
            }
            arr[row][column] = 'X';
            System.out.println("\t0\t1\t2\t3\t4");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(i+"\t");
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("프로그램을 종료 합니다!!");



       /*
        //1. 사용자에게 행의 크기를 입력 받고 그 수 만큼의 반복을 통해 열의 크기도 받아 문자형 가변 배열을 선언 및 할당하시오.
        // 그리고 각 인덱스에 'a'부터 총 인덱스의 개수만큼 하나씩 늘려 저장하고 출력하시오.
        // 행의 크기 입력: 3
        // 0행의 열의 크기 입력: 2
        // 1행의 열의 크기 입력: 6
        // 2행의 열의 크기 입력: 3  ... a, b, c, d, e, f, g, h, i, j, k

        Scanner sc = new Scanner(System.in);
        // 행 할당
        System.out.print("행의 크기 입력: ");
        char[][] num = new char[sc.nextInt()][];

        // 열 할당
        for(int i = 0; i < num.length; i++){
            System.out.print(i + "행의 열의 크기 입력: ");
            num[i] = new char[sc.nextInt()];
        }

        //내가 풀이한 방식
        /*
        System.out.print("0행의 열의 크기 입력: ");
        num[0] = new char [sc.nextInt()];
        System.out.print("1행의 열의 크기 입력: ");
        num[1] = new char[sc.nextInt()];
        System.out.print("2행의 열의 크기 입력: ");
        num[2] = new char[sc.nextInt()];


        //초기화와 출력
        char tmp = 'a';
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = tmp++;
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
*/




        /*
        //2차원 배열 선언
        int[][] arr;
        int[] arr2[];
        int arr3[][];

        //2차원 배열 할당 : new 연산자를 통해 heap영역에 공간 생성
        arr = new int[3][5];  //3행 5열에 데이터 값이 생성

        //열의 크기 생략 가능
        //각 행마다 다른 열의 개수를 가지고 싶을 때: 가변 배열이라고 함
        arr2 = new int[2][];
        arr2[0] = new int[4];   // 이 말인 즉슨; 0행에 4개의 열을 생성해주고
        arr2[1] = new int[2];   // 이 말인 즉슨; 1행에 2개의 열을 생성한다.


        //2차원 배열에 직접 값 접근
        System.out.println(arr);  // arr의 주소값이 나오게됨
        System.out.println(arr[0]);  // arr[0] 의 주소 값 출력
        System.out.println(arr[0][0]); //실제 값에 접근
        System.out.println(arr[0][1]);


        //2차원 배열 초기화
        int num = 1;
        for(int i = 0; i < arr2.length; i++){ //0이랑 1이라는 값만 들어갈 수 있음
            for (int j = 0; j < arr2[i].length; j++) {
                // arr2 가변 배열이므로 arr2[0]은 0,1,2,3열을 가짐
                // arr2[1]dms 0,1열을 가지고 있음
                arr2[i][j] = num++;
            }
        }
        //2차원 배열 출력
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println(); // 개행
        }

         */







    }
}
