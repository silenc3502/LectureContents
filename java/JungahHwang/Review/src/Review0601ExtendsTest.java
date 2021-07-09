class Vehicle {
    private float rpm;
    private float fuel;
    private float pressure;
    private String color;

    public Vehicle(float rpm, float fuel, float pressure, String color) {
        this.rpm = rpm;
        this.fuel = fuel;
        this.pressure = pressure;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "rpm=" + rpm +
                ", fuel=" + fuel +
                ", pressure=" + pressure +
                ", color='" + color + '\'' +
                '}';
    }
}

class Airplane extends Vehicle {
    private float aileron;
    private float pitch;
    private float rudder;

    public Airplane(float rpm, float fuel, float pressure, String color,
                    float aileron, float pitch, float rudder) {
        // super()는 무엇이 되었든 상속자인 부모를 호출한다.
        // super()만 적혀 있으니 생성자를 호출하게 된다.
        super(rpm, fuel, pressure, color);

        this.aileron = aileron;
        this.pitch = pitch;
        this.rudder = rudder;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                // super.toString()은 부모 클래스의 toString()을 호출한 것이다.
                "super.Vehicle()=" + super.toString() +
                ", aileron=" + aileron +
                ", pitch=" + pitch +
                ", rudder=" + rudder +
                '}';
    }
}

public class Review0601ExtendsTest {
    public static void main(String[] args) {
        Vehicle v = new Vehicle(200, 1.2f, 1.0f, "Red");

        System.out.println(v);

        Airplane a = new Airplane(
                1000, 112.5f, 12.3f, "White",
                77.3f, 0.02f, 33.9f);

        System.out.println(a);
    }
}