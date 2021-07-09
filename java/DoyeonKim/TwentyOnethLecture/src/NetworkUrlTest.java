import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUrlTest {
    //Malform이라는 것이 악성 코드에 해당해서
    //이상한 URL로 링크를 태워서 공격을 할 수 있기 때문에 그것에 대한 방서 조치라 보면 됨
    //
    public static void main(String[] args) throws MalformedURLException {
        URL myURL = new URL("https://github.com/ms109420/LectureContents");

        System.out.println("Protocol = " + myURL.getProtocol());
        System.out.println("authority = " + myURL.getAuthority());
        System.out.println("host = " + myURL.getHost());
        System.out.println("Port = " + myURL.getPort());
        System.out.println("Path = " + myURL.getPath());
        System.out.println("Query = " + myURL.getQuery());
        System.out.println("File = " + myURL.getFile());
        System.out.println("Ref = " + myURL.getRef());
    }
}
