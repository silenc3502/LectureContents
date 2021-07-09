class SalaryTest{
    final float PERCENT = 0.01f;

    String name;
    int salary;

    public SalaryTest (String name) {
        this.name = name;
        salary = (int)(Math.random() * 1101 + 2400);
    }

    public void calcRandomSalary() {
        float incRate = (int)(Math.random() * 20 + 1);

        salary = (int)(salary +salary * incRate * PERCENT);
    }
    public void printRandomSalary() {
        System.out.printf("%s의 현재 연봉은 = %d\n", name, salary);
    }

    public int getSalary() { return  salary; }

}

public class SelfTest43 {
    public static void main(String[] args) {
        String[] nameArr = {
                "직원 1",  "직원 2",  "직원 3",  "직원 4",  "직원 5",
                "직원 6",  "직원 7",  "직원 8",  "직원 9",  "직원 10",
        };

        int nameLen = nameArr.length;
        SalaryTest[] st = new SalaryTest[nameLen];

        for (int i =0; i< nameLen; i++) {
            st[i] = new SalaryTest(nameArr[i]);
        }

        for (int i=0; i< 10; i++){

            float sum = 0;

            for(int j=0; j< 10; j++) {
                st[j].calcRandomSalary();
                sum += st[j].getSalary();
                st[j].printRandomSalary();
            }

            System.out.println("올해 평균 연봉 =" + (sum / 10.f));
        }

    }
}
