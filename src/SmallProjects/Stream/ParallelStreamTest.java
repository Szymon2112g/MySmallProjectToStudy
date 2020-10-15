package SmallProjects.Stream;

import java.util.LinkedList;

public class ParallelStreamTest {

    public static void main(String[] args) {
        LinkedList<Long> longs = new LinkedList<>();

        long start = System.currentTimeMillis();

        for(int i = 0; i < 100; i++) { //(Integer.MAX_VALUE / 30)
            longs.add((long) i);
        }

        long end = System.currentTimeMillis();

        System.out.println("Czas jaki zabrało inicjalizowanie listy " + (end - start));

        start = System.currentTimeMillis();

        long result = longs.stream().reduce(0l, (a, b) -> {
                    long tmp = a + b;
                    System.out.println("a = " + a +  " + b = " + b +" \t (a+b) = "+ tmp);
                    return a + b;
                }
        );

        end = System.currentTimeMillis();

        System.out.println("Czas jaki zabrło obliczanie wyniku " + (end - start) + " a wynik to " + result);

        start = System.currentTimeMillis();

        result = longs.parallelStream().reduce(0l, (a, b) -> {
                    long tmp = a + b;
                    System.out.println("a = " + a +  " + b = " + b +" \t (a+b) = "+ tmp);
                    return a + b;
                }
        );

        end = System.currentTimeMillis();

        System.out.println("Czas jaki zabrło obliczanie wyniku " + (end - start) + " a wynik to " + result);


    }
}
