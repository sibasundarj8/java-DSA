package Multithreading;

public class Daemon_Thread {
    public static void main(String[] args) {
        Thread daemon = new Thread(() -> {
            while (true){
                System.out.println("Daemon is running...");
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        daemon.setDaemon(true);
        daemon.start();
    }
}