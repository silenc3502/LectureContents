public class TenthLectureSub {
    public static void main(String[] args) {
        //Pet p = new Pet();
        Pet p1 = new Pet("시베리안 허스키","미미", 1);
        Pet p2 = new Pet("푸들", "푸니", 2);
        Pet p3 = new Pet("진돗개","장군",3);

        System.out.println("펫 종류: " + p1.getPetType() + ", 펫 이름: " + p1.getPetName() + ", 펫 나이: " + p1.getPetAge());
        System.out.println("펫 종류: " + p2.getPetType() + ", 펫 이름: " + p2.getPetName() + ", 펫 나이: " + p2.getPetAge());
        System.out.println("펫 종류: " + p3.getPetType() + ", 펫 이름: " + p3.getPetName() + ", 펫 나이: " + p3.getPetAge());
    }
}
