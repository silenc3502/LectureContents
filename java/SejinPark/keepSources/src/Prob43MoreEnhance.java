class SalaryTest2 {
    final float PERCENT = 0.01f;

    String name;
    int salary;

    public SalaryTest2 (String name) {      //생성자에는 초기화만
        this.name = name;
        salary = (int)(Math.random() * 1101 + 2400);
    }

    public void calcRandomSalary () {       //어떤 계산을 하는 메소드
        float incRate = (int)(Math.random() * 20 + 1);

        salary = (int)(salary + salary * incRate * PERCENT);
    }
    public void printRandomSalary () {
        System.out.printf("%s의 현재 연봉은 = %d\n", name, salary);
    }

    public int getSalary() {
        return salary;
    }   //출력은 getter만을 통해서 한다고 기억
}

public class Prob43MoreEnhance {
    public static void main(String[] args) {
        String[] nameArr = {
                "강한별", "강한빛", "강경수", "임종수", "백종수",
                "최빛나", "최창수", "박창수", "김창수", "김명수"
        };

        int nameLen = nameArr.length;
        SalaryTest2[] st = new SalaryTest2[nameLen];

        for (int i = 0; i < nameLen; i++) {
            st[i] = new SalaryTest2(nameArr[i]);
        }

        // 10년치 처리를 하려면 또 한 번 루프로 감싸야함
        for (int i = 0; i < 10; i++) {

            float sum = 0;

            // 현재 이건 10명분에 대한 1년치 처리만했음
            for (int j = 0; j < 10; j++) {
                // st[i].calcRandomSalary();
                // sum += st[i].getSalary();
                // st[i].printRandomSalary();
                st[j].calcRandomSalary();
                sum += st[j].getSalary();
                st[j].printRandomSalary();
            }

            System.out.println("올해 평균 연봉 = " + (sum / 10.f));

        }
    }
}