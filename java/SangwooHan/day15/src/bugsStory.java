import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class welcomeShop {
    String[] insectName;
    Integer[] insectPrice;

    ArrayList<String> Names;
    ArrayList<Integer> Prices;
    ArrayList<String> MyinsectList;
    Scanner sc;
    int myMoney;
    int sellectNum;
    boolean leaveShop;

    welcomeShop() {
        System.out.println("안녕하세요 kh 곤충판매숍입니다.");
        myMoney = 200000;
        insectName = new String[]{"사슴벌레[200]","장수풍뎅이[250]" , "사마귀[170]", "대왕지네[340]", "황금콩벌레[130]"};
        insectPrice = new Integer[]{50000,30000,10000,80000,40000};

        Names = new ArrayList<>(Arrays.asList(insectName));
        Prices = new ArrayList<>(Arrays.asList(insectPrice));
        MyinsectList = new ArrayList<>();
    }

    public void insectList() {

        for (int i = 0; i < Names.toArray().length; i++) {
            System.out.printf("(%d)%s", i+1,(Names.get(i)));
        }
    }

    public void buyinsect() {
        sc = new Scanner(System.in);
        System.out.println("구매할 벌레 번호를 입력해주세요.");
        sellectNum = sc.nextInt();
    }
    public void SoldOUt(){
        MyinsectList.add(Names.get(sellectNum - 1));
        System.out.println("내 곤충인벤토리" + MyinsectList);

        }



    public void CalcMyMoney() {
        myMoney = myMoney - (Prices.get(sellectNum - 1));
        if(myMoney <= 0){
            System.out.println("돈이 부족합니다.");
        }else if( myMoney >Prices.get(sellectNum-1)){
            System.out.println("내현재 잔액 ="+myMoney+"만원");
            Names.remove(sellectNum-1);
            Prices.remove(sellectNum-1);

        }


    }

    public void shopOpen() {
       do{

        insectList();
        buyinsect();
        if(myMoney > (Prices.get(sellectNum-1))){
            SoldOUt();
        }
        CalcMyMoney();
        if (myMoney >=0){
              SellectChance();
        }

       }while(GOHOME());

    }
    public void SellectChance(){
       sc = new Scanner(System.in);
        boolean istrue =true;
         leaveShop = true;
        while(istrue){
                System.out.println("계속 쇼핑할까요? Y|N");
       String ANSWer = sc.next();

            if(ANSWer.equals("Y")){
                istrue = false;
            }else if(ANSWer.equals("N")){
                System.out.println("상점을 떠납니다.");
                istrue = false;
                leaveShop = false;
            }
            else{
                System.out.println("Y,S중으로 입력해주세요");
                istrue = true;
            }
        }
    }
    public    boolean GOHOME(){
        if(myMoney<= 0 ||leaveShop == false ){
                            return  false;
        }
        else{
            return true;
        }


  }




}
public class bugsStory {
    public static void main(String[] args) {
        welcomeShop GG = new welcomeShop();
    GG.shopOpen();
    }
}
