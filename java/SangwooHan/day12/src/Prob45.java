import javax.swing.*;
import java.util.Scanner;


class KazinoGame {

        int ComMoney = 1000;
        int userMoney = 1000; ;
        int ComDice;
        int userDice;
        int SecondComDice;
        int SeconduserDice;
        int CalcComDice;
        int CalcuserDice;
        int batMoney;
        Scanner sc;

         KazinoGame(){

             System.out.println("System: [컴퓨터]와 [유저]에게 [1000]만원씩 충전하겠습니다.");

             ComDice = randomDice();
             userDice = randomDice();
         }
        public void role(){
            System.out.println("=====================게임 설명============================");
            System.out.println("주사위는 2개가있지만, 첫번쨰주사위를돌릴때만, 2번쨰주사위를돌리수있다.");
            System.out.println("2번쨰 주사위의 효능은 다음과같다 [1]= [내자신]+3,[3]=상대방-2,[4]=내자신을 0으로만듬 [6]=내자신모든합X2");
            System.out.println("자 게임을 시작하겠다 권투를빈다.");
        }


         public void COmbatting(){
             System.out.println("[배팅]할금액을 적어주세요 단,유저가[배팅]금액을적었다면,컴퓨터도 [동일]하게 적용합니다.");
             System.out.println("최소단위 [100]만원");
             sc = new Scanner(System.in);
              batMoney = sc.nextInt();
             ComMoney = ComMoney - batMoney;
             userMoney = userMoney  -batMoney;
             System.out.println("[컴]잔여금액"+ComMoney+"만원"+"[유저]잔여금액"+userMoney+"만원");

    }
         public int ComDicerogic(){

             System.out.println("컴의첫번쨰주사위="+ComDice);
            CalcComDice += ComDice;

             if(ComDice %2 ==0){

                 SecondComDice  = randomDice();
                 System.out.println("컴의두번째주사위="+SecondComDice);
                 if(SecondComDice == 1){
                     CalcComDice = ComDice + SecondComDice+3;
                 }
                     if(SecondComDice ==3){
                         CalcuserDice = CalcuserDice -2;
                         CalcComDice = ComDice+SecondComDice;
                     }
                        if(SecondComDice == 4){
                            CalcComDice = 0;
                        }
    }
                            if(SecondComDice ==6){
                                CalcComDice =  (ComDice+SecondComDice)*2;

                            }
                                if(SecondComDice == 2){
                                    CalcComDice = ComDice+SecondComDice;
                                }
                                    if(SecondComDice ==5){
                                        CalcComDice = ComDice+SecondComDice;
                                    }




                                return CalcComDice;
         }

         public int userDicerogic(){
             System.out.println("user의첫번쨰 주사위="+userDice);
                CalcuserDice = userDice;
             if(userDice %2 ==0){

                 System.out.println("[짝수발생] 2번쨰주사위굴러갑니다.");
                 SeconduserDice  = randomDice();
                 System.out.println("user의 두번쨰 주사위="+SeconduserDice);
                 if(SeconduserDice == 1){
                     System.out.println("[1]발동+3");
                     CalcuserDice = userDice+SeconduserDice+3;
                 }
                     if(SeconduserDice ==3){
                         CalcComDice =CalcComDice -2;
                         CalcuserDice = userDice+SeconduserDice;
                         System.out.println("[3발동]상대방의 주사위눈-2");

                     }
                         if(SeconduserDice == 4){
                             System.out.println("[4]저주발생 system: 당신의주사위합은[0]이되었습니다.");
                             CalcuserDice = 0;
                         }
                             if(SeconduserDice ==6){
                                 System.out.println("[6]user눈을X2를 하겟습니다");
                                 CalcuserDice = (userDice+SeconduserDice)*2;

                             }
                                 if(SeconduserDice == 2){

                                     CalcuserDice = userDice+SeconduserDice;
                                 }
                                     if(SeconduserDice ==5){

                                         CalcuserDice = userDice+SeconduserDice;
                                     }



             }
            return CalcuserDice;
         }



    public int getCalcComDice() {

        System.out.println("컴퓨터의 주사위값은 ="+CalcComDice);return CalcComDice;
    }
    public int getCalcuserDice() {
        System.out.println("당신의 주사위값은 ="+CalcuserDice);return CalcuserDice;
    }

    public void deposit(){
        System.out.println("[최종]주사위값"+"[컴]:"+getCalcComDice()+" "+"[유저]:"+getCalcuserDice());
             if(CalcuserDice> CalcComDice){
                 System.out.println("유저가 이겼습니다 배팅값을 가져갑니다.");
                 userMoney = userMoney+batMoney*2;
                 System.out.println("[컴]잔여금액["+ComMoney+"]"+"[유저]잔여금액["+userMoney+"]");
             }
             else if(CalcComDice>CalcuserDice){
                 System.out.println("[컴퓨터]가 이겼습니다 [배팅]값을 가져갑니다.");
                 ComMoney = ComMoney+batMoney*2;
                 System.out.println("[컴]잔여금액["+ComMoney+"]"+" [유저]잔여금액["+userMoney+"]");
             }
    }
        public boolean endGAME(){
             if(ComMoney ==0){
                 return  false;
             }
             else if(userMoney ==0){
                 return false;

             }
             else{
                 return true;
             }
        }





            public int randomDice(){
            return (int)(Math.random()*6+1);
    }

        }

public class Prob45 {
    public static void main(String[] args) {
          KazinoGame GG = new KazinoGame();
          GG.role();

      while (GG.endGAME()) {
          GG.COmbatting();
          System.out.println(" ");
          GG.userDicerogic();
          GG.ComDicerogic();
          GG.deposit();
      }

    }
}
