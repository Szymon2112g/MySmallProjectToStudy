package SmallProjects.ConcurrentProgramming;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new BarAction());

        System.out.println("Start");

        new Thread(new MyThreadTest(cyclicBarrier, "A")).start();
        new Thread(new MyThreadTest(cyclicBarrier, "B")).start();
        new Thread(new MyThreadTest(cyclicBarrier, "C")).start();
        new Thread(new MyThreadTest(cyclicBarrier, "D")).start();
        new Thread(new MyThreadTest(cyclicBarrier, "E")).start();
        new Thread(new MyThreadTest(cyclicBarrier, "F")).start();
    }
}

class MyThreadTest implements Runnable {
    CyclicBarrier cyclicBarrier;
    String name;

    public MyThreadTest(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);

        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            System.out.println(e);
        }
    }
}

class BarAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Bariera osiagnieta");
    }
}
