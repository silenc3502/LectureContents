public class ThirteenthLecture {

    /*
    // 필드(Field)의 관하여
    // 필드의 변수를 지정할 떄는  [접근제한다] [예약어] 자료형 변수명 [=초기값];
    //       [protected, public, private, default] [static or final]
    // 클래스 변수 ( 모든 객체가 공통적으로 속성을 가질때 사용을 하고 생성할때 메모리 영역에 같이 생성이 되기 때문에
    // 꼭 필요한 공통적인 속서을 가진 변수에 사용을 해야함)
        public static int var1;   // 예)

    // 멤버변수 (인스턴스 변수)
    // 각각의 객체 즉 인스턴스 마다 개별적인 속성을 가져야할 때 멤버변수(인스턴스)를 사용하게 된다.
        public int var2;   //예)
        private int var3;
        int var4;   // 접근제한자 생략시 default 접근 제한자가 된다.

    // 생성자
        public FieldExam() {
            String var5 = "생성자 지역변수";   // 지역변수
            System.out.println(var5); //사용할때 메소드 안에서 사용
        }
    {
        // 초기화 블럭
        String var6 = "초기화블럭 지역변수";  // 지역변수
        System.out.println(var6);

        // 메소드
        public String method() {
            String var7 = "메소드 안의 지역변수";  // 지역변수
            return var7;
    }
    */

    // 클래스 초기화 블럭
    public static String name = "홍길동";
    // 생성자 생성
    public ThirteenthLecture () {
        System.out.println("생성자 영역");
    }
    int age = 19;
    static {
        System.out.println("static block 영역");
        name = "박길동";
    }
    {
        System.out.println(age);
        System.out.println("인스턴스 블럭 1");
        this.age = 22;
        System.out.println(age);
    }
    {
        System.out.println("인스턴스 블럭 2");
    }

    public static void main(String[] args) {
        ThirteenthLecture tl = new ThirteenthLecture();
    }
}

