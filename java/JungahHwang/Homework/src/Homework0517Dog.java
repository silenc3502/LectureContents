
import java.util.Scanner;

class Dog{
    String name;
    int age;
    String food;}

public class Homework0517Dog {
    public static void main(String[] args) {
        Dog d = new Dog();
        Scanner scan = new Scanner(System.in);

        System.out.println("강아지의 정보를 입력하세요.");

        System.out.print("강아지의 이름: ");
        d.name = scan.nextLine();

        System.out.print("강아지의 나이: ");
        d.age = scan.nextInt();

        scan.nextLine();

        System.out.print("강아지가 좋아하는 간식: ");
        d.food = scan.nextLine();


        System.out.printf("%s는 %d살이고 %s 간식을 좋아한다", d.name, d.age, d.food);




    }
}
