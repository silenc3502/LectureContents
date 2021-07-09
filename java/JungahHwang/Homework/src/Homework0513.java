public class Homework0513 {
    public static void main(String[] args) {
        // 23. 2개의 범위를 가지는 난수 2개를 중복없이 제어하기
        // 하나는 5 ~ 10, 다른 하나는 7 ~ 10

        final int Bin = 1;
        int bit = 0, bit2 = 0;
        int rand1, rand2;

        System.out.println("5-10 사이의 랜덤 숫자");

        for (int i = 0; i < 6; i++) {
            rand1 = (int) (Math.random() * 6 + 5);

            while ((bit & (Bin << rand1)) != 0) {
                rand1 = (int) (Math.random() * 6 + 5); }

            System.out.printf("%-3d", rand1);
            bit |= (Bin << rand1); }

        System.out.println();

        System.out.println("7-10 사이의 랜덤 숫자");

        for (int i = 0; i < 4; i++) {
            rand2 = (int) (Math.random() * 4 + 7);

            while ((bit2 & (Bin<< rand2)) != 0) {
                rand2 = (int) (Math.random() * 4 + 7); }

            System.out.printf("%-3d", rand2);
            bit2 |= (Bin << rand2); }







    }
}
