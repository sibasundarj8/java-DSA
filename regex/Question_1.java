package regex;
/*--------------------------Create Regular Expression that accept alphanumeric characters only.--------------------------*/
import java.util.regex.Pattern;

public class Question_1 {
    public static void main(String[] args) {
        String regex = "[A-Za-z0-9]+";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher("aac123abx").matches());
        System.out.println(pattern.matcher("123abx321").matches());
        System.out.println(pattern.matcher("aac").matches());
        System.out.println(pattern.matcher("123").matches());
    }
}