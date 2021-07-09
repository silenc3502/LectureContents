import java.util.ArrayList;
import java.util.Arrays;

// 숙제는 강사님이 풀이해주신코드를 완성하기 !
// 일단 출력하는 구문부터 다듬고
// 할수있다면 중복까지 제거 해보자 !

class Roulette {
    ArrayList<String> nameLists; // ArrayList<String> <여기엔 데이터 타입!> 선언
    String[] tmpArr; // 이름을 받을 String 배열 선언
    int[] tmpIdx; // 이름배열의 길이로 만들고 인덱스에 랜덤값을부여하려는 목적의 변수?
    int[] success; // 3개의 번호를 뽑아서 담을 배열 선언?

    int nameLength; // 이름배열의 길이를 담을 변수 선언
    Boolean isRedundant; // 참과 거짓을 나타내는 변수선언

    public Roulette (String[] names) { // 생성자에 인자에 이름값들을 담을 매개변수선언
        nameLength = names.length; // 변수에 이름배열길이 초기화
        isRedundant = true; // Boolean타입을  true로 초기화

        nameLists = new ArrayList<String>(); // ArrayList의 객체 생성?
        tmpArr = new String[nameLength]; // tmpArr에 이름값들의 배열를 생성
        tmpIdx = new int[nameLength]; // tmpIdx에 이름(인덱스값)배열의 길이만큼 배열을 생성

        success = new int[3]; // 위에서 선언 한 success에 3개의 인덱스방을 초기화?생성?

        int i = 0;

        for (String name : names) { // forEach로 생성자에서 인자로 받은값들을 순서대로 하나하나씩 넣어줌
              tmpArr[i++] = name; // 무슨 기능인지 이해안됨 ..
        }
    }

    private Boolean checkDuplicate (int idx) { // 중복값을 체크하는 매서드 매개변수를 두었음
        for (int i = 0; i < idx; i++) {         // 다른 매서드에서 인자로 값을 주고 중복값을 체크하는 기능?
           if (tmpIdx[i] == tmpIdx[idx]) {

                return true;
            }
        }

        return false;
    }

    public void shuffle () {
        int i = 0;

        isRedundant = true;

        do {
            tmpIdx[i] = (int)(Math.random() * nameLength); // 사람들의 값들을 랜덤으로 만드는 구문

            if (checkDuplicate(i)) { // 체크하기위해 if로 조건을 걸고 조건이 성립한다면 continue로 다음진행
                continue;
            }

            i++; // i를 1씩 증가

            if (i == nameLength) { // 증가하다가 이름의 길이와 같다면 isRedundant = false로
                isRedundant = false; // do~while문 끝
            }
        } while (isRedundant);
    }

    public void checkSuccess () { // 3명의 당첨자를 뽑기위한 매서드
        int i = 0;

        isRedundant = true;

        do {
            success[i] = (int)(Math.random() * nameLength); // 이제 랜덤으로 3명을 뽑을 랜덤값 추출구문

            if (checkDuplicate(i)) { // 중복의 체크 구문 근데 중복이 나고있는데 ..가끔씩.. 원인을 찾질못하겠다 ..
                continue;           // 위에 매서드와 같은원리 조건이 성립한다면 다음 진행
            }

            i++;        // i 값 1씩 증가

            if (i == 3) { // 0번 인덱스 1번인덱스 2번인덱스 값만 뽑을 것이기 떄문에 i가 3과 같다면 false로
                isRedundant = false; // do~while문 끝
            }
        } while (isRedundant);
    }

    public void printSuccessArr () { // 출력하는 구문을 만들어봤음
        for (int i = 0; i < 3; i++) {
            System.out.printf("%d번이 뽑혔습니다 !! 당첨자는 !?! %s 입니다!!! 축하드립니다!!\n",
                    success[i],tmpArr[success[i]]);
            //  이것저것 적어보면서 돌려봤는데 이렇게 출력하는게 아래에 적어놓은 순서로 뽑아서
            // 이런식으로 설정했습니다 그리고 알아보기 쉽게 사람이름에 순서대로 번호를 부여함


        }
    }

    @Override
    public String toString() { // 랜덤으로 돌린 값들을 출력
        return "랜덤으로 사람이름순서를 바꿉니다!!" +
                "바꾼 번호를 나열합니다 !! : \n" + Arrays.toString(tmpIdx);
    }
}

public class Prob48 {
    public static void main(String[] args) {
        String[] names = { // 이름 초기화 이부분도 매서드로 하면 좋을듯 하다 !
                "0.박세진", "1.김창욱", "2.김민규", "3.김중연", "4.문성호",
                "5.강병화", "6.최승현", "7.유종현", "8.한상우", "9.전승리",
                "10.이경환", "11.최준환", "12.김원석", "13.여인준", "14.이태양",
                "15.김윤영", "16.정도영", "17.황정아", "18.임초롱", "19.김남교",
                "20.이주형", "21.김도연", "22.최혜주", "23.김도혜", "24.고재권",
                "25.임익환", "26.안보미", "27.이상훈"
        };

        Roulette r = new Roulette(names); // 생성자에서 인자를 두었기때문에 입력을 names함 이름배열의 입력

        //---------------------------
        // 실질적으로 r.shuffle() 값을 섞어준다는 의미에서 셔플인듯하다 셔플매서드부터 게임시작
        r.shuffle();
        System.out.println(r);          // 순서를 바꿔서 해봤지만 안된다 매서드를 하나하나
        r.checkSuccess();               // 읽어보면서 순서의 의미를 조금은 알았다 ..
        r.printSuccessArr();            // 수업시간에 설명해주실때 집중해서 들어야겠다 .. 아직
                                        // 이 클래스 자체가 돌아가는 흐름만알지 구체적으로는 잘모르겠고
                                        // 중복제거 하는 방법도 한번더 보고 따라해보면서 습득해야겠다 ..
        //---------------------------------
        // 중복 제거를 하려고 노력했지만 실패했습니다 ..
        // 그리구 출력구문을 바꿨는데 강사님이 중복번호안뜨게 체크하는 매서드를 만들었는데
        // 가끔 중복이 발생하네요 ㅠ 찾아봐도 보이질 않네요 제가 출력을 잘못해서 그런건지 ..
    }
}