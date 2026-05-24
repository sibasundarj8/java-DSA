import java.util.*;

/*
 * : ⁰ ¹ ² ³ ⁴ ⁵ ⁶ ⁷ ⁸ ⁹ ⁿ ᵏ ⁱ × ⁺ ⁻ ⁼ ⁽ ⁾ ˙
 * : ₀ ₁ ₂ ₃ ₄ ₅ ₆ ₇ ₈ ₉ ₊ ₋ ₌ ₍ ₎
 * : ⅐ ⅑ ⅒ ⅓ ⅔ ⅕ ⅖ ⅗ ⅘ ⅙ ⅚ ⅛ ⅜ ⅝ ⅞
 */
public class Main {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("a", null);
        map.putIfAbsent("a", "1");
        map.putIfAbsent("a", hello("putIf"));
        map.computeIfAbsent("a", k -> hello("computeIf"));
        System.out.println(map.get("a"));
    }

    private static String hello(String parent) {
        System.out.println("called by : " + parent);
        return "Hello";
    }
}
