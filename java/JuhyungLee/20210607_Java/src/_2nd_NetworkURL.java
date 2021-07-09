import java.net.MalformedURLException;
import java.net.URL;
// 이건 java.net에 들어있네
// 지금까지 보통 java.util들에 많이 있었음.
public class _2nd_NetworkURL {
    public static void main(String[] args) throws MalformedURLException {
        //Malform - 악성코드
        //악성코드로 이상한 url로 링크 태워서 공격 하는 것에대한 방어조치
        // www.daum.net / http://www.daum.net
        // url은 반드시 후자로 줘야 됨. 전자의 경우에는 악성코드의 공격이 가능함.
        URL myURL = new URL("http://www.loanconsultant.or.kr/source/index.jsp?t=20191216");

        // Protocol: HTTP(웹 애플리케이션 전용 프로토콜)
        // 여기서 프로토콜만 보면됨 / 나머지들은 그냥 해본 것들.
        System.out.println("Protocol = " + myURL.getProtocol());
        System.out.println("authority = " + myURL.getAuthority());
        System.out.println("host = " + myURL.getHost());
        System.out.println("port = " + myURL.getPort());
        System.out.println("path= " + myURL.getPath());
        System.out.println("query= " + myURL.getQuery());
        System.out.println("filename = " + myURL.getFile());
        System.out.println("ref = " + myURL.getRef());
    }
}
