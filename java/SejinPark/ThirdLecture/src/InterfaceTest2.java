interface LampMethod {        //인터페이스의 프로그래밍하는데 중요성을 배웠다.
    public void lightOn();    //내 생각에는, 인터페이스의 가장 큰 존재이유는 인터페이스내에
    public void lightOff();   //많이 쓰는 메소드명을 공유할 수 있게 하는것 같다.
}                             //turnon(),tunrOff()같은 메소드명들은 전자기기나 여러가지의 전기제품들에서
                              //가장 필수적인 키고,끄는 기능들을 표시하는 것들인데,
                              //인터페이스 내에 이 메소드들을 써줌으로써 다른 클래스나 다른곳에서도
                              //불편하지 않게 쓸수 있도록 해준다고 생각한다.

class Lamp {
    LampMethod lamp = new LampMethod() {
        @Override
        public void lightOn() {
            System.out.println("Lamp를 킵니다.");
        }

        @Override
        public void lightOff() {
            System.out.println("Lamp를 끕니다.");
        }
    };              //꼭 ;를 써주도록 한다
}

class StreetLamp {
    LampMethod streetLamp = new LampMethod() {
        @Override
        public void lightOn() {
            System.out.println("가로등을 킵니다.");
        }

        @Override
        public void lightOff() {
            System.out.println("가로등을 끕니다.");
        }
    };
}

class Led {
    LampMethod led = new LampMethod() {
        @Override
        public void lightOn() {
            System.out.println("LED등을 킵니다.");
        }

        @Override
        public void lightOff() {
            System.out.println("LED등을 끕니다.");
        }
    };
}

public class InterfaceTest2 {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();

        lamp.lamp.lightOn();
        lamp.lamp.lightOff();

        StreetLamp streetLamp = new StreetLamp();

        streetLamp.streetLamp.lightOn();
        streetLamp.streetLamp.lightOff();

        Led led = new Led();

        led.led.lightOn();
        led.led.lightOff();
    }
}