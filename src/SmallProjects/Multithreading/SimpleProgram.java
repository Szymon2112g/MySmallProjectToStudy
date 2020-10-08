package SmallProjects.Multithreading;

public class SimpleProgram {

    public static void main(String[] args) {

        NewThread t1 = createAndStart("pierwszy");
        NewThread t2 = createAndStart("drugi");

        try {
            Thread.sleep(500);
            t1.mySuspended();

            Thread.sleep(500);
            t1.myResume();

            Thread.sleep(500);
            t2.mySuspended();

            Thread.sleep(500);
            t2.myResume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            t1.t.join();
            t2.t.join();

            System.out.println("koniec pracy watkow");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static NewThread createAndStart(String name) {
        NewThread myThread = new NewThread(name);
        myThread.t.start();
        return myThread;
    }

}

class NewThread implements Runnable {

    Thread t;
    String name;
    boolean suspendedFlag;


    public NewThread(String name) {
        this.name = name;
        t = new Thread(this, name);
        suspendedFlag = false;
    }

    @Override
    public void run() {

        try {
            for(int i = 20; i > 0; i--) {
                System.out.println(name + ":" + i);
                Thread.sleep(200);
                synchronized (this) {
                    while(suspendedFlag) {
                        wait();
                    }
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void mySuspended() {
        suspendedFlag = true;
    }

    synchronized void myResume() {
        suspendedFlag = false;
        notify();
    }
}
