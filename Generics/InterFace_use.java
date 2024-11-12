package Generics;
/*  T :  Type
 *  E :  Elements (used in collection)
 *  K :  Key (used in map)
 *  V :  Value (used in map)
 *  N :  Number
 */
interface Container<T> {
    void add (T item);
    void get();
}

class StudentContainer<T> implements Container<T>{
    private T item;

    @Override
    public void add(T item) {
        this.item = item;
    }

    @Override
    public void get() {
        System.out.println(item);
    }
}

public class InterFace_use {
    public static void main(String[] args) {
        Container<String> s1 = new StudentContainer<>();
        s1.add("Sanjulata");
        s1.get();
    }
}