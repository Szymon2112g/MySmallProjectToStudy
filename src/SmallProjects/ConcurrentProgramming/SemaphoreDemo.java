package SmallProjects.ConcurrentProgramming;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(1);

        new Thread(new IncThread("A", sem)).start();
        new Thread(new DecThread("B", sem)).start();

    }

}

class Shared {
    static int count = 0;
}

class IncThread implements Runnable {

    String name;
    Semaphore sem;

    public IncThread(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
    }

    @Override
    public void run() {

        System.out.println("Uruchamiam " + name);

        try {
            System.out.println(name + " czeka na pozwolenie");
            sem.acquire();
            System.out.println(name + " uzyskal pozwolenie");

            for(int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        System.out.println(name + " zwalnia pozwolenie na dostep");
        sem.release();
    }
}

class DecThread implements Runnable {

    String name;
    Semaphore sem;

    public DecThread(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
    }

    @Override
    public void run() {

        System.out.println("Uruchamiam " + name);

        try {
            System.out.println(name + " czeka na pozwolenie");
            sem.acquire();
            System.out.println(name + " uzyskal pozwolenie");

            for(int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        System.out.println(name + " zwalnia pozwolenie na dostep");
        sem.release();
    }
}
