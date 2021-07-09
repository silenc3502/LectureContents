import java.util.ArrayList;

class Student {
    String name = "";
    int ban;
    int no;

    public Student(String name, int ban, int no) {
        this.name = name;
        this.ban = ban;
        this.no = no;
    }
}
public class Iterator {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("자바", 1, 1));
        list.add(new Student("김자바", 1, 1));
        list.add(new Student("이자바", 1, 1));

        java.util.Iterator<Student> it = list.iterator();
//        java.util.Iterator<Student> it = list.iterator();

        while (it.hasNext()) {
            Student s = (Student) it.next(); //제네릭스 사용 X 형변환 필요
//            System.out.println(it.next().name);
            System.out.println(s.name);
        }

    }
}
