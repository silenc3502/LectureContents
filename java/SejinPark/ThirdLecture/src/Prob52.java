import java.math.BigInteger;

class Daddy {
    BigInteger money;
    String company;

    public Daddy(BigInteger money, String company) {
        this.money = money;
        this.company = company;
    }

    @Override
    public String toString() {
        return "아빠{" +
                "money=" + money +
                ", company='" + company + '\'' +
                '}';
    }
}

class Son extends Daddy {
    String recentInvest;

    public Son(BigInteger money, String company, String recentInvest) {
        super(money, company);
        this.recentInvest = recentInvest;
    }

    @Override
    public String toString() {
        return "이재용{" +
                "money=" + money +
                ", company='" + company + '\'' +
                ", recentInvest='" + recentInvest + '\'' +
                '}';
    }
}

public class Prob52 {
    public static void main(String[] args) {
        BigInteger bigNum = new BigInteger("100000000000000");
        Daddy samsung = new Daddy(bigNum, "삼성그룹");

        Son newSamsung = new Son(bigNum.multiply(BigInteger.TEN),
                "삼성전자", "바이오 사업");

        System.out.println(samsung);
        System.out.println(newSamsung);
    }
}