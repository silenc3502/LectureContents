import java.util.Scanner;

public class Prob56 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double radius;
        double CircleArea;

        System.out.print("면적을 입력하세요 : ");
        radius = input.nextInt();

        CircleArea = radius * radius * Math.PI;
        System.out.print(CircleArea);
    }
}
