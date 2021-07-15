import java.net.MalformedURLException;
import java.net.URL;

public class a_NetworkUrlTest {
    // Malform 이라는 것이 악성 코드에 해당해서
    // 이상한 URL로 링크를 태워서 공격을 할 수 있기 때문에 그것에 대한 방어 조치라 보면 됨
    // www.daum.net, https://www.daum.net
    // URL을 반드시 후자로 줘야 합니다.
    // 이유는 www.daum.net으로 하면 위와 같이 악성코드 공격이 가능함.
    public static void main(String[] args) throws MalformedURLException {
        URL myURL = new URL("https://www.orcale.com/java/techonologies/");


        // Protocol: Https(웹 애플리케이션 전용 프로토콜입니다.)
        System.out.println("Protocol = " + myURL.getProtocol());
        System.out.println("authority = " + myURL.getAuthority());
        System.out.println("hos = " + myURL.getHost());
        System.out.println("port = " + myURL.getPort());
        System.out.println("path = " + myURL.getPath());
        System.out.println("query = " + myURL.getQuery());
        System.out.println("filename = " + myURL.getFile());
        System.out.println("ref = " + myURL.getRef());
    }
}
