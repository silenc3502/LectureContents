class  Person{
    String Name;

    public String getName() {
        return Name;
    }
}
//6월15일 시험문제
public class Exam2 {
    public static void main(String[] args) {

        Person[] pArr = new Person[3];

        for(int i =0; i<=pArr.length-1; i++){
            System.out.println(pArr[i].getName());
        }
    }
}
