package Java_8;

interface LE {
    void sayHello();
}

interface AC {
    void sayHello();
    void printName();
}

public class J8_Lambda_vs_Anonymous_Inner_Class {
    public static void main(String[] args) {

        // lambda (always in Functional Interface)
        LE le = () -> System.out.println("I am lambda expression");

        // anonymous inner class
        AC ac = new AC() {
            @Override
            public void sayHello() {
                System.out.println("I am anonymous inner class");
            }
            @Override
            public void printName() {
                System.out.println("Hello World");
            }
        };

        le.sayHello();
        ac.sayHello();
        ac.printName();
    }
}
