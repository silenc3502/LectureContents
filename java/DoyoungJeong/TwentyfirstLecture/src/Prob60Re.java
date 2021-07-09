import java.util.*;

class Words {

    private String[] words;
    private Set<String> wordsBox;
    private Map<String, Integer> wordsMap;


    public Words() {
        words = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        wordsBox = new HashSet<String>();
        wordsMap = new HashMap<String, Integer>();

        for(String element : words) {
            wordsBox.add(element);
            wordsMap.put(element, 0);
        }
    }

    public void checkDupli(int time) {
        for(int i=0; i<time; i++) {
            int ranNum = (int)(Math.random()*words.length);
            String key = words[ranNum];

            if(wordsBox.contains(key)) {
                int cnt = wordsMap.get(key);
                wordsMap.put(key, ++cnt);
            }
        }

    }
    public Map<String, Integer> getWordsMap() { //반환형이 Map<>이다
        return wordsMap;
    }

}

public class Prob60Re {
    public static void main(String[] args) {
        Words wd = new Words();
        wd.checkDupli(20);
        System.out.println(wd.getWordsMap());

    }
}
