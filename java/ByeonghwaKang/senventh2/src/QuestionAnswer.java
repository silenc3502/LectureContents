
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