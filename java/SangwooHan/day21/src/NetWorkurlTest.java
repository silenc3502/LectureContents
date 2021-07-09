import java.net.MalformedURLException;
import java.net.URL;

public class NetWorkurlTest {
    public static void main(String[] args) throws MalformedURLException {
        URL myURL = new URL("https://www.eprivacy.go.kr/mainList.do");

        System.out.println("protocol = "+myURL.getProtocol());
        System.out.println("authority = "+myURL.getAuthority());
        System.out.println("host="+myURL.getHost());
        System.out.println("port="+myURL.getPort());
        System.out.println("path ="+ myURL.getPath());
        System.out.println("equery="+myURL.getQuery());

    }
}
