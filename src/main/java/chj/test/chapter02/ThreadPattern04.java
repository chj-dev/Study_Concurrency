package chj.test.chapter02;

public class ThreadPattern04 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable 익명 클래스 사용한 스레드");
            }
        });

        thread.start();
    }
}
