class Cat{
    String name;
    int age;
    String size;

    String getName(){
        return name;
    }
    void setName(String name){
        this.name = name;
    }
    int getAge(){
        return age;
    }
    void setAge(int age){
        this.age = age;
    }
    String getSize(){
        return size;
    }
    void setSize(String size){
        this.size = size;
    }
}

public class Homework0517Cat {
    public static void main(String[] args) {

        Cat c = new Cat();

        c.setName("나비");
        c.setAge(15);
        c.setSize("S");

        System.out.printf("%s의 나이는 %d살이고 옷사이즈는 %s이다.", c.getName(), c.getAge(), c.getSize());




    }
}
