public class Fruits {
//6월15일 시험문제복습!
        String Fruits;
        String FruitName;
        String  FruitColor;
        public Fruits(String Fruits){
            this.Fruits = Fruits;
        }
        public Fruits(String FruitName, String FruitColor) {
            this. FruitName =  FruitName;
            this.FruitColor =FruitColor;
        }

    public Fruits() {

    }

    @Override
    public String toString() {
        return "Fruits{" +
                "Fruits='" + Fruits + '\'' +
                ", FruitName='" + FruitName + '\'' +
                ", FruitColor='" + FruitColor + '\'' +
                '}';
    }
}
