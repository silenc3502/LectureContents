import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
class insectshop{
    ArrayList<String> Names;
    Scanner sc;
    ArrayList<String> hands;
    ArrayList<Integer>Price;
    int myMoney;

    insectshop(String[] arr,Integer[] arr2){
       Names =new ArrayList<String>(Arrays.asList(arr));
       hands = new ArrayList<String>();
       Price = new ArrayList<>(Arrays.asList(arr2));
       myMoney =50000;
        System.out.println("===========진열장==============");
        System.out.println(Names);
        System.out.println("==============================");
       sc =new Scanner(System.in);
    }



    public void deal(){
        System.out.println("무엇을 사시겠습니까?");
       String buyinsect =  sc.nextLine();

       Names.remove(buyinsect);
       hands.add(buyinsect);
        System.out.println("현재 진열장"+Names);
        System.out.println("현재 내 수중에있는 곤충"+hands);
    }
    public void Calcmoney(){

       // Price.remove(내가뽑은 곤충가격)
    }




    public void shopping(){
        for(int i = 0 ; i <5; i++){


        deal();
        }



    }
}
public class Shop {
    public static void main(String[] args) {
        String[] names = {"왕사슴벌레[20000]","넓적사슴벌레[10000]","애사슴벌레[5000]","톱사슴벌레[7000]","홍다리사슴벌레[15000]"};
        Integer[] price = {20000,10000,5000,7000,15000,};
        insectshop gg = new insectshop(names,price);
        gg.shopping();


    }
}
