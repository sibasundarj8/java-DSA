package regex;
/*-------------------------Write a Regular Expression to check string is a Strong password or not-------------------------*/
import java.util.regex.Pattern;

public class Question_5 {
    public static void main(String[] args) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).+$";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher("Jena").matches());
        System.out.println(pattern.matcher("Jena@").matches());
        System.out.println(pattern.matcher("Jena@123").matches());
    }
}