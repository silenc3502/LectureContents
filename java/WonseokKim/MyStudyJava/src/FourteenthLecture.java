public class FourteenthLecture {

    // 생성자 표현식
    // 기본생성자 : [접근제한자] 클래스명(){}
    // 매개변수가 있는 생성자 : [접근제한자 클래스명(매개변수){(this).필드변수 = 매개변수;}

    private int no;
    private String name;

    // 기본 생성자
    public FourteenthLecture (){

    }
    // 매개변수가 있는 생성자
    public FourteenthLecture(int no, String name) {
        this.name = name;
        this.no = no;
    }
}
