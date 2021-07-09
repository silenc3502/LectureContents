import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Store {
    ArrayList<String> stuffLists;
    String[] stuffs;
    String[] sellArr;
    String buyStuff;
    int stuffLength;
    Scanner scan;


    public Store() {
        stuffs = new String[]{"chair", "table", "laptop", "bass guitar", "desktop",
                "shoes", "glasses", "book"};

        stuffLength = stuffs.length;

        stuffLists = new ArrayList<String>();
        sellArr = new String[stuffLength];

        sellArr = stuffs;
        scan = new Scanner(System.in);

    }

    public void selling() {
        System.out.println(" 다음은 쇼핑 리스트 입니다. 맘껏 둘러보십쇼! ");
        for (int i = 0; i < stuffLength; i++) {
            System.out.printf("%d.%s", (i + 1), stuffs[i]);
        }
    }
    public void buying() {
        System.out.println("무엇을 구매 하시겠습니까 ?");
        String buyStuff = scan.nextLine();
        System.out.printf("구매 하신 물건은 %s 입니다.\n", buyStuff[stuffs1]);

    }
}



//ArrayList를 활용하여 상점을 만들어보자!
//구매, 판매, 목록보기
//소지금, 물건의 구매가 등을 지정해서 적정 버튼을 누르면 처리되도록 만들어봅시다!
//초기에 판매리스트에는 아무것도 없다.
//초기에는 상점 주인이 파는 구매 리스트만 존재한다.
//물건을 구매하면 구매한 물품이 판매 리스트에 보인다.
//목록 보기는 단순히 현재 소지한 물건 리스트만 보여준다.

// 구매자 와 판매자의 물건이 있다. 배열을 통해 만들자
// 상점 주인의 판매 리스트 보여줌
// 판매 리스트를 보고 사고 싶은 물건을 입력함
// 물건을 구매하면 판매 리스트에서 해당 값이 지워지고 구매 목록에는 해당 물품이 보이게 됨
// 나중에 최종 구매 목록에서 내가 산 물품들을 확인 할수 있음.

public class Prob51 {
    public static void main(String[] args) {

        Store st = new Store();



    }
}
