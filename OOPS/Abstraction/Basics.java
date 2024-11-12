package OOPS.Abstraction;

public class Basics {
    // Hide irrelevant information
    static abstract class Animal{
        Animal(){
            System.out.println("Animal created.");
        }
        abstract void walk();
        public void eats(){
            System.out.println("Animal Eats.");
        }
    }
    static class Cow extends Animal{
        Cow(){
            System.out.println("Cow created.");
        }
        @Override
        void walk() {
            System.out.println("Walks on 4 legs.");
        }
    }
    public static void main(String[] args) {
        Animal c = new Cow();
        c.walk();
        c.eats();
    }
}