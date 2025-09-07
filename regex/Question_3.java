package regex;
/*----------------------------------Write a Regular Expression to match email addresses.----------------------------------*/
import java.util.regex.Pattern;

public class Question_3 {
    public static void main(String[] args) {
        String regex = "^[A-Za-z0-9.+-_]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher("sibasundar").matches());
        System.out.println(pattern.matcher("sibasundarj8").matches());
        System.out.println(pattern.matcher("sibasundarj8@").matches());
        System.out.println(pattern.matcher("sibasundarj8@gmail").matches());
        System.out.println(pattern.matcher("sibasundarj8@gmail.").matches());
        System.out.println(pattern.matcher("sibasundarj8@gmail.com").matches());
    }
}