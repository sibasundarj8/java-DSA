package OOPS;

class Employs{
    final String companyName = "Google";
    String name;
    int id;
    int age;

    // to count the number of Employs.
    // static - used if we want to access through just class name
    private static int count = 0;

    Employs(String n, int id, int age){
        this.name = n;
        this.id = id;
        this.age = age;
        count++;
    }
    public static int getCount() {
        return count;
    }
}
public class O2_Static_Keyword {
    public static void main(String[] args) {
        Employs e1 = new Employs("Siba", 236, 20);
        Employs e2 = new Employs("Omm", 198, 19);
        Employs e3 = new Employs("Sidharth", 238, 22);
        System.out.println(e1.name);
        System.out.println(e2.id);
        System.out.println(e3.companyName);
        System.out.println(e3.age);

        System.out.println("Number of Employs : " + Employs.getCount());
    }
}
