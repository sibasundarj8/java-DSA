package Generics;

interface Printable{
    void print();
}
class MyNumber extends Number implements Printable{
    private final int value;
    MyNumber(int value) {
        this.value = value;
    }

    @Override
    public int intValue() {
        return this.value;
    }

    @Override
    public long longValue() {
        return this.value;
    }

    @Override
    public float floatValue() {
        return this.value;
    }

    @Override
    public double doubleValue() {
        return this.value;
    }

    @Override
    public void print() {
        System.out.println(this.value);
    }
}
class Bux<T extends Number & Printable>{
    private final T item;
    Bux(T item){
        this.item = item;
    }
    public void display(){
        item.print();
    }
    public T getItem(){
        return this.item;
    }
}
public class Bounded_parameter {
    public static void main(String[] args) {
        MyNumber m = new MyNumber(69);
        Bux<MyNumber> b = new Bux<>(m);
        b.display();            //  69
        b.getItem().print();    //  69
    }
}