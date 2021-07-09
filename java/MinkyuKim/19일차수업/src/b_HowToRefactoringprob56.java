import java.util.HashMap;
import java.util.Map;
public class b_HowToRefactoringprob56 {
    public static Boolean checkDuplicate (
            int patternIdx, int randNum, int[][] randCheckArr) {

        if (randCheckArr[patternIdx][randNum] > 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
        Map<String, Integer>[] preparedMap = new HashMap[3];

        String[] pattern = {"spear", "sword", "arrow"};

        for (int i = 0; i < 3; i++) {
            preparedMap[i] = new HashMap<String, Integer>();

            for (int j = 0; j < 10; j++) {
                preparedMap[i].put(pattern[i] + j, j);
            }
        }

        for (int i = 0; i < 3; i++) {
            map.put(pattern[i], preparedMap[i]);
        }
        System.out.println(map);
        System.out.println("카드를 분배합니다.");

        // * 같은 패턴에서 같은 숫자가 나오면 안됨!
        // 그렇기 때문에 중복된 숫자가 존재하는지 여부를 체크하는 배열이 필요하다.
        // 현재 값은 0 ~ 9까지 나오므르 배열의 인덱스를 활용하기에 아주 좋다.
        int[][] dupNumArrCheck = new int[3][10];
        String sculpture;
        int sculptureIdx;
        int randNum;

        for (int i = 0; i < 4; i++) {
            do {
                // 중복되는 숫자를 체킹하는 코드가 필요합니다:
                // 56번에서는 중복체킹하는것을 추가로 처리하여
                // 57번 문제를 풀어보도록 합시다!
                sculptureIdx = (int) (Math.random() * 3);
                randNum = (int) (Math.random() * 10);
            } while (checkDuplicate(sculptureIdx, randNum, dupNumArrCheck));

            sculpture = pattern[sculptureIdx];

            // 앞서서 루프에서 체크되지 않았으니 이제 값을 증가시켜
            // 여기엔 값이 할당 되었음을 표기한다
            // (randNum에 해당하는 숫자가 이미 활용 되어 중복이니 더 이상 찾지마!)
            dupNumArrCheck[sculptureIdx][randNum]++;

            System.out.println("사용자에게 분배된 카드는 = " + sculpture +
                    " 문양의 " + randNum + " 카드입니다!");
        }
    }
}