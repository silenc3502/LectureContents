interface LampMethod {
    public void lightOn();
    public void lightOff();
}
class Lamp implements LampMethod {
    @Override
    public void lightOn() {
        System.out.println("Lamp를 킵니다.");
    }
    @Override
    public void lightOff() {
        System.out.println("Lamp를 끕니다.");
    }
}
class StreetLamp implements LampMethod {
    @Override
    public void lightOn() {
        System.out.println("가로등을 킵니다.");
    }
    @Override
    public void lightOff() {
        System.out.println("가로등을 끕니다.");
    }
}
class Led implements LampMethod {
    @Override
    public void lightOn() {
        System.out.println("LED등을 킵니다.");
    }
    @Override
    public void lightOff() {
        System.out.println("LED등을 끕니다.");
    }
}
public class interfacetest2 {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        lamp.lightOn();
        lamp.lightOff();
        StreetLamp streetLamp = new StreetLamp();
        streetLamp.lightOn();
        streetLamp.lightOff();
        Led led = new Led();
        led.lightOn();
        led.lightOff();
    }
}