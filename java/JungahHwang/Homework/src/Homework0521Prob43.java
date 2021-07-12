/* 43. 어떤 회사에 직원이 10명 있다.
       이들의 시작 연봉은 2400 ~ 3500 으로 랜덤값, 또한 연봉 인상률은 1% ~ 20% 사이의 랜덤값
       10 년후의 각 직원들의 연봉을 출력, 또한 연별로 평균 연봉값을 계산 */

class Company {

    int salary;
    float increase;
    int yearSalary[] = new int[10];


    public Company() {
        randSalary();
        randIncrease();
    }

    public void incSalary(){

        yearSalary[0] = salary;
        System.out.printf("1년차 연봉: %d\n", salary);

        for (int i = 1; i < yearSalary.length; i++){
            yearSalary[i] = (int)(salary * increase);
            salary = yearSalary[i];
            randIncrease();
            System.out.printf("%d년차 연봉: %d\n", (i+1),yearSalary[i]); }

        System.out.println();

    }


    public int randSalary() {
        salary = (int) (Math.random() * 1100 + 2400);
        return salary;}

    public float randIncrease(){
        int dec;
        dec = (int) (Math.random() * 20 + 101);
        increase = dec * 0.01f;
        return increase; }


    public int getSalary() { return salary; }
    public int[] getYearSalary() { return yearSalary; }
}


public class Homework0521Prob43 {
  public static void main(String[] args) {

      String name[] = {"A","B","C","D","E","F","G","H","I","J"};
      Company c[] = new Company[name.length];


      for (int i = 0; i < name.length; i++){
          c[i] = new Company();
          System.out.printf("%s의 10년 동안의 연봉 \n",name[i]);
          c[i].incSalary();
      }


      // 선생님.. 연별로 연봉 평균 구하는거는 고민해봤지만 풀지 못했어요...ㅠㅠㅠㅠㅠㅠㅠ









    }
}
