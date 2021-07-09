import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class student{
int age;
    String name;

    public student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
public class HashMapTest {
    public static void main(String[] args) {
        Map<Integer, student> st = new HashMap<Integer,student>();

        st.put(1, new student(24,"김도그"));
        st.put(4, new student(23,"최피자"));
        st.put(6, new student(54,"한버거"));
        System.out.println(st);

        Set keyset = st.keySet();
        System.out.println(keyset);

        Set entry = st.entrySet();
        System.out.println(entry);





         }




    }

