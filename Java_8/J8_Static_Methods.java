package Java_8;

interface A{
    static void sayHello(){
        System.out.println("Hello A static");
    }
    default void PrintHello(){
        System.out.println("Hello A non-Static");
    }
}
public class J8_Static_Methods implements A{
    void sayHello(){
        System.out.println("Hello main");
    }
    public static void main(String[] args) {
        J8_Static_Methods s = new J8_Static_Methods();

        /// We can call non-static methods by object name
        s.PrintHello();

        /// We can call static methods only by interface's name
        A.sayHello();

        /// we can create exactly same method(static methods inside interface) outside the interface
        s.sayHello();
    }
}
