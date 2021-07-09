public class TryCatchPractice  {
    public static void main(String[] args)  {
        try{
            //에러가 발생할 수 있는 코드
            throw new Exception(); //강제 에러 출력
        }catch (Exception e){
            //에러시 수행
            e.printStackTrace(); //오류 출력(방법은 여러가지)
            //throw e; /*최상위 클래스가 아니라면 무조건 던져주자 (최상위 클래스라 각주처리함)*/
        }finally{
            //무조건 수행
        }
    }

}
