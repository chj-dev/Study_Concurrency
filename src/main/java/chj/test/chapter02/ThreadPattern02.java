package chj.test.chapter02;

public class ThreadPattern02 {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("스레드 익명 클래스");
            }
        };

        thread.start();
    }
}
