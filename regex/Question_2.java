package regex;
/*------------------------------Create Regular Expression that accept 10 digits numbers only------------------------------*/
import java.util.regex.Pattern;

public class Question_2 {
    public static void main(String[] args) {
        String regex = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher("123").matches());
        System.out.println(pattern.matcher("1").matches());
        System.out.println(pattern.matcher("9861238881").matches());
        System.out.println(pattern.matcher("iu9").matches());
    }
}