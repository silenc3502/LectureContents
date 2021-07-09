// 객체 지향 언어
// 1. 클래스
// 2. 추상화
class People {


    String head;
    String heart;
    String eye;
    String nose;
    String mouth;
    String name;
    char gender;
    double height;

    // 생각한다.
    public void think() {
        System.out.println("생각한다.");
    }

    // 달린다.
    public void run() {
        System.out.println("달린다.");
    }

    // 잔다.   // 이런 기능이 있을 수 있음.
    public void sleep() {
        System.out.println("잔다.");
    }

}
class ParkingManagement{
    // 차량 번호
    String carNum;
    // 입차 일시
    String inTime;
    // 출차 일시
    String outTime;
    // 주차 시간
    String parkingTime;
    // 주차 요금
    int parkingFee;
    // 할인 내역
    int discouts;
    // 차량 구분(일반/등록)
    String carType;
    // 차량 사진
    String carPicture;
    // 지불 방법(현금/카드)
    String paymentType;

    // 주차요금 정산
    public void parkingPay(String parkingTime, int discouts){
        System.out.println("주차요금정산 메소드");
    }
}

public class NinethLecture {
    public static void main(String[] args) {





    }
}
