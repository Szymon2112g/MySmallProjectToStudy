package SmallProjects.Lambda;

public class MoreComplexExample {

    public static void main(String[] args) {

        HighTemp[] highTemps = { new HighTemp(10), new HighTemp(11),
                                 new HighTemp(12), new HighTemp(10),
                                 new HighTemp(9), new HighTemp(10) };

        System.out.println("Ile jest temperatur o wartosci 10 = " +
                counter(highTemps, HighTemp::sameTemp, new HighTemp(10)));

    }

    static <T> int counter(T[] vals, MyFunc<T> f, T v) {

        int counter = 0;

        for(int i = 0; i < vals.length; i++) {
            if (f.func(vals[i], v))
                counter++;
        }

        return counter;
    }

}


interface MyFunc<T> {
    boolean func(T v1, T v2);
}

class HighTemp {

    private int temp;

    public HighTemp(int temp) {
        this.temp = temp;
    }

    boolean sameTemp(HighTemp tmp) {
        return this.temp == tmp.temp;
    }
}
