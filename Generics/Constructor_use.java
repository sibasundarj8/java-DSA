package Generics;

class Fruits <T>{
    private final T value;
    public Fruits(T value){
        this.value = value;
    }
    public void getValue(){
        System.out.println(this.value);
    }
}
public class Constructor_use {
    public static void main(String[] args) {
        Fruits<String> f1 = new Fruits <>("Apple");
        f1.getValue();
    }
}