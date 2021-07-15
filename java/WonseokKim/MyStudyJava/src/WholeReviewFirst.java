import java.util.Arrays;
import java.util.Scanner;

public class WholeReviewFirst {
    public static void main(String[] args) {

        //=====종합 실습 문제=====//

        //빙고 게임
        // 사용자로부터 빙고판의 크기를 입력 받아 지정 된 수의 가로 * 세로 빙고판에
        // 1부터 가로 * 세로의 값까지의 수를 랜덤하게 발생시켜 빙고판을 만드시오.
        // 다만 중복되는 수는 없어야 하며, 숫자를 선택하면 해당 칸이 0으로 바뀌고
        // 모든 칸의 값이 0이 되면 프로그램을 종료하시오.
        Scanner sc = new Scanner(System.in);
        System.out.print("일차원 배열의 길이: ");
        int len = sc.nextInt();

        //일차원 배열로 중복 값 제거한 후 이차원 배열 대입
        int[] tempArr = new int[len * len];

        //랜덤 값 대입 후 중복 비교
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = (int) (Math.random() * (len * len) + 1);
            // 중복 값 발생하면 i--
            // 즉 i+1로 진행하지 않고 다시 i에 랜덤 값 대입 후 중복 비
            for (int j = 0; j < i; j++) {
                if (tempArr[i] == tempArr[j]) {
                    i--;
                    break;
                }
            }
        }
        // 중복 값 제거가 잘 되어있는지 일차원 배열 출력
        System.out.println(Arrays.toString(tempArr));
        // 일차원 배열 -> 이차원 배열
        int[][] arr = new int[len][len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr[i][j] = tempArr[index++];
            }
        }
        System.out.println("==========빙고 게임 시작===========");
        //빙고판 출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        //모든 자리가 0이 될때까지 무한 반복
        while (true) {
            System.out.print("숫자 선택: ");
            int num = sc.nextInt();
            //선택한 숫자를 0으로 바꾼 뒤 출력
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == num) {
                        arr[i][j] = 0;
                    }
                    System.out.print(arr[i][j] + "\t");
                }
                System.out.println();
            }

           /* //게임 종료 조건확인)모든 자리가 0이 된다
            boolean flag = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if(arr[i][j] != 0){
                      flag =true;
                    }
                  }
                }
                //모든 칸이 0이면 게임종 료
                if(flag == false) {

            }*/

            //3빙고이면 게임 종료

            int bingoCnt = 0;
            int crossCnt1 = 0;
            int crossCnt2 = 0;

            for (int i = 0; i < arr.length; i++) {
                int colCnt = 0;
                int rowCnt = 0;
                for (int j = 0; j < arr[i].length; j++) {
                    //가로
                    if (arr[i][j] == 0) {
                        rowCnt++;
                    }
                    //세로
                    if (arr[j][i] == 0) {
                        colCnt++;
                    }
                    //왼쪽에서 오른쪽 아래로 대각선
                    if (i == j && arr[i][j] == 0) {
                        crossCnt1++;
                    }
                    //오른쪽에서 왼쪽 아래로 대각선
                    if ((i + j == len - 1) && arr[i][j] == 0) {
                        crossCnt2++;
                    }
                    //가로 한줄이 모두 0이면 빙고
                    if (rowCnt == len) {
                        bingoCnt++;
                    }
                    //세로한줄이 모두 0이면 빙고
                    if (colCnt == len) {
                        bingoCnt++;
                    }
                    //왼쪽에서 오른쪽 아래로 대각선이 모두 0이면 빙고
                    if (crossCnt1 == len) {
                        bingoCnt++;
                    }
                    //오른쪽에서 왼쪽 아래로 대각선이 모두 0이면 빙
                    if (crossCnt2 == len) {
                        bingoCnt++;
                    }
                    //빙고가 3개이면 게임 종료
                    if (bingoCnt == 3) {
                        break;
                    }
                }
            }
            System.out.println("빙고 완성!!!");
            System.out.println("========빙고 게임 종료=========");















        /*

        //char <-> int 형변환에 대해 연습
        int num = 'A';
        System.out.println("num: " + num); //65

        char ch = 66;
        //char ch2 = -66; 음수는 입력할수 없음, 양수 값만 가짐
        System.out.println("ch : " + ch);  // B

        char ch2 = (char) num;
        System.out.println("ch2: " + ch2); // A

        //int 와 long 연산
        int inum = 4;
        long lnum = 8L;

        int sum = inum + (int) lnum;
        sum = (int) (inum + lnum);
        long sum2 = inum + lnum;

        System.out.println("sum : " + sum);
        System.out.println("sum2: " + sum2);

        //byte, short의 연산결과: int가 된다

        byte bnum = 1;
        short snum = 2;

        short sum3 = (short) (bnum + snum);
        int sum4 = bnum + snum;

        System.out.println("sum3: " + sum3);
        System.out.println("sum4: " + sum4);

        //삼항 연산자
        //사용자에게 값을 하나 받아서 그 값이 양수인지 음수인지 0 인지 판별

        /*
        Scanner sc = new Scanner(System.in);

        System.out.println("정수 입력: ");
        int num1 = sc.nextInt();

        String result = num1 > 0 ? "양수다" : num1 == 0? "0이다" : "음수다";
        System.out.println(result);


        
        //switch문
        Scanner sc = new Scanner(System.in);
        System.out.print("과일 이름 입력: ");
        String fruit = sc.nextLine();

        int price = 0;
        switch (fruit){
            case"귤" :
                price = 500;
                break;
            case "사과":
                price = 1000;
                break;
            case "바나나":
                price = 2000;
                break;
            default:
                System.out.println("해당하는 과일이 없습니다.");
        }
        System.out.printf("%s의 가격은 %d 원 입니다.\n", fruit, price);
*/
/*
        //중첩 반복문 구구단
        //for문
        for (int i = 2; i < 10; i++) {
            System.out.println("========" + i + "단======");
            for (int j = 1; j < 10; j++) {
                System.out.println(i + "X" + j + " = " + i*j);
            }
        }


        //while문으로 풀이

        int i = 2;
        while (i < 10){
            System.out.println("========" + i + "단======");

            for (int j = 1; j < 10; j++) {
                System.out.println(i + "X" + j + " = " + i*j);
            }
            i++;
        }


        //분기문을 이용한 중첩 반복문 구구단

        //for문(2,4,6,8단)
        for (int i = 2; i < 10; i++) {
            if(i % 2 == 1){
                continue;
            }
            System.out.println("========"+ i + "단=======");
            for (int j = 1; j < 10; j++) {
                System.out.println(i + "X" + j + " = " + i*j);
            }
        }

        //while문으로 구구단 홀수 곱

        int i = 2;
        while (i<10){
            System.out.println("========"+ i + "단=======");
            int j = 0;
            while(j<10){
                j++;
                if(j%2==0){
                    continue;
                }
                System.out.println(i + "X" + j + " = " + i*j);
            }
            i++;
        }

        // 배열 복사
        int[] originArr = {1,2,3,4,5};

        //얕은 복사
        int[] copyArr = originArr;
        System.out.println(copyArr);

        //깊은 복사 for문
        int[] copyArr2 = new int[10];
        for (int i = 0; i < originArr.length; i++) {
            copyArr2[i] = originArr[i];
            System.ou t.println(copyArr2[i]);
        }
        //깊은 복사 arraycopy()
        int[] copyArr3 = new int[10];
        System.arraycopy(originArr, 0, copyArr3, 0 ,originArr.length);
        System.out.println(copyArr3);

        //깊은복사 Arrays.copyOf()
        int[] copyArr4 = Arrays.copyOf(originArr, originArr.length);

        System.out.println(copyArr4);


        //2차원 배열 (가변 배열)
        int[][] arr = new int[2][];
        arr[0] = new int[4];
        arr[1] = new int[2];

        //초기화
        int num2 = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = num2++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

 */


            }
        }
    }