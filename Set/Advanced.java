package Set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


class Students {
    String name;
    int rollNo;

    Students(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public String toString(){
        return "Students{" +
                "name='" + name + "'" +
                ", rollNo=" + rollNo +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return rollNo == students.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }
}
public class Advanced {
    public static void main(String[] args) {

        Set<Students> s = new HashSet<>();

        s.add(new Students("Siba",36));
        s.add(new Students("Anu",35));
        s.add(new Students("Subrat",63));
        s.add(new Students("Jaga",25));
        s.add(new Students("Raghu",25));   // not added to set bcz of same Roll.

        System.out.println(s);
    }
}