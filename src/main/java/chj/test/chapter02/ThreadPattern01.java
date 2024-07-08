package chj.test.chapter02;

public class ThreadPattern01 {
    public static void main(String[] args) {
        Thread thread = new testThread();
        thread.start();
    }
}

class testThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread 클래스 상속한 스레드");
    }

}
