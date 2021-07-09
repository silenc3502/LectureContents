class Return{
    int[] arr;
    float[] farr;

    public Return(){
        arr = new int[3];
        farr = new float[3];

        for(int i =0; i< arr.length; i++) {
            arr[i] = (int)(Math.random() * 5 + 3);
            farr[i] = (float)(Math.random() * 5 + 3);
        }
    }

    public int[] getArr() { return arr;}
    public float[] getFarr() {return farr;}
}

public class SelfTest {
    public static void main(String[] args) {
        System.out.println("배열리턴");

        Return re = new Return();

        for(int i = 0; i< 3; i++){
            System.out.printf("%d번째 원소 = %d\n", i, re.getArr()[i]);
        }

        System.out.println(re.getArr()[2]);
        System.out.println(re.getFarr()[2]);

    }
}
