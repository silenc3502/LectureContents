import java.util.ArrayList;
import java.util.Arrays;

class Roulette {
    ArrayList<String> nameLists;
    String[] tmpArr;
    int[] tmpIdx;

    int[] success;

    int nameLength;
    Boolean isRedundant;

    public Roulette (String[] names) {
        nameLength = names.length;//스트링의 길이=숫자28
        isRedundant = true;

        nameLists = new ArrayList<String>(); //리스트
        tmpArr = new String[nameLength]; //tmpArr=names스트링
        tmpIdx = new int[nameLength]; //tmpIdx=0~27까지의 숫자

        success = new int[3];

        int i = 0;

        for (String name : names) {
            tmpArr[i++] = name;
        }
    }

    private Boolean checkDuplicate (int idx) {    //사람이름을 무작위로 출력시, 중복없이 해주는 메소드checkDuplicate
        for (int i = 0; i < idx; i++) {
            if (tmpIdx[i] == tmpIdx[idx]) {
                return true;
            }
        }

        return false;
    }
    private Boolean checkDuplicate2 (int idx) {   //당첨자3명을 무작위로 출력시, 중복없이 해주는 메소드checkDuplicate2
        for (int i = 0; i < idx; i++) {           //중복없이 해주는 두 메소드를 하나로 하고싶었으나, 시간이 부족해 못했습니다.
            if (success[i] == success[idx]) {     //변수이름을 tmpIdx에서 success로 변경함.
                return true;
            }
        }

        return false;
    }

    public void shuffle () {
        int i = 0;

        isRedundant = true;

        do {
            tmpIdx[i] = (int)(Math.random() * nameLength);


            if (checkDuplicate(i)) {
                continue;
            }

            i++;

            if (i == nameLength) {
                isRedundant = false;
            }
        } while (isRedundant);
    }

    public void checkSuccess () {
        int i = 0;
        isRedundant = true;

        do {
            success[i] = (int)(Math.random() * nameLength);

            if (checkDuplicate2(i)) {
                continue;
            }
            i++;
            if (i == 3) {
                isRedundant = false;
            }
        } while (isRedundant);
    }
    public void printSuccessArr () {

        for (int i = 0; i < 3; i++) {
            System.out.printf("success[%d] = %d, 당첨자{%s} 축하합니다!\n", i, success[i],tmpArr[success[i]]);
                    //출력시, tmpArr[success[i]]을 추가하여 숫자뿐아니라 사람이름이 나오도록 했습니다.
        }
    }


    @Override
    public String toString() {
        return "Roulette{" +
                "tmpIdx=" + Arrays.toString(tmpIdx) +
                "}";
    }
}

public class Prob48 {
    public static void main(String[] args) {
        String[] names = {
                "박세진", "김창욱", "김민규", "김중연", "문성호",
                "강병화", "최승현", "유종현", "한상우", "전승리",
                "이경환", "최준환", "김원석", "여인준", "이태양",
                "김윤영", "정도영", "황정아", "임초롱", "김남교",
                "이주형", "김도연", "최혜주", "김도혜", "고재권",
                "임익환", "안보미", "이상훈"
        };

        Roulette r = new Roulette(names);

        r.shuffle();

        System.out.println(r);

        r.checkSuccess();
        r.printSuccessArr();

    }
}