   
// #Main
 
public class Main {
    public static void main(String[]args) {
        System.out.println(sum(5, 4, 3, 2, 1));
    }
    static int sum (int...a){
        int ans = 0;
        for (int j : a) ans += j;   

        return ans;
    }
}
