package Generics;

class MyException extends Exception {
    public <T> MyException (T value) {
        super("Exception related to value: " +
                value.toString() +
                " of type: " +
                value.getClass().getName()
        );
    }
}
public class Exception_use {
    public static void main(String[] args) {

        try{
            throw new MyException(986);
        }
        catch (MyException e){
            System.out.println("Caught Exception: " + e.getMessage());
        }

        try{
            throw new MyException("String");
        }
        catch (MyException e){
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}