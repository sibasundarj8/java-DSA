package OOPS.Abstraction;


interface Animal{
    void walk();
    void eats();
}
interface Herbivore{
    void eats();
}

class Dog implements Animal{

    @Override
    public void walk(){
        System.out.println("Dog walks");
    }

    @Override
    public void eats(){
        System.out.println("Dog eats meat");
    }
}
class Cow implements Animal,Herbivore {

    @Override
    public void walk() {
        System.out.println("Cow Walks");
    }

    @Override
    public void eats() {
        System.out.println("Cow Eats Grass");
    }
}
public class Interface {
    public static void main(String[] args) {
        Animal d = new Dog();
        d.walk();           // Animal O -> Dog O      Horse walks
        d.eats();           // Animal O -> Dog O      Horse eats
        Cow c = new Cow();
        c.walk();           // Animal O -> Cow O      Cow Walks
        c.eats();           // Animal O -> Cow O      Cow Eats
    }
}