package Java_8;

import java.util.Arrays;
import java.util.List;

record Students(String name) {
}

public class J8_References {

    static void print(String s){
        System.out.println(s);
    }

    /// main Method
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Siba", "Anu");
        list.forEach(J8_References :: print);

        List<Students> classRoom = list.stream().map(Students :: new).toList();
        classRoom.forEach(x -> System.out.println(x.name()));
    }
}
