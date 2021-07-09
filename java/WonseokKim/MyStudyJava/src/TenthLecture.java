// 캡슐화란?
// 추상화를 통해 정리된 데이터들과 기능을 하나로 묶어 관리하고
// 가장 중요한 목적인 데이터의 접근제한을 원칙으로 하며,
// 클래스 외부에서 데이터의 직접 접근을 막고(private)
// 대신 데이터를 처리하는 함수들을 클래스 내부에 작성하는 방법

class Pet {
    // 펫의 종류
    private String petType;
    // 펫의 이름
    private String petName;
    // 펫의 나이
    private int petAge;  //(직접 접근하여, 관리할 수 있음)

    // 생성자
    public Pet(){}

    // 매개변수가 있는 생성자
    public Pet(String petType, String petName, int petAge){
        this.petType = petType;
        this.petName = petName;
        this.petAge = petAge;
    }



    // getter
    public String getPetType(){
        return petType;
    }
    public String getPetName(){
        return petName;
    }
    public int getPetAge(){
        return petAge;
    }
    // setter
    public void setPetType(String petType){
        this.petType = petType;
    }
    public void setPetName(String petName){
        this.petName = petName;
    }
    public void setPetAge(int petAge){
        this.petAge = petAge;
    }



}



public class TenthLecture {
    public static void main(String[] args) {

    }
}
