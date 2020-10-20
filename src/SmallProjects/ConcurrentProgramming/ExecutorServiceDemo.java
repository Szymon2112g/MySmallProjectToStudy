package SmallProjects.ConcurrentProgramming;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

    public static void main(String[] args) {
        CountDownLatch cl1 = new CountDownLatch(5);
        CountDownLatch cl2 = new CountDownLatch(5);
        CountDownLatch cl3 = new CountDownLatch(5);
        CountDownLatch cl4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2);

        es.execute(new MyThreadES("A", cl1));
        es.execute(new MyThreadES("B", cl2));
        es.execute(new MyThreadES("C", cl3));
        es.execute(new MyThreadES("D", cl4));

        try {
            cl1.await();
            cl2.await();
            cl3.await();
            cl4.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        es.shutdown();
        System.out.println("Koniec");

    }
}

class MyThreadES implements Runnable {
    String name;
    CountDownLatch latch;

    public MyThreadES(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }

    @Override
    public void run() {

        for(int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
}
