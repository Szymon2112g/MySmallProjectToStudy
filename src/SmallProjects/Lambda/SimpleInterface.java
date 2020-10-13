package SmallProjects.Lambda;

public class SimpleInterface {

    public static void main(String[] args) {

        NumericTest isEven = (n) -> (n % 2)==0;

        if(isEven.test(10)) System.out.println("10 jest parzysta");
        if(isEven.test(9)) System.out.println("9 jest parzysta");

        NumericTest isNonNeg = (n) -> n >= 0;

        if(isNonNeg.test(10)) System.out.println("10 jest liczbą dodatnia dodatnia");
        if(isNonNeg.test(-3)) System.out.println("-3 jest liczbą dodatnia dodatnia");

        SampleInterface factorial = (n) -> {
            int result = 1;

            for(int i = 1; i<= n; i++)
                result = result * i;

            return result;
        };

        System.out.println("Silnia z 10 wynosi " + factorial.test(10));

        factorialFunction(factorial, 5);

    }

    static void factorialFunction(SampleInterface sampleInterface, int n) {
        System.out.println("Silnia z " + n + " wynosi " + sampleInterface.test(n));
    }

}

@FunctionalInterface
interface NumericTest {
    boolean test(int n);
}

@FunctionalInterface
interface SampleInterface {
    int test(int n);
}


