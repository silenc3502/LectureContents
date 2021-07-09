public class Generics {
    public static void main(String[] args) {
//        장점: 객체의 타입 안정성을 높이고 형변환의 번거로움을 줄여줌
//        컴파일 시 타입을 체크해 주는 기능(compile-time type check)
//
//        예) ArrayList<Tv> tvList = new ArrayList<Tv>();
//        기존에는 object타입이 저장이됬지만 제한을 둔다.
//                tvList.add(new Tv());
//        tvList.add(new Audio()); erro발생 Tv왜 다른 타입 불가
//
//        따라서 눈에보이는 classCastException error. runtime error를 피할수있기때문에 활용된다.
//
//        예외의 상속계층도
//        Exception - IOE , ClassNotFoundE
//        RuntimeException
//                -ArithmeticException - ClassCastException(이부분에서 데이터타입을 줘서 없앤다.) - NullPointerException - IndexOufOfBoundsException
//        여기서 최대한 컴파일 에러가 날수있도록 하는게 좋다.

//        Box<String> b = new Box<String>();
//        <>지네릭타입 호출 일치 생성객체와
//        다형성 처럼 되는것이아니라(조상 자손관계) 일치해야한다.
//
//                List<Tv> list = new ArrayList<Tv>();
//        List<> list = new LinkedList<Tv>();
//        이건됨 다형성
//
//        매개변수의 다형성도 성립.
//                또 다형성을 적용해서 Product의 자손 클래스 가능
//        ArrayList<Product> list = new ArrayList<Product>();
//        list.add(nwe Product());
//        list.add(nwe Tv());
//        list.add(nwe Audio());
//
//        Product p = list.get(0);
//        Tv t = (Tv)list.get(1); //Product기때문에
    }
}
