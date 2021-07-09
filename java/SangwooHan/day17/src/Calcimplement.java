public class Calcimplement implements  Calc{

    @Override
    public int add(int a, int b) {
        int Calcadd = a+b;
        return Calcadd;
    }

    @Override
    public int Minus(int a, int b) {
        int CalcM = a-b;
        return CalcM;
    }
}
