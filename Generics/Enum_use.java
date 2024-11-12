package Generics;

enum Operations{
    ADD,SUBTRACT,MULTIPLY,DIVIDE;

    public <T extends Number> int apply(T a, T b){
        return switch (this) {
            case ADD -> a.intValue() + b.intValue();
            case SUBTRACT -> a.intValue() - b.intValue();
            case MULTIPLY -> a.intValue() * b.intValue();
            case DIVIDE -> a.intValue() / b.intValue();
        };
    }
}
public class Enum_use {
    public static void main(String[] args) {
        double res1 = Operations.MULTIPLY.apply(5,10);
        System.out.println(res1);
    }
}