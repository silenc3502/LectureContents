import com.sun.jdi.PathSearchingVirtualMachine;

interface Light {
    public void lightOn();
    public void lightOff();
}

class Lamp {
    Light lamp = new Light() {
        @Override
        public void lightOn() {

        }

        @Override
        public void lightOff() {

        }
    };
}
class Led {
    Light led = new Light() {
        @Override
        public void lightOn() {

        }

        @Override
        public void lightOff() {

        }
    };
}


}
}





public class interfa {
    public static void main(String[] args) {

        Lamp lamp = new Lamp();

        lamp.lamp = 







    }

}