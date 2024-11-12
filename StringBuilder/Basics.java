package StringBuilder;

public class Basics {
    public static void main(String[] args) {
        // Initialization
        StringBuilder str = new StringBuilder("Hello");
        // Printing
        System.out.println(str);

        // Concatenation of String Builder
        String gtr = " World ";
        System.out.println(str.append(gtr)); // Hello World
        System.out.println(str.append(34));  // Hello World 34

        // Set or delete at particular index
        str.setCharAt(0,'S');
        System.out.println(str);  // Sello World 34
        str.deleteCharAt(0);// ello World 34

        // Delete a part
        StringBuilder sb = new StringBuilder("Anupama");
        System.out.println(sb);
        // it deletes 3rd index to 6th index
        // sb.delete(start(Inclusive), end(Exclusive));
        sb.delete(3,7);
        System.out.println(sb);
        
    }
}