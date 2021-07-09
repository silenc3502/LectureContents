import java.util.ArrayList;
import java.util.Scanner;
class Test{

    ArrayList<String> list= new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        final int one = 1;
        final int trd = one+2;

    Test() {

        System.out.println("상점 구매할 물건을 적어주세요");

    }
    public void addlist(){

        for(int i =0; i<3;i++){

        System.out.printf(" 구매할 물품을 말하세요 구매물건(%d/3)",i+one);
        list.add(sc.nextLine());
    }
    }
    public  void removed(){
        for(int i= 0; i <3; i++){
            System.out.printf("시킬물품중 뺼게있나요?물어보는횟수%d번남음",trd-i);
            list.remove(sc.nextLine());
        }
    }
            public void print(){
                System.out.println(list);
            }
        public void Start(){
        addlist();
        removed();
        print();

        }




}
public class ExamScanner {
    public static void main(String[] args) {
        Test GG= new Test();
        GG.Start();

    }
}
