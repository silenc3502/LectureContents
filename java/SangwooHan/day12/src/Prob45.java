import javax.swing.*;
import java.util.Scanner;

class KazinoGame {
        int ComMoney;
        int userMoney;
        int ComDice;
        int userDice;
        int SecondComDice;
        int SeconduserDice;
        int CalcComDice;
        int CalcuserDice;
        int batMoney;
        Scanner sc;
         KazinoGame(){
             System.out.println("컴퓨터와 유저에게 1000만원씩 충전하겠습니다.");
             ComMoney = 1000;
             userMoney = 1000;
             ComDice = randomDice();
             userDice = randomDice();
         }
         public void COmbatting(){
             System.out.println("배팅할금액을 적어주세요 단,유저가배팅금액을적었다면,컴퓨터도 동일하게 적용합니다.");
             System.out.println("최소단위 100만원");
             sc = new Scanner(System.in);
              batMoney = sc.nextInt();
             ComMoney = ComMoney - batMoney;
             userMoney = userMoney  -batMoney;
             System.out.println("컴잔여금액"+ComMoney+"유저잔여금액"+userMoney);
         }
         public int ComDicerogic(){

             System.out.println("컴의 첫번쨰주사위="+ComDice);
            CalcComDice += ComDice;

             if(ComDice %2 ==0){

                 SecondComDice  = randomDice();
                 System.out.println("컴의 두번째주사위="+SecondComDice);
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
                            if(SecondComDice ==6){
                                CalcComDice =  (ComDice+SecondComDice)*2;

                            }
                                if(SecondComDice == 2){
                                    CalcComDice = ComDice+SecondComDice;
                                }
                                    if(SecondComDice ==5){
                                        CalcComDice = ComDice+SecondComDice;
                                    }



             }
                                return CalcComDice;
         }

         public int userDicerogic(){
             System.out.println(" 첫번쨰 주사위는 = "+userDice);
                CalcuserDice = userDice;
             if(userDice %2 ==0){

                 System.out.println("오 짝수가 나왔군요. 다시한번 돌려보겟습니다.");
                 SeconduserDice  = randomDice();
                 System.out.println("당신의 두번쨰 주사위="+SeconduserDice);
                 if(SeconduserDice == 1){
                     System.out.println("1이군요..3을더하겠습니다.");
                     CalcuserDice = userDice+SeconduserDice+3;
                 }
                     if(SeconduserDice ==3){
                         CalcComDice =CalcComDice -2;
                         CalcuserDice = userDice+SeconduserDice;
                         System.out.println("상대방의 주사위눈-2");

                     }
                         if(SeconduserDice == 4){
                             System.out.println("4군요 이런 저주를걸겠습니다 system: 당신의주사위합은0이되었습니다.");
                             CalcuserDice = 0;
                         }
                             if(SeconduserDice ==6){
                                 System.out.println("6이군요 당신눈은  *2를 하겟습니다");
                                 CalcuserDice = (userDice+SeconduserDice)*2;

                             }
                                 if(SeconduserDice == 2){
                                     System.out.println("2군요 2를더하겟습니다");
                                     CalcuserDice = userDice+SeconduserDice;
                                 }
                                     if(SeconduserDice ==5){
                                         System.out.println("5군요 5를더하겠습니다.");
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
        System.out.println("최종주사위값"+"컴:"+getCalcComDice()+" "+"유저:"+getCalcuserDice());
             if(CalcuserDice> CalcComDice){
                 System.out.println("유저가 이겼습니다 배팅값을 가져갑니다.");
                 userMoney = userMoney+batMoney*2;
                 System.out.println("컴잔여금액"+ComMoney+"유저잔여금액"+userMoney);
             }
             else if(CalcComDice>CalcuserDice){
                 System.out.println("컴퓨터가 이겼습니다 배팅값을 가져갑니다.");
                 ComMoney = ComMoney+batMoney*2;
                 System.out.println("컴잔여금액"+ComMoney+"유저잔여금액"+userMoney);
             }
    }



            public int randomDice(){
            return (int)(Math.random()*6+1);
    }
        }
public class Prob45 {
    public static void main(String[] args) {

        KazinoGame GG = new  KazinoGame();
        GG.COmbatting();
        GG.userDicerogic();
        GG.ComDicerogic();
        GG.deposit();
    }
}
