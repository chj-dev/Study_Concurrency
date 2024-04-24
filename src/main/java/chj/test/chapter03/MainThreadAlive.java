package chj.test.chapter03;

public class MainThreadAlive {
    public static void main(String[] args) {
        //메인 스레드는 서브 스레드를 기다리는지/먼저 종료되는지에 관한 테스트

        Thread mainThread = Thread.currentThread();

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("메인 스레드 살아있나?: " + mainThread.isAlive());
            } catch (InterruptedException e) {
                System.out.println("스레드 오류");
            }
        });
        thread.start();

    }
}
