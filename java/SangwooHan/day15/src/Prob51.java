import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class store{
    Scanner sc;
    String[] item;
    ArrayList<String> myitmes;

    ArrayList<String> buyList;
    ArrayList<Integer> pricePcs;
    Integer itemPrice[] ;
    Integer itemNum[];

    ArrayList<String> itemList;
    int solditem;


    int Money ;

    store(){
         item = new String[] {"1.창 [500]원","2.방패[450]원","3.검[300]원","4.투구[470]원","5.포션[35]원"};
         itemPrice = new Integer[] {500,450,300,470,35};
         itemNum = new Integer[]{1,2,3,4,5};
        itemList =  new ArrayList<String>(Arrays.asList(item));
        pricePcs = new ArrayList<Integer>(Arrays.asList(itemPrice));
        buyList = new ArrayList<>();
        myitmes = new ArrayList<>();
        Money = 1000;

    }



    public void storelist(){
        System.out.println("상점리스트.");
        for(int i= 0; i<itemList.toArray().length;i++){
            System.out.println(itemList.get(i));
        }
    }

    public void buytheitem(){
        sc = new Scanner(System.in);
        System.out.println("물품을 고르세요");
        solditem = sc.nextInt();
    }
    public void addbuyList(){
        buyList.add(itemList.get(solditem-1));
        System.out.println("내 인벤토리"+buyList);
    }
    public void CalcMoney(){
        Money = Money -(pricePcs.get(solditem-1));
        if(Money <= 0){
            System.out.println("돈이 부족합니다 다른거골라주세요");
        }
        else if (Money>0){
            System.out.println("현재 잔액="+Money);

        }
    }



   public void go(){
        do{
            storelist();
            buytheitem();
            if(Money >=pricePcs.get(solditem-1)){
                addbuyList();
            }
            CalcMoney();
        }while (end());
    }

    public  void keepshopping(){
            boolean gogo = true;



    }
 public  boolean end (){
        if(Money == 0){
            return false;
        }
        else {
            return  true;
     }
 }

}

public class Prob51 {
    public static void main(String[] args) {
        store gg = new store();
        gg.go();


    }
}
// 만들었지만 아직 완성되지 못하였다.
/*
상점리스트.
1.창 [500]원
2.방패[450]원
3.검[300]원
4.투구[470]원
5.포션[35]원
물품을 고르세요
1 번 골랐을때..
내 인벤토리[1.창 [500]원]
현재 잔액=500
상점리스트.
2.방패[450]원
3.검[300]원
4.투구[470]원
5.포션[35]원
물품을 고르세요

2번 골랐을때 .. 방패가 안골라지고 계속 검이 골라지면서 인덱스가 하나씩 밀리는 현상이 발견되었다.
==================3 이부분을 고치려면 어디를 고쳐야 할지 질문 드립니다.===============================

내 인벤토리[1.창 [500]원, 3.검[300]원]
현재 잔액=200
상점리스트.
2.방패[450]원
4.투구[470]원
5.포션[35]원
물품을 고르세요

 */































