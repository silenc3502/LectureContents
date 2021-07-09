import java.net.MalformedURLException;
import java.net.URL;

public class Review0607 {
    // Malform이라는 것이 악성코드에 해당함
    // 이상한 URL로 링크를 태워서 공격을 할 수 있기 때문에 그것에 대한 방어조치임
    // www.daum.net / http://www.daum.net 둘 중 후자로 적어야 함
    // -> 전자로 사용시 악성코드 공격이 가능
    public static void main(String[] args) throws MalformedURLException {
        URL myURL = new URL("https://www.oracle.com/java/technologies/");

        System.out.println("protocol = " + myURL.getProtocol());
        System.out.println("authority = " + myURL.getAuthority());
        System.out.println("host = " + myURL.getHost());
        System.out.println("port = " + myURL.getPort());
        System.out.println("path = " + myURL.getPath());
        System.out.println("query = " + myURL.getQuery());
        System.out.println("filename = " + myURL.getFile());
        System.out.println("ref = " + myURL.getRef());




















    }
}
