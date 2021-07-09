import java.util.*;

public class Prob56 {
    public static void main(String[] args) {

        Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
        // key값은 Stirng으로 받고 value가값은 Map<String, Integer> 로 받고있다.
        Map<String, Integer>[] preparedMap = new HashMap[3];
        // value 값에 해당되는 Map<String, Integer> 를 HashMap인스턴스하여 PreparedMap에 넣었다.
        // preparedMap = new HashMap[3]라는건 방을 3개 만들겠다.라는뜻인가?

        String[] pattern = {"spear", "sword", "arrow"};
        // String 타입 배열 pattern안에는 "spear", "sword", "arrow" 가 존재한다.

        //그럼 포문을 돌아보자.
        for (int i = 0; i < 3; i++) {
            // PreparedMap 은 앞서 방을 3개 만들었다. 그중 i번째때 (첫번쨰일경우 0번인덱스째)
             // preparedMap[i] 는 = new HashMap<String, Integer> 를인스턴스화하겠다.

            preparedMap[i] = new HashMap<String, Integer>();

            for (int j = 0; j < 10; j++) {

                preparedMap[i].put(pattern[i] + j, j);
                // PreParedMap[i]번쨰에 put 을하여 key값인 패턴의i번째+j , value 값은 j 가 되겠다.


            }
        }

        for (int i = 0; i < 3; i++) {
            //그리고나서  map안에다가 put을통해 key값 Pattern [i]를 넣어줄것이고,
            // value 값에다가는 ,preparedMap[i]를 집어넣는데, value값인 preparedMap[i]안에도 key값인 pattern+j와 value값인 j가 있다.
            // 즉 형태가  key ,(key ,value) 형태가 되어야 하는데, 이질문은 맨나중에
            // 예를들어 첫번째포문인 i가 0일떄를가정한다면,
            // map 에 put을 하여 key값인 spear를 줄것이고, value값인 preparedMap[0]인 (spear 1,1),(spear 2,2),(spear 3,3),(spear 4,4),
            // (spear 5,5),(spear 6,6),(spear 7,7),(spear 8,8),(spear 9,9)
            //따라서 map의 형태는 spear ,{spear1=1,spear2=2,spear3=3....spear9=9가 될것이다?}
            // 코드에는 spear1 다음 =이라는부호가없는데, =가  갑자기 나타나 내가 놓친게 있는지 확인해보았는데
            //// 즉 형태가  key ,(key ,value) 형태가 되어야 하는데, key =(key =value),로 대체가 되어서 이부분이해가 필요할거같다..


            map.put(pattern[i], preparedMap[i]);

        }

        System.out.println(map);

        System.out.println("카드를 분배합니다.");
        ArrayList<Integer> usercardNum = new ArrayList<>();
        ArrayList<Integer> ComcardNum= new ArrayList<>();
        ArrayList<String> COmCard = new ArrayList<>();
        ArrayList<String> userCard = new ArrayList<>();
        ArrayList<Integer> addNum = new ArrayList<>();
        ArrayList<Integer> checkOverlap = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
                Boolean istrue= true;

            String sculpture = pattern[(int)(Math.random() * 3)];
            int randNum;
            do{

             randNum = (int)(Math.random() * 10);
            addNum.add(randNum);//[2  3 5 5 6]
            if(checkOverlap.indexOf(addNum.get(i)) == -1){

                checkOverlap.add(addNum.get(i));
            }else if(checkOverlap.indexOf(addNum.get(i)) >= 0){
                addNum.remove(0);

                continue;
            }
                  istrue= false;
            }while(istrue);

            System.out.println("사용자에게 분배된 카드는 = " + sculpture +
                    " 문양의 " + randNum + " 카드입니다!");


            userCard.add(sculpture);
            usercardNum.add(randNum);

        }

        System.out.println("컴카드를 분배합니다.");

        ArrayList<Integer> addNum2 = new ArrayList<>();
        ArrayList<Integer> checkOverlap2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Boolean istrue= true;

            String sculpture2 = pattern[(int)(Math.random() * 3)];
            int randNum2;
            do{

                randNum2 = (int)(Math.random() * 10);
                addNum2.add(randNum2);//[2  3 5 5 6]
                if(checkOverlap2.indexOf(addNum2.get(i)) == -1){

                    checkOverlap.add(addNum.get(i));
                }else if(checkOverlap2.indexOf(addNum2.get(i)) >= 0){
                    addNum2.remove(0);

                    continue;
                }
                istrue= false;
            }while(istrue);

            System.out.println("컴퓨터에게 분배된 카드는 = " + sculpture2 +
                    " 문양의 " + randNum2 + " 카드입니다!");
            COmCard.add(sculpture2);
            ComcardNum.add(randNum2);
        }
        System.out.println(userCard);
        System.out.println(usercardNum);
        System.out.println(COmCard);
        System.out.println(ComcardNum);

        Set<String> U = new HashSet<String>();
        Set<String> C = new HashSet<String>();
        System.out.println("유저같은카드");
        for(String userCd: userCard){
            if(!U.add(userCd)){
                System.out.println(userCd);
            }

        }
            System.out.println("중복되지않는카드들"+U);
        System.out.println("컴,같은카드");
        for (String ComCd: COmCard){
            if(!C.add(ComCd)){
                System.out.println(ComCd);
            }
        }
            System.out.println("중복되지않는카드들"+C);

        int UserCardallNum = usercardNum.get(0)+usercardNum.get(1)+usercardNum.get(2)+usercardNum.get(3);
        int ComCardallNum =ComcardNum.get(0)+ComcardNum.get(1)+ComcardNum.get(2)+ComcardNum.get(3);
        

        if(U.size()<C.size()){
            System.out.println("카드중첩효과로 유저가이겼습니다.");
          if(UserCardallNum>ComCardallNum){
              System.out.println("또한 카드의합이 더높기떄문에 판돈 2배를 가져갑니다.");
          }
        }else if(C.size()<U.size()){
            System.out.println("카드중첩효과로 컴퓨터가 이겼습니다.");
            if(ComCardallNum>UserCardallNum){
                System.out.println("또한 카드의합이 더높기때문에 판돈 2배를가져갑니다.");
            }
        }else{
            System.out.println("카드중첩은..무승부 하지만.");
            if(UserCardallNum>ComCardallNum){
                System.out.println("카드합으로 유저가 이겼습니다.");
            }else if(ComCardallNum>UserCardallNum){
                System.out.println("카드합으로 컴퓨터가 이겼습니다.");
            }
        }

// 기존의 문제가 잘안풀려서 제가 변형을 해봤습니다.
        // 1번쨰 이기는조건은 ,카드조합에 같은 카드가 많이 나온 사람이 이긴다.
        // 1번째 조건에서 이길시, 카드4장번호의 합을 대조해봤을때, 1번째 이기는사람이 카드번호까지 이기면 판돈을 X2배로 가져간다
       // 2번째 조건 서로 카드조합이 무승부일떄 카드4장번호의합을 대조해보았을때 이긴사람이 판돈을 가져간다.







    }
}









