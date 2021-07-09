import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUrlTest {
    public static void main(String[] args) throws MalformedURLException {
        URL myURL = new URL("https://www.oracle.com/kr/java/");

        System.out.println("Protocol = " + myURL.getProtocol());
        System.out.println("authority = " + myURL.getAuthority());
        System.out.println("host = " + myURL.getHost());
        System.out.println("port = " + myURL.getPort());
        System.out.println("path = " + myURL.getPath());
        System.out.println("query = " + myURL.getQuery());
        System.out.println("filename = " + myURL.getFile());
        System.out.println("ref = " + myURL.getRef());
    }


}
