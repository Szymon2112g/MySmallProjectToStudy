package SmallProjects.ConcurrentProgramming;

import java.util.concurrent.Semaphore;

public class SemaphoreDemoSecond {

    public static void main(String[] args) {
        Q q = new Q();
        new Thread(new Consumer(q), "Konsument").start();
        new Thread(new Producer(q), "Producent").start();
    }
}

class Q {
    int n;

    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException exp) {
            System.out.println("Wyjatek w get() przechwycony");
        }

        System.out.println("Pobrane: " + n);
        semProd.release();
    }

    void put(int n) {
        try {
            semProd.acquire();
        } catch (InterruptedException exp) {
            System.out.println("Wyjatek w put przechwycony");
        }

        this.n = n;
        System.out.println("Włożone " + n);
        semCon.release();
    }
}

class Producer implements Runnable {

    Q q;

    public Producer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            q.put(i);
        }
    }
}

class Consumer implements Runnable {

    Q q;

    public Consumer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            q.get();
        }
    }
}
