import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Tv {
}

class Audio {

}
public class Practice {
    public static void main(String[] args) {
        ArrayList<Tv> list = new ArrayList<Tv>();
        list.add(new Tv());
//        list.add(new Audio());
        Tv t =  list.get(0);
//        Tv t = (Tv) list.get(0);
            //예전에는 Object라 형변환 필요했는데 이제는 일치하기 때문에 불필요

    }
}
