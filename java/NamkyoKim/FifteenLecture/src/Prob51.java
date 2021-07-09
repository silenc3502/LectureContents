//ArrayList를 활용하여 상점을 만들어보자!
//구매, 판매, 목록보기
//소지금, 물건의 구매가 등을 지정해서 적정 버튼을 누르면 처리되도록 만들어봅시다!
//초기에 판매리스트에는 아무것도 없다.
//초기에는 상점 주인이 파는 구매 리스트만 존재한다.
//물건을 구매하면 구매한 물품이 판매 리스트에 보인다.
//목록 보기는 단순히 현재 소지한 물건 리스트만 보여준다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 1. 상점 주인이 파는 구매목록리스트 리스트
// 2. 구매하게되면 구매한물품이 내가 되 팔수 있는 리스트에 보임
// 3. 목복보기는 내가 소지한 물건리스트
class Shop{
    ArrayList<String> saleslist;
    ArrayList<String> myList;
    String[] listArr;
    Scanner sc;
    Boolean isTrue;

    public Shop(){
        // 생성자 값 초기화
        saleslist = new ArrayList<String>(Arrays.asList("모자","티","선글라스","신발","청바지","가방"));
        myList = new ArrayList<String>();
        sc = new Scanner(System.in);
        isTrue = true;

    }
    public void PurchasList(){
        // 구매목록 출력 이건 구매후 목록이라 구매를 하고나서 내 소지품이라고도 할 수 있는매서드

    }
    public void SaleList(){
        // 판매목록 / 판매후 목록
        System.out.println(saleslist);
        while (isTrue){
            System.out.print("상품을 고르세요!! : ");
           saleslist.remove(sc.nextLine());
           // remove해서 remove한것을 구매자의 소지품myList에넣고싶었는데 계속 에러뜨고 막힌다 ..

            System.out.println(saleslist);
            System.out.println(myList);

        }

    }

    @Override
    public String toString() {
        return "Shop{" +
                "saleslist=" + saleslist +
                '}';
    }

    public void ShopStart (){
        // 중재하려고 만듬
    }
}

public class Prob51 {
    public static void main(String[] args) {

        Shop sh = new Shop();

        System.out.println(sh);
        sh.SaleList();
    }
}
