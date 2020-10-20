package SmallProjects.ConcurrentProgramming;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<String>();

        new Thread(new UseString(exchanger)).start();
        new Thread(new MakeString(exchanger)).start();
    }

}

class MakeString implements Runnable {
    Exchanger<String> exchanger;
    String string;

    public MakeString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        string = new String();
    }

    @Override
    public void run() {
        char ch = 'A';

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 5; j++) {
                string += (char) ch++;
            }

            try {
                string = exchanger.exchange(string);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

}

class UseString implements Runnable {
    Exchanger<String> exchanger;
    String string;

    public UseString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            try {
                string = exchanger.exchange(new String());
                System.out.println("Otrzymalem " + string);
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
        }
    }
}
