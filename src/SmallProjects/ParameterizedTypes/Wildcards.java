package SmallProjects.ParameterizedTypes;

import java.util.ArrayList;
import java.util.List;

public class Wildcards {

    public static void main(String[] args) {

        List<Double> doubleList = new ArrayList<>(15);
        for(int i = 1; i <= 15; i++) {
            doubleList.add(i * 1.1);
        }

        double result = addUp(doubleList);
        System.out.println("Result " + result);
    }

    static double addUp(List<? extends Number> list) {

        double result = 0;
        for(Number temp: list) {
            result += temp.doubleValue();
        }
        return result;
    }
}
