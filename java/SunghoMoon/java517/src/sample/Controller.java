package sample;

public class Controller {
    public class NonDuplicateQuestionAnswer {
        public static void main(String[] args) {
            final int BIN = 1;
            int testBit = 0;
            int randNum;

            for (int i = 0; i < 10; i++) {
                randNum = (int)(Math.random() * 10);

                while ((testBit & (BIN << randNum)) != 0) {
                    randNum = (int)(Math.random() * 10);
                }

                System.out.printf("randNum = %d\n", randNum);

                testBit |= (BIN << randNum);
            }
        }
        public class ShiftAdditionalQuestion {
            public static void main(String[] args) {
                System.out.println("쉬프트 연산에 사용되는 int 데이터 타입은 32비트임을 잊지맙시다!");

                int num = 14;
                int shiftBit = 4;

                System.out.printf("%d << %d = %d\n", num, shiftBit, num << shiftBit);

            }


}
