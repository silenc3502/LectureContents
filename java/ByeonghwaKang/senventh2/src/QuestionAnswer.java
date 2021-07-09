
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
            // ArrayList는 값을 제거하고 자체적으로 알아서 인덱스를 조정함
            //itemList.remove(solditem-1);
            //pricePcs.remove(solditem-1);
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

public class QuestionAnswer {
    public static void main(String[] args) {
        store gg = new store();
        gg.go();


    }
}