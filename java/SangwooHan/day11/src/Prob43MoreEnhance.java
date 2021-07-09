class SalaryTest2 {
    final float PERCENT = 0.01f;

    String name;
    int salary;
//-----------------------------------------------------
    public SalaryTest2 (String name) {
        this.name = name;
        salary = (int)(Math.random() * 1101 + 2400);
    }
    //---------------------------------------------------

    public void calcRandomSalary (int year) {
        float incRate;

        for (int i = 0; i < year; i++) {
            incRate = (int)(Math.random() * 20 + 1);
            // 원가 + 증액분
            salary = (int)(salary + salary * incRate * PERCENT);
            // System.out.printf("%s의 %d년차 연봉은 = %d이며 올해 인상률 = %f\n", name, i + 1, salary, incRate);
        }
    }
    //--------------------------------------------------------------------------------------------------------

    public void calcRandomSalary () {
        float incRate = (int)(Math.random() * 20 + 1);

        salary = (int)(salary + salary * incRate * PERCENT);
    }
    //------------------------------------------------------------------------
    public void printRandomSalary () {
        System.out.printf("%s의 현재 연봉은 = %d\n", name, salary);
    }
    //---------------------------------------------------------------

    public int getSalary() {
        return salary;
    }
    //---------------------------------------------------------------
}

public class Prob43MoreEnhance {
    public static void main(String[] args) {
        String[] nameArr = {
                "강한별", "강한빛", "강경수", "임종수", "백종수",
                "최빛나", "최창수", "박창수", "김창수", "김명수"
        };
        // 현재 nameArr 의 배열 방에 강한별 ... ~ 김명수까지 10명이 각각 한방에 들어있다.

        int nameLen = nameArr.length;
        // 정수 nameLen 은 nameArr의길이만큼이니
        // nameLen은 정수 10이다.
        SalaryTest2[] st = new SalaryTest2[nameLen];
        // SalaryTest2 클래스 배열을 선언한다. 10개만큼
        // 이렇게 선언한다면, SalaryTest는  10개의 평행세계가 존재하게될것이다.

        for (int i = 0; i < nameLen; i++) {
            st[i] = new SalaryTest2(nameArr[i]);
        }
        // 포문을 돌려서 ,평행세계에 10개에 각각 nameArr의 이름을 하나씩뿌린다.



        for (int i = 0; i < nameLen; i++) {

            float sum = 0;


            for (int j = 0; j < nameLen; j++) {

                st[j].calcRandomSalary(); //  인상된연봉 로직돌리고.
                sum += st[j].getSalary();//  게터로 연봉 가져와서 sum에다가 계속저장시키고,
                st[j].printRandomSalary();// 출력로직을 달아준다.
            }

            System.out.println("올해 평균 연봉 = " + (sum / 10.f));
            // 1년치 연봉이 다출력되면, 직원들 연봉을 다더한 값sum에 10을 나눈다
            // 그러면  평균이 나온다.
        }


    }
}