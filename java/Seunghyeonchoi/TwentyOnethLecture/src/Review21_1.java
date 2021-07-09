import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;



public class Review21_1 {
    public static void main(String[] args) throws MalformedURLException {

        //  [0] [1] [2] [3] [4] [5] [6] [7] [8] [9]
        // -----------------------------------------
        // | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |    [0]
        // -----------------------------------------
        // | 0 | 0 | 0 | 1 | 0 | 0 | 0 | 0 | 0 | 0 |    [1]
        // -----------------------------------------
        // | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |    [2]
        // -----------------------------------------
        // 배열 그림 기억할 것
/*
        for (Map.Entry<Integer, Student> s : st.entrySet()) {
            Integer key = s.getKey();
            Student value = s.getValue();
            System.out.println("key = " + key + ", value = " + value);
        }

        // Entry<키 데이터타입, 밸류 데이터타입> 형식은 지켜주세요.
        for (Map.Entry<String, String> map : strMap.entrySet())

            strMap.entrySet();
*/
        // Map에 값을 전체 출력하기 위해서는 entrySet(), keySet() 메소드를 사용하면 되는데
        // entrySet() 메서드는 key와 value의 값이 모두 필요한 경우 사용하고,
        // keySet() 메서드는 key의 값만 필요한 경우 사용합니다.

        //1. Thread를 활용하는 이유는 성능을 빠르게 만들기 위함이다.
        //2. 비동기 패턴(Asynchronous Pattern)이란 전부 Thread를 기반으로 한다.
        //3. 자바 스크립트 또한 Multi Thread 모델을 자체적으로 지원한다.
        //4. Thread를 사용할 때는 Critical Section 에 대한 방어가 무엇보다도 중요하다(데이터 무결성)
        //5. 또한 스레드는 비동기 처리를 하기 때문에 데이터의 완전한 전송을 보장하지 못할 수도 있다.

        // Malform 이라는것이 악성 코드에 해당해서
        // 이상한 URL로 링크를 태워서 공격을 할 수 있기 때문에 그것에 대한 방어 조치라 보면 됨
        // www.daum.net, http://www.daum.net
        // URL을 반드시 후자로 줘야 합니다.
        // 이유는 www.daum.net 으로 하면 위와 같이 악성코드 공격이 가능함


        // throws MalformedURLException 이건 빨간줄에 마우스 대고 자동추가로 넣자 굳이 왜 외워
        //
        //


        URL myURL = new URL("http://www.loanconsultant.or.kr/source/index.jsp?t=20191216");

        // Protocol: HTTP(웹 애플리케이션 전용 프로토콜입니다)
        System.out.println("Protocol = " + myURL.getProtocol());
        System.out.println("authority = " + myURL.getAuthority());
        System.out.println("host = " + myURL.getHost());
        System.out.println("port = " + myURL.getPort());
        System.out.println("path = " + myURL.getPath());
        System.out.println("query = " + myURL.getQuery());
        System.out.println("filename = " + myURL.getFile());
        System.out.println("ref = " + myURL.getRef());

        String[] sample = {"I", "walk", "the", "line", "Apple", "hit", "me", "Ground", "attack", "you"};

        List<String> list = Arrays.asList(sample);

        // 정렬 법칙(대문자 우선, 그 다음 소문자)
        Collections.sort(list);

        System.out.println(list);

        Integer[] numbers = {1, 2, 3, 100, 77, 2342, 2342354, 345, 12323, 12, 4};

        List<Integer> numList = Arrays.asList(numbers);

        Collections.sort(numList);

        System.out.println(numList);

        Set fruits = new HashSet();

        //알파벳의 아스키 값으로 비교를 하여 정렬을 합니다.


        fruits.add("strawberry");
        fruits.add("watermelon");
        fruits.add("grape");
        fruits.add("orange");
        fruits.add("apple");
        fruits.add("banana");

        List fruitsList = new ArrayList(fruits);

        fruitsList.add("ofcourse");

        Collections.sort(fruitsList);

        System.out.println(fruitsList);


        //거꾸로
        Collections.reverse(fruitsList);
        System.out.println(fruitsList);

        //길이순
        Comparator<String> c = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s2.length(), s1.length()); }
        };

        Collections.sort(fruitsList, c);

        System.out.println(fruitsList);

        // 길이순 정렬 방식을 찾아봤는데
        // compare 결과값이 1, 0, -1이 나오는 건 알겠는데 sort가 이 값을 어떻게 활용해서 길이순으로 정렬하는 건지 궁금합니다


    }
}

