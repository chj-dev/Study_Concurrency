package chj.test.chapter06;

public class SemaphoreTest {
    public static void main(String[] args) {
        MakeSemaphore makeSemaphore = new MakeSemaphore(5);
        SharedBook sharedBook = new SharedBook(makeSemaphore);

        final int THREAD_COUNT = 5; // 전체 스레드 개수

        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(sharedBook::rent);
            threads[i].start();
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("책을 대여한 횟수: " + sharedBook.getRentSum());
    }
}

class SharedBook {
    private int value = 0;
    private MakeSemaphore makeSemaphore;

    public SharedBook(MakeSemaphore makeSemaphore) {
        this.makeSemaphore = makeSemaphore;
    }

    public void rent() {
        makeSemaphore.acquired();
        //synchronized (SharedBook.class) {
        //for(int i=0; i< 1000000; i++) {
            value++;
        //}
        //}
        makeSemaphore.release();
    }
    public int getRentSum() {
        return value;
    }
}
