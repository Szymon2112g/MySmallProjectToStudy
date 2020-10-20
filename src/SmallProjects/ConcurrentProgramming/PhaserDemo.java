package SmallProjects.ConcurrentProgramming;

import java.util.concurrent.Phaser;

public class PhaserDemo {

    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        int curPhase;

        System.out.println("Start");

        new Thread(new MyThreadPhaser(phaser, "A")).start();
        new Thread(new MyThreadPhaser(phaser, "B")).start();
        new Thread(new MyThreadPhaser(phaser, "C")).start();

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Faza nr " + curPhase + " zakonczona");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Faza nr " + curPhase + " zakonczona");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Faza nr " + curPhase + " zakonczona");

        phaser.arriveAndDeregister();

        if (phaser.isTerminated()) {
            System.out.println("Obiekt klasy phaser zakonczyl dzialanie");
        }
    }

}

class MyThreadPhaser implements Runnable {
    Phaser phaser;
    String name;

    public MyThreadPhaser(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    @Override
    public void run() {
        System.out.println("Watek " + name + " rozpoczal faze nr 1");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Watek " + name + " rozpoczal faze nr 2");
        phaser.arriveAndAwaitAdvance();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }


        System.out.println("Watek " + name + " rozpoczal faze nr 3");
        phaser.arriveAndDeregister();
    }
}
