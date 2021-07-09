import java.util.Scanner;

class dondon {
    int randomMoney;
    String name;

    dondon() {


        randomMoney = (int) (Math.random() * 1100 + 2400);

    }

    public void yunbong() {
        System.out.println(name+"의연봉");

        for (int j = 0; j < 10; j++) {
            randomMoney += (randomMoney * (int) (Math.random() * 20) + 1) / 100;
            System.out.println(randomMoney);


            //연봉 +          연봉* (int)(Math.random()*20)+1;/100
        }







    class Prob441 {
    public  void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        dondon[] st =  new dondon[10];
        // 이건, dondon이라는 클래스를  배열클래스로 만들고, 10개의방을 만들겠다. 라는뜻이다.
        for(int z =0; z <10; z++){
           st[z] = new dondon();

        System.out.println("회사직원 이름을 넣어주세요"+"("+z+"/9"+") ");
           // 방은 10개가 만들어졌다,  포문을통해 그방마다 생성자를 만들었다.
            // 이제 포문에 의하여 박인덱스들이 도출될것이다.

            st[z].name = sc.next();

        }
        for(int q = 0; q <10; q++){

            st[q].yunbong();

        }









    }
}
}