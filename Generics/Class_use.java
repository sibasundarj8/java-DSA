package Generics;

/*  T :  Type
 *  E :  Elements (used in collection)
 *  K :  Key (used in map)
 *  V :  Value (used in map)
 *  N :  Number
 */
class Box<T>{
    private T val;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }
}
class Students<S, I>{
    private final S name;
    private final I age;
    Students(S name, I age){
        this.name = name;
        this.age = age;
    }
    S getKey(){
        return this.name;
    }
    I getValue(){
        return this.age;
    }
}
public class Class_use {
    public static void main(String[] args) {

        Box<String>b = new Box<>();
        b.setVal("Sanju");
        System.out.println(b.getVal());

        Students<String, Integer> s1 = new Students<>("Siba",20);
        System.out.println(s1.getKey());
        System.out.println(s1.getValue());
    }
}
