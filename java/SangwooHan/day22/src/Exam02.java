
class Calutlator{
    int left, right;

    public Calutlator(int left, int right) {
        this.left = left;
        this.right =right;
    }



    public void sum(){
        System.out.println(this.left+this.right);
    }

    public void avg(){
        System.out.println((this.left+this.right)/2);
    }

}
     class Substraction extends Calutlator{
         public void avg(){
             System.out.println((this.left+this.right)/8);
         }
    public Substraction(int left, int right){
        super(left,right);

    }

    }
// 상속 복습..
public class Exam02 {
    public static void main(String[] args) {
        Substraction es = new Substraction(10,20);
        es.avg();

    }

}
