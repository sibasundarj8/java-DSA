package OOPS.Inheritance;

public class Single_Level {
    //  Single Level
    static class Shape{
        public void area(){
            System.out.println("Display Area..");
        }
    }
    static class Triangle extends Shape{
        public void area(int l, int h){
            System.out.println((float) (l*h)/2);
        }
    }

    public static void main(String[] args) {
        Triangle sh = new Triangle();
        sh.area();          // parent Class area method
        sh.area(5,3); // own area method
    }
}