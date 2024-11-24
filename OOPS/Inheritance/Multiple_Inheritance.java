package OOPS.Inheritance;

interface A {
    default void print(){
        System.out.println("Hello A");
    }
}
interface B {
    default void print(){
        System.out.println("Hello B");
    }
}

public class Multiple_Inheritance implements A, B {
    public static void main(String[] args) {
        Multiple_Inheritance m = new Multiple_Inheritance();
        m.print();
    }

    @Override
    public void print() {
        A.super.print();
        B.super.print();
    }
}
