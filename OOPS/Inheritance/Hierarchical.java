package OOPS.Inheritance;

public class Hierarchical {
    static class Shape{
        public void area(){
            System.out.println("Display Area..");
        }
    }
    static class Triangle extends Shape {
        public void area1(int l, int h){
            System.out.println((float) (l*h)/2);
        }
    }
    static class EquilateralTriangle extends Triangle {
        public void area2(int l, int h){
            float ans = (float) l*h / 2;
            System.out.println("ET : " + ans);
        }
    }
    // extends from Shape class
    static class Circle extends Shape{
        public void area(float r){
            System.out.println(2*(3.141)*r);
        }
    }
    /*
                            Shape class
                                 ↙ ↘
                               ↙     ↘
                             ↙         ↘
                           ↙          Circle
                       Triangle
                           ↓
                EquilateralTriangle
    */
    public static void main(String[] args) {
        EquilateralTriangle eq = new EquilateralTriangle();
        Circle c = new Circle();
        c.area();       // Shape Class
        c.area(4);   // Circle Class

        eq.area();           // Shape class
        eq.area1(4,3); // Triangle class
        eq.area2(5,4); // EquilateralTriangle class
    }
}