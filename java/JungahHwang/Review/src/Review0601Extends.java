class A{
    int a = 10;
    void b (){
        System.out.println("A");
    }
}

class AA extends A{
    int a = 20;

    void b(){
        System.out.println("AA");
    }
    void c(){
        System.out.println("C");
    }
}

public class Review0601Extends {
    public static void main(String[] args) {
        A a = new A();
        a.b();
        System.out.println("A a: "+a.a);

        AA aa = new AA();
        aa.b();
        aa.c();
        System.out.println("AA aa: "+aa.a);

        A a1 = new AA();
        a1.b();
        System.out.println("A a1: "+a1.a);
        // new한 대상이 AA이기 때문에 메서드는 AA를 봄
        // 접근 데이터는 데이터타입 A를 따라감



    }
}
