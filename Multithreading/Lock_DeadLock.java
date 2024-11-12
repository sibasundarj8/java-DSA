package Multithreading;


class Pen{
    synchronized void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName() + " is using pen " + this + " trying to use paper.");
        paper.finishWriting();
    }
    synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " Finish using pen " + this);
    }
}
class Paper{
    synchronized void writeWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName() + " is using paper " + this + " trying to use pen.");
        pen.finishWriting();
    }
    synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " Finish using paper " + this);
    }
}
class Task1 implements Runnable{
    private final Pen pen;
    private final Paper paper;
    Task1(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }
    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper);
    }
}
class Task2 implements Runnable{
    private final Pen pen;
    private final Paper paper;
    Task2(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }
    @Override
    public void run() {
        paper.writeWithPaperAndPen(pen);
    }
}
public class Lock_DeadLock {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();
        Thread t1 = new Thread(new Task1(pen,paper));
        Thread t2 = new Thread(new Task2(pen,paper));
        t1.start();
        t2.start();
    }
}