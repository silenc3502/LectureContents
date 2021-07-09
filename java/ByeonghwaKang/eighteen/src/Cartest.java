class Car {
    private float rpm;
    private float fuel;
    private float pressure;
    private String color;

    public void setRpm (float rpm) {
        this.rpm = rpm;
    }
    public float getRpm() {
        return rpm;
    }
    public float getFuel() {
        return fuel;
    }
    public void setFuel(float fuel) {
        this.fuel = fuel;
    }
    public float getPressure() {
        return pressure;
    }
    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}

// 기존에 잘 만들어진 정보에 새로운 내용을 추가하여 작업하고자 한다.
// 내용을 변경하는것보다는 새로운 클래스에 상속을 활용하여 작업하는 것을 권장한다.
// (일전에 잠깐 언급했던 SRP 규칙 때문에 그렇다)
class SportsCar extends Car {
    private Boolean booster;

    public Boolean getBooster() {
        return booster;
    }
    public void setBooster(Boolean booster) {
        this.booster = booster;
    }

    @Override
    public String toString() {
        // super의 경우엔 상속해준 상속자를 직접 호출한다.
        return "SportsCar{" +
                "rpm=" + getRpm() +
                ", fuel=" + getFuel() +
                ", pressure=" + getPressure() +
                ", color=" + getColor() +
                ", booster=" + booster +
                '}';
    }
}

public class CarTest {
    public static void main(String[] args) {
        SportsCar sc = new SportsCar();

        sc.setRpm(100);
        sc.setFuel(2.5f);
        sc.setPressure(1.0f);
        sc.setColor("Dark Gray");
        sc.setBooster(false);

        System.out.println(sc);
    }
}