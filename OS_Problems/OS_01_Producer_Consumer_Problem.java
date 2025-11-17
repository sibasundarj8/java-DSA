package OS_Problems;

import java.util.concurrent.Semaphore;

public class OS_02_Reader_Writer_Problem {

    /// main Method
    public static void main(String[] args) {
        Document doc = new Document();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++)
                new Reader(i, doc).start();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 10; i <= 13; i++)
                new Writer(i, doc).start();
        });

        t1.start();
        t2.start();
    }
}

// Reader which is going to read the document.
class Reader extends Thread {
    private final Document document;
    private final int id;

    public Reader(int id, Document document) {
        this.id = id;
        this.document = document;
    }

    public void run() {
        try {
            document.startRead(id);
            Thread.sleep(200);
            document.endRead(id);
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Writer which is going to write on the document. (only one allowed at a time)
class Writer extends Thread {
    private final Document document;
    private final int id;

    public Writer(int id, Document document) {
        this.id = id;
        this.document = document;
    }

    public void run() {
        try {
            document.startWrite(id);
            Thread.sleep(500);
            document.endWrite(id);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Document in which multiple reader or single writer can perform operation synchronously.
class Document {
    private final Semaphore wrt;
    private final Semaphore mutex;
    private int readerCount;

    public Document() {
        this.wrt = new Semaphore(1);    // used to allow only a single writer.
        this.mutex = new Semaphore(1);  // used to keep readerCount thread-safe.
        this.readerCount = 0;
    }

    public void startWrite(int id) throws InterruptedException {
        wrt.acquire();
        System.out.println("[Thread-" + id + "] : Start Writing ## ");
    }

    public void endWrite(int id) throws InterruptedException {
        System.out.println("[Thread-" + id + "] : Stop Writing !! ");
        wrt.release();
    }

    public void startRead(int id) throws InterruptedException {
        mutex.acquire();
        readerCount++;
        if (readerCount == 1) wrt.acquire();
        mutex.release();

        System.out.println("[Thread-" + id + "] : Start Reading ## ");
    }

    public void endRead(int id) throws InterruptedException {
        System.out.println("[Thread-" + id + "] : End Reading !! ");

        mutex.acquire();
        readerCount--;
        if (readerCount == 0) wrt.release();
        mutex.release();
    }
}
