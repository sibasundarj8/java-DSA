package OOPS;
class Chain{
    Chain(){
        this(4);
        System.out.println("It is default Constructor..");
    }
    Chain(int x){
        System.out.println(x);
    }

    // Calling default
    Chain(int x,int y){
        this();
        System.out.println(x*y);
    }
}
public class O3_Constructor_Chain {
    public static void main(String[] args) {
        Chain c = new Chain(10,10);
    }
}