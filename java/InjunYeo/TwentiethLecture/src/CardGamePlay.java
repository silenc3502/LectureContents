import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
카드게임을 만들기
숫자 0~9 까지의 카드가 존재한다.
또한 카드별로 문양이 있고 문양의 종류는 3가지이다.
창(separ),검(sword),화살(arrow)이다.
카드는 총30장으로 모두 각각 창,검,활 10장씩 들어가있다.
우선 이상태에서 사용자에게 랜덤하게 4장의 카드를 나눠주도록하자.
게임을 진행시킨다. 컴퓨터와 사용자가 이 카드게임을 진행하도록 만들어보자.
같은 문양의 숫자가 연속되게 3(7,8,9 이런식으로)개 나오는경우 승리한다.

같은 문양의 숫자가 연속되게 3개 나오는 경우(예 9 8 7) > 서로 다른 문양의 같은 숫자
서로 다른 문양의 같은 숫자                           > 서로 다른 문양의 숫자가 연속되게 3개 나옴
서로 다른 문양의 숫자가 연속되게 3개 나옴             > 서로 같은 문양이 3개 나옴

 */


class Card{
    String cardPattern;
    int cardNumber;

    Card(String pattern, int number){

        this.cardPattern = pattern;
        this.cardNumber = number;

    }

}

class Deck{

    String[] patternType;
    int[] cardNumber;
    Card[][] playDecks;

    int patternLength;
    int cardNumberLength;

    Deck(){

        patternType = new String[] {"검","창","활"};
        cardNumber = new int[] {0,1,2,3,4,5,6,7,8,9};

        patternLength = patternType.length;
        cardNumberLength = cardNumber.length;

        playDecks= new Card[patternLength][cardNumberLength];

        for(int i=0;i<patternLength;i++){
            for(int j=0;j<cardNumberLength;j++){

                Card card = new Card(patternType[i],cardNumber[j]);
                playDecks[i][j] = card;

            }
        }
    }


}

class Game{

    final static int DISTRIBUTED_CARD_NUMBER = 4;

    int patternLength;
    int cardLength;

    Deck deck;
    Card[][] playDecks;
    Card[] myCards;
    Card[] computerCards;

    String[] patternDuplicationCheck;
    int[] numberOrderCheck;

    Game(){

        deck = new Deck();
        playDecks = deck.playDecks;

        myCards = new Card[DISTRIBUTED_CARD_NUMBER];
        computerCards = new Card[DISTRIBUTED_CARD_NUMBER];
        patternDuplicationCheck = new String[DISTRIBUTED_CARD_NUMBER];
        numberOrderCheck = new int[DISTRIBUTED_CARD_NUMBER];

        patternLength = deck.patternLength;
        cardLength = deck.cardNumberLength;

    }

    private void distributeCard(Card[] playerCards){

        Card card;
        int distributedPattern;
        int distributedNumber;

        for(int i =0;i<DISTRIBUTED_CARD_NUMBER;i++){
            do{
                distributedPattern = (int)(Math.random()*3);
                distributedNumber = (int)(Math.random()*10);
                card = playDecks[distributedPattern][distributedNumber];

            }while(cardDuplicationCheck(card));
            playDecks[distributedPattern][distributedNumber] = null;
            playerCards[i] = card;
            patternDuplicationCheck[i] = card.cardPattern;
            numberOrderCheck[i] = card.cardNumber;

        }

    }

    //카드 중복 체크 메소드
    private Boolean cardDuplicationCheck(Card checkingCard){
        Card checkedcard= checkingCard;
        if(checkedcard == null){
            return true;
        }
        return false;
    }


    /*
    같은 문양의 숫자가 연속되게 3개 나오는 경우(예 9 8 7) (9) > 서로 다른 문양의 같은 숫자 (8)
    서로 다른 문양의 같은 숫자 (8)                           > 서로 다른 문양의 숫자가 연속되게 3개 나옴 (7)
    서로 다른 문양의 숫자가 연속되게 3개 나옴 (7)            > 서로 같은 문양이 3개 나옴   (6)

    문양의 중복이 2번/3번/4번

    문양 중복2번
    서로 다른문양 같은숫자
    서로 다른 문양의 숫자 연속되게 나옴

    문양중복 3번
    같은문양의 숫자가 연속되게 3개
    서로같은문양이 3개

     */

    private void patternDuplicationCheck(Card[] checkingCards){
        int duplicount=0;
        HashSet<String> dupliPattern = new HashSet<String>();

        for(int i=0;i<checkingCards.length;i++){
            String pattern = checkingCards[i].cardPattern;
            if(!dupliPattern.add(pattern)){
                duplicount+=1;
            }

        }




    }



    //승리 조건 확인 메소드



    public void playGame(){
        distributeCard(myCards);
        distributeCard(computerCards);
        for(int i=0;i<4;i++){
            System.out.println("내카드 :"+myCards[i].cardPattern+myCards[i].cardNumber);
            System.out.println("컴퓨터 카드 :"+computerCards[i].cardPattern+computerCards[i].cardNumber);
        }
    }


}



public class CardGamePlay {
    public static void main(String[] args) {
        Game g1 = new Game();
        g1.playGame();
    }
}
