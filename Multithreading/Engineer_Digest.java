package Multithreading;

class MyThread extends Thread{
    MyThread (String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10;i++){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Main{
    public static void main(String[] args) throws InterruptedException {
        Thread th = new MyThread("Siba");
        Thread sh = new MyThread("Upendra");
        th.setPriority(1);
        sh.setPriority(10);
        sh.start();
        th.start();
    }
}