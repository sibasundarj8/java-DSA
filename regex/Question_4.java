package regex;
/*-----------------Write a Regular Expression for matching username that contain numbers, letters and @$-----------------*/
import java.util.regex.Pattern;

public class Question_4 {
    public static void main(String[] args) {
        String regex = "^[A-Za-z0-9]{3,}[@_$]*[A-Za-z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher("Jena").matches());
        System.out.println(pattern.matcher("Jena@").matches());
        System.out.println(pattern.matcher("Jena@123").matches());
    }
}