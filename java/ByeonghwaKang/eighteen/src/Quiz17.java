import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

class LeeKeonHee {
    int age;
    String doa;



    public LeeKeonHee(int age, String doa) {
        this.age = age;
        this.doa = doa;

    }

    @Override
    public String toString() {
        return "LeeKeonHee{" +
                "age=" + age +
                ", doa='" + doa + '\'' +
                '}';
    }
}



class LeeJaeYong extends LeeKeonHee {
    String company;

    public LeeJaeYong(int age, String doa, String company) {
        super(age, doa);
        this.company = company;
    }





    @Override
    public String toString() {
        return "LeeJaeYong{" +
                "age=" + age +
                ", doa='" + doa + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}

public class Quiz17 {
    public static void main(String[] args) {

        LeeKeonHee lee1 = new LeeKeonHee(90 , "death");
        System.out.println(lee1);
        LeeJaeYong lee2 = new LeeJaeYong(40, "alive", "samsung");
        System.out.println(lee2);
    }

}
