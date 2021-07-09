import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 배열 객체는 결국 메모리고 배열의 이름은 이 배열 객체의 대표로 전체 메모리를 전달하게 된다
// 위의 한 줄이 이 질문에서 제일 중요한 한 줄이라 보면 되겠다
// int[] arr에서 arr은 배열 객체 전체
// arr[5]와 같은 특정 인덱스 지정은 변수와 동일하게 값을 전달한다

// 배열의 이름은 배열의 대표로 객체가 전달된다(원본 형태로)
// 배열 전달시 인덱스 지정하여 전달하면 값이 전달된다.
// 클래스에 메모리에 올린 객체를 전달하면 말 그대로 객체가 전달된다.
// 나머지는 전부 값이라 본다.

// 객체(메모리)를 요청하면 원본을 준다.
// ** 객체내에 들어있는 객체를 요청하면 원본을 준다 **
// 객체내에 들어있는 값을 요청하면 이 값을 복사해서 준다.
// 게터에서도 값을 리턴하는 것은 전부 복제다.
// 게터에서도 객체를 리턴하는 것은 메모리 즉, 원본이다.
// 인간 vs 복제인간과 유사하다고 보면 된다
// :DNA가 같아도 나는 나 쟤는 쟤

////
// 객체는 메모리 자체를 전달하며
// 값은 메모리가 아닌 값을 전달한다

class CloneMemory   {
    int[] arr;
    int num;

    public CloneMemory()    {
        arr = new int[3];
        num = 3;

        for (int i=0; i < 3; i++)   {
            arr[i] = (int) (Math.random() * 6 + 1);
        }
    }

    public void reRandArr() {
        for (int i = 1; i < 3; i++){
            arr[i] = (int) (Math.random() * 6 + 1);
        }
    }

    public void reNum() {
        num = 7;
    }

    public int[] getCloneArr()  {
        return arr;
    }

    public int getCloneVariable()   {
        return num;
    }

    @Override
    public String toString() {
        return "arr[0] = " + arr[0] +
                ", arr[1] = " + arr[1] +
                ", arr[2] = " + arr[2];
    }
}


class Shop  {
    ArrayList<String> shopLists;
    Scanner scan;

    public Shop ()  {
        shopLists = new ArrayList<String>();
        scan = new Scanner(System.in);
    }

    public void deliveryOrder() {
        System.out.print("필요한 물품을 말씀해주세요");
        shopLists.add(scan.nextLine());
    }

    public void cancelOrder()   {
        System.out.print("취소할 물품을 말씀해주세요");
        shopLists.remove(scan.nextLine());
    }

    @Override//alt INS로 자동완성
    public String toString() {
        return "Shop{" +
                "shopLists=" + shopLists +
                '}';
    }
}

public class Review14_1 {
    public static void main(String[] args) {
        ////47. 숙제: 복습
        //클래스와 매서드의 재활용성에 대해 생각해볼 필요가 있다.
        //책임과 역할이 분명한 매서드의 중요성에 대해서도 생각해보자!
        //소프트웨어 아키텍처 분야에서는 SRP 규칙이라고도 한다.

        // : ArrayList :
        // 일종의 배열이다.
        // 기존에 쓰던 그 배열은 사이즈를 지정하고 넣어야 했지만
        // 얘는 그냥 막 넣어도 된다(Heap을 이용한 동적할당을 수행)
        // ArrayList<내부에 저장할 데이터 타입> 변수명 = new ArrayList<내부에 저장할 데이터 타입>
        // 일반 배열과의 차이점
        // 배열은 메모리가 연속적으로 배치되지만, ArrayList는 불연속 배치다
        // | 데이터1 | 다음링크 | ---> | 데이터2 | 다음링크 | ---> | 데이터3 | 다음링크 | ---> ....
        // 배열은
        // | 데이터1 | 데이터2 | 데이터3 | 데이터4 | 데이터5 | 데이터6 | 데이터7 | ...

        ArrayList<String> lists = new ArrayList<String>();

        lists.add("과자");
        lists.add("우유");
        lists.add("빵");
        

        for (String list : lists)   {
            System.out.println("현재 항목은 = " +list);
        }

        Shop cd = new Shop();

        for (int i = 0; i < 3; i++) {
            cd.deliveryOrder();
        }

        cd.cancelOrder();

        System.out.println(cd);



        CloneMemory cm = new CloneMemory() ;

        System.out.println(cm);

        int[] save = cm.getCloneArr();

        System.out.printf("save[0] = %d, save[1] = %d, save[2] = %d\n", save[0], save[1], save[2]);

        cm.reRandArr();

        System.out.println("객체에 접근해 출력");
        System.out.println(cm);

        System.out.println("사전 저장 정보 출력");
        System.out.printf("save[0] = %d, save[1] = %d, save[2] = %d\n",
                save[0], save[1], save[2]);

        // 결론: 자바에서 객체에 대한 접근은 모두 메모리를 제어하는 방식이 된다.

        int num = cm.getCloneVariable();

        System.out.println("객체내 변수값 획득: " + num);

        cm.reNum();

        System.out.println("변경 후 사전 획득한 정보 재출력: " + num);

        // 결론: 앞서서도 확인했지만 값에 대해서는 복제가 이루어짐을 확인할 수 있다.
        System.out.println("변경 정보 파악: " + cm.getCloneVariable());
    }


}

