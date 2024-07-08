package chj.test.chapter02;

public class ThreadPattern03 {
    public static void main(String[] args) {
        Runnable task = new Task();
        Thread thread = new Thread(task);

        thread.start();
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable 구현한 스레드");
    }
}
