import java.util.*;

public class IntegerHashSetTest {
    public static void main(String[] args) {
        Set<Integer> test = new HashSet<Integer>();

        test.add(3);
        test.add(7);
        test.add(1);
        List testList = new ArrayList(test);

        Collections.sort(testList);

        System.out.println(test);
    }
}