class A {
    int a = 10;
    void b (){
        System.out.println("A");
    }
}
// extends 키워드 = 상속
// 상속: 재산을 물려 받는다 >> class의 내용물들을 활용할 수 있다.
class AA extends A{
    int a = 20;
    int b = 10;
    void b(){
        System.out.println("AA");
    }
    void c(){
        System.out.println("C");
    }
}
public class _1st_ExtendsTest {
    public static void main(String[] args) {
        A a = new A();
        a.b();
        System.out.println("A a:" +a.a);

        AA aa = new AA();
        aa.b();
        aa.c();
        System.out.println("AA aa: "+ aa.a);

        A a1 = new AA(); //A class type의 AA객체를 만듬.
        a1.b();
        System.out.println("A a1: " + a1.a);
        a1.a = 1000;
        System.out.println("A a1: " + a1.a);
        System.out.println("AA aa: "+ aa.a);

//        a1.c(); >>
//        System.out.println(a1.b);
        // new의 대상은 AA()
        // 접근 데이터는 데이터타입 A를 참조한다.
        // method는 new된 타입을 따라가고
        // data는 datatype class에   .....
    }
}
