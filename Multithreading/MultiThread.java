package Multithreading;

public class MultiThread {
    public static void main(String[] args) {
        // Working Two threads simultaneously
        T1.thread.start();
        T2.thread.start();
    }
}
class T1 {
    static Thread thread = new Thread(()->{
        for (int i = 0;i < 10;i++){
            System.out.println("Anu");
            try {
                Thread.sleep(300);
            }
            catch (Exception e){
                throw new RuntimeException();
            }
        }
    });
}
class T2 {
    static Thread thread = new Thread(()->{
        for (int i = 0;i < 10;i++){
            try {
                Thread.sleep(300);
            }
            catch (Exception e){
                throw new RuntimeException();
            }
            System.out.println("Siba");
        }
    });
}