package OOPS.Polymorphism;


public class Basics {
    // Polymorphism -> many forms
    public static void main(String[] args) {
        Students s1 = new Students();
        s1.name = "Siba";
        s1.age = 20;

        s1.printInfo(s1.name);

        s1.printInfo(s1.age);

        s1.printInfo(s1.name, s1.age);
    }
    static class Students{
        String name;
        int age;

        void printInfo(String name){
            System.out.println("name : " + name);
        }

        void printInfo(int age){
            System.out.println("age : " + age);
        }

        void printInfo(String name, int age){
            System.out.println("name : " + name + "\nage : " + age);
        }
    }
}