import java.util.HashSet;
import java.util.Set;

public class IntegerHashSetTest {
    public static void main(String[] args) {
        Set<Integer> test = new HashSet<Integer>();

        test.add(3);
        test.add(7);
        test.add(1);

        System.out.println(test);
    }
}
