// 일단 클래스 생성!
class Salary{
    final float PERCENT = 0.01f;

    String employee;
    int emSalary;
    float increase;



    //생성자 - 값 초기화 하기
    public Salary(String employee){ // 1.리턴타입을 void로 하면 아래 메인에서
        this.employee = employee;
        emSalary = getRandomValue(1101, 2400);
        increase = getRandomValue(20,1);

    }
    // 수업시간에 알려주신내용 활용 코드가 매우 깔끔해짐
    public int getRandomValue(int range, int offset) {
        return (int)(Math.random() * range + offset);
    }


    public void calcEmSalary(){  // 계산
        emSalary = (int)(emSalary + emSalary * increase * PERCENT);
    }
    public void printRandomSalary(){ // 초기랜덤 연봉값 출력구문
        System.out.printf("%s의 초기연봉은 = %d\n",employee,emSalary);
    }
    public void printCalcSalary(){ // 계산후 출력구문
        // 아래처럼 몇퍼센트 올랐는지도 표기하고싶어서 했는데 에러가 뜨네욤
        //System.out.printf("%s의 %d퍼 인상된 연봉은 = %d\n",employee,increase,emSalary);
        System.out.printf("%s의 인상된 연봉은 = %d\n",employee,emSalary);
    }

    public String getEmployee() {
        return employee;
    }

    public int getEmSalary() {
        return emSalary;
    }

}

// 랜덤 연봉 적용을 해보자
// 어떤 회사에 직원이 10명 있다.- ok
// 10명의 이름은 적당히 지어주도록 한다.- ok
// 이들의 시작 연봉은 2400 ~ 3500 으로 랜덤하게 지정한다. - ok
// 또한 연봉 인상률은 1% ~ 20% 사이의 랜덤값을 가지게 한다. - ok
// 10 년후의 각 직원들의 연봉을 출력하도록 프로그래밍해보자!
// 또한 연별로 평균 연봉값을 계산해보도록 한다.


public class Prob43Remind {

    public static void main(String[] args) {
        // 직원들의 이름 배열 생성
        String []employeeArr = { "강한별","강떙떙","김아무","이아무"," 박아무",
                                "최아무","최최최","선영","보리","제임스"};
        // 객체생성
        int empLen = employeeArr.length;
      Salary[] sa = new Salary[employeeArr.length];

      for (int i = 0; i < empLen; i++){

          sa[i] = new Salary(employeeArr[i]); // 2.여기에서 에러가 난다 void 지우니까 없어졌는데 왜그런거지??

          sa[i].printRandomSalary(); // 아래에서 출력하니 뭔가 초기값에 인상된 값이 나오는듯해서
                                     // 초기값자체를 출력 해주는 print매서드 새로 만들어 여기서 출력
      }

        for (int i = 0; i < 10; i++){ // 여기서 10은 10년을 의미하고

             float sum = 0;         // 평균을 구하기 위해 sum 값 초기화 시켜주기

            for(int j = 0; j < empLen; j++){ // 여기서 empLen은 직원 10명을 의미합니다

                sa[j].calcEmSalary(); // 계산 매소드를 불러와서 배열 인덱스에 담고

                sum += sa[j].getEmSalary(); // 계산된 값을 get로 불러와서 sum =  sum + sa[j].getEmSalary()
                                            // 전체 연봉의 합산
                sa[j].printCalcSalary();    // 따로 계산 print매서드를 만들어서 불러옴

            }

            // 1년 마다의 평균 연봉
            System.out.println("***** 1년의 평균 연봉 = " + (sum / 10.0f) + " ********");
        }
        // 아직은 풀기 힘들거같고 강사님이 풀이를 해주셨기때문에 잘 따라하고 이게 뭐고 이게뭔지 이해하면서 코드작성했다
        // 코드를 따라하는대도 에러가 나서 원인을 찾아내느라 혼자 계속 들여다 보기도 했습니다 .
        // 여기서 궁금점은 여기 메인에 for문이 세번 나타나는데 이것들도 애초에 매서드화해서 딱 값만 꺼내올순없는건가요?
        // 가능할거같기도하고 메인에는 딱 메서드 불러오는 코드만있으면 깔끔할거같아서 여쭤봅니다!

    }
}
