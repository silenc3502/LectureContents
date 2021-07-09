import java.util.Objects;

public class pp {
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();

        System.out.println(c1.equals(c2));

        System.out.println();
    }
}
class Card extends Object{
    int number;
    String kind;

    @Override
    public int hashCode() {
        return Objects.hash(kind, number);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Card)) {
            return false;
        }
        Card c = (Card) object;
        return this.kind.equals(c.kind) && this.number == c.number;
    }

    @Override
    public String toString() {
        return "kind :" + kind + ", number : " + number;
    }

}
