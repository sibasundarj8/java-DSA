package OOPS.Inheritance;

//  Multi Level
public class Multi_Level {
    static class Shape{
        public void area(){
            System.out.println("Display Area..");
        }
    }
    static class Triangle extends Shape{
        public void area1(int l, int h){
            System.out.println((float) (l*h)/2);
        }
    }
    static class EquilateralTriangle extends Triangle{
        public void area2(int l, int h){
            float ans = (float) l*h / 2;
            System.out.println("ET : " + ans);
        }
    }

    public static void main(String[] args) {
        EquilateralTriangle eq = new EquilateralTriangle();
        eq.area();              // Shape class
        eq.area1(5,4);    // Triangle class
        eq.area2(4,3);    // EquilateralTriangle class
    }
}