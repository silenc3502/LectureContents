import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Card {

    int num;
    String mo;


    @Override
    public String toString() {
        return "Card{" +
                "num=" + num +
                ", mo='" + mo + '\'' +
                '}';
    }

    public Card (int num, String mo) {
        this.num = num;
        this.mo = mo;


        for (int i = 0; i < 10; i++) {

        }

        int cardnum = new cardnum


    }

}


public class HashMapTest {
    public static void main(String[] args) {
        Map<Integer, Card> st = new HashMap<Integer, Card>();

        st.put(1, new Card(Math(Random)()*9, "spear"));
        st.put(2, new Card(33, "sword"));
        st.put(3, new Card(29, "bow"));

        System.out.println(st);

        st.remove(2);
        System.out.println(st);



        System.out.println(st);

        for (Map.Entry<Integer, Card> s : st.entrySet()) {

            Integer key = s.getKey();
            Card value = s.getValue();
            System.out.println("key = " + key + "value = " + value);




        }




    }

}
