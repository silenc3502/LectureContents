import java.util.Scanner;

class Practice2Test{
    int num;
    String name;

    Practice2Test(){
        num = (int)(Math.random()*100+30);
    }

    public  void tall(){
        System.out.println(name+"의키"+num+"cm");

        for (int i = 1; i <11;i++){
            num += (num * (int) (Math.random() * 55) + 1) / 100;

            System.out.println(i+"년후");
            System.out.println(num+"cm\n-----");
        }
    }




}
public class Practice2 {
    public static void main(String[] args) {
        Practice2Test[]  dd = new Practice2Test[10];
        Scanner sc = new Scanner(System.in);

        for(int z = 0; z<10;z++){
            dd[z] = new Practice2Test();
            System.out.println("악어의 이름을 적어주세요("+z+")/10최대");
            dd[z].name = sc.next();

            dd[z].tall();
        }
    }


}
