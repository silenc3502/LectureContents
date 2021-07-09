package bupum;

public class A implements X {
    private X x;

    public void setX(X x) {
        this.x = x;
    }

    public A(){

    }

    public void print() {
        int total = x.total();

        System.out.println("total is ="+total);
    }

    @Override
    public int total() {
        return 0;
    }
}
