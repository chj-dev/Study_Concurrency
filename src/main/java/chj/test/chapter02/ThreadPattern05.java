package chj.test.chapter02;

public class ThreadPattern05 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Runnable 람다 방식 사용한 스레드"));

        thread.start();
    }
}
