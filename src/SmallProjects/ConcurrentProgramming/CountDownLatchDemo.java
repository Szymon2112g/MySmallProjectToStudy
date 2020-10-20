package SmallProjects.ConcurrentProgramming;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        System.out.println("Start");
        new Thread(new MyThread(countDownLatch)).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Koniec");
    }
}

class MyThread implements Runnable {
    CountDownLatch latch;

    public MyThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown();
        }
    }
}
