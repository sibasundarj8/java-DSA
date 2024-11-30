package Java_8;

interface LE {
    void sayHello();
}

interface AC {
    void sayHello(int x);
    void printName();
}

public class J8_Lambda_vs_Anonymous_Inner_Class {
    public static void main(String[] args) {

        // lambda (always in Functional Interface)
        LE le = () -> {
            int x = 236;    // Local variable
            System.out.println("I am lambda expression " + x);
        };

        // anonymous inner class
        AC ac = new AC() {
            int x;    // Instance variable
            @Override
            public void sayHello(int x) {
                this.x = x;
                System.out.println("I am anonymous inner class " + this.x);
            }
            @Override
            public void printName() {
                System.out.println("Hello World");
            }
        };

        le.sayHello();
        ac.sayHello(236);
        ac.printName();
    }
}
