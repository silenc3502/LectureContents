class EmployeeSalary {
    final int MAX = 10;
    int[] randArr;
    float[] frandArr;
    float[] salArr;

    public EmployeeSalary() {           //10명의 연봉을 2400~3500사이 무작위로
        randArr = new int[MAX];
        for(int i=0; i<MAX; i++){
            randArr[i] = (int)(Math.random() * 1101 + 2400);
         }
    }

    void increaseSalary() {            //10년후 연봉을 연봉인상률을 무작위로 해서 출력(사람이름은 1,2,3 등 숫자로)
        frandArr = new float[MAX];
        for(int i=0; i<MAX; i++) {
            frandArr[i] = (float)(Math.random() *0.19 + 0.01 );
            System.out.printf("10년후연봉 %d: %.2f만원\n",i+1,(frandArr[i]+1)*randArr[i]);
        }
    }

}

public class ProbClassArray {
    public static void main(String[] args) {      //문제풀다보니까 정작 클래스배열을 안쓰고 하고있었더라구요.
        EmployeeSalary es = new EmployeeSalary(); //우선 제나름대로 사람들 이름을 1,2,3 등 숫자로 해서 연봉인상률을
            es.increaseSalary();                  //반영한 10년후연봉만 출력하고, 년도별 연봉편균은 구하지 않았습니다
        }                                         //사람별 10년후연봉을 클래스배열로 구현한 풀이를 해주시면 감사하겠습니다

    }

