package chj.test.chapter03;

import java.sql.SQLOutput;

public class SleepInterruptTest {
    public static void main(String[] args) throws InterruptedException {
        //1. A 스레드가 sleep 상태일 때 B 스레드에서 인터럽트를 걸 경우
        Thread AThread = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("A 스레드 인터럽트 발생! - " + Thread.currentThread().getState());
            }
        });
        AThread.start();

        Thread BThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("B스레드가 A스레드에게 인터럽트를 걸어요.");
                AThread.interrupt();
            } catch (InterruptedException e) {
                System.out.println("B 스레드 인터럽트 발생!");
            }
        });
        BThread.start();


        //2. C 스레드가 sleep 상태예정일 때 D 스레드에서 인터럽트를 걸 경우
        Thread CThread = new Thread(() -> {
            try {
                int i=0;
                while(i++>10000){
                    //
                }
                System.out.println("C스레드 sleep 직전");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println("C 스레드 인터럽트 발생! - " + Thread.currentThread().getState());
            }
        });

        Thread DThread = new Thread(() -> {
            System.out.println("D스레드가 C스레드에게 인터럽트를 걸어요.");
            CThread.interrupt();
        });
        DThread.start();
        Thread.sleep(2000);
        CThread.start();
    }
}
