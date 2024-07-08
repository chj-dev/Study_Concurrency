package chj.test.chapter06;

public class MakeSemaphore {
    private int signal;
    private final int permits;

    public MakeSemaphore(int permits) {
        this.permits = permits;
        this.signal = permits;
    }

    public synchronized void acquired() {
        while (this.signal == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.signal--;
        System.out.println(Thread.currentThread().getName() + " 락 획득, 책 빌려가유!! 현재 대여된 책: " + (permits - signal) + "권");
    }

    public synchronized void release() {
        if (this.signal < permits) { // signal 값이 permits 보다 작을 때만 증가
            this.signal++;
            System.out.println(Thread.currentThread().getName() + " 락 해제, 책 반납해유!! 현재 대여 가능한 책: " + signal + "권");
            notify();   //notify 와 notifyAll 의 차이??
        }
    }
}