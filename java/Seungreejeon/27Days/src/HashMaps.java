import java.util.HashMap;

public class HashMaps {
    public static void main(String[] args) {
        HashMap<String, Students> map = new HashMap<>();
        map.put("자바왕", new Students("자바왕", 1, 1, 100, 100, 100));

        Students sd = map.get("자바왕"); //형변환 없이 사용가능

        System.out.println(map);

    }
}
class Students {
    String name = "";
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    public Students(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}