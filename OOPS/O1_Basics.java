package OOPS;


class Students{
    // public - It can be accessed Everywhere.
    public String sec = "D";

    // default - It can be accessed in the same Package.
    String name ;

    // Private - only can be accessed in the same class.
    private int roll;

    // The final key word is used to make variable immortal, It can't be changed.
    final String schoolName = "SSVM";

    // Default Constructor.
    Students(){

    }

    // User defined Constructor.
    Students(String name, int roll){
        this.name = name;
        this.roll = roll;
    }

    // Setter method, used to set private variables.
    void setRoll(int roll){
        this.roll = roll;
    }

    // Getter method, used to get private variables.
    int getRoll(){
        return roll;
    }
}
public class O1_Basics {
    public static void main(String[] args) {

        Students m = new Students("Siba", 236);
        System.out.println(m.name);
        System.out.println(m.getRoll());

        m.setRoll(36);
        System.out.println(m.getRoll());

        Students s2 = new Students();
        // We can only get schoolName, can't modify.
        System.out.println(s2.schoolName);
    }
}