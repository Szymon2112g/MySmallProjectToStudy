package SmallProjects.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class SimpleTest {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();

        stringList.add("Szymon1");
        stringList.add("Szymon2");
        stringList.add("test");
        stringList.add("test");
        stringList.add("Szymon12");
        stringList.add("Szymon");

        Stream<String> stringStream = stringList.stream();

        System.out.println("Pozycji na liście " + stringStream.count());

        stringStream = stringList.stream();

        String optional = stringStream.max((o1, o2) -> {
            return (o1.length() > o2.length()) ? 1 : (o1.length() == o2.length() ? 0 : -1);
        }).orElse("Nie mam");

        System.out.println(optional);

        stringStream = stringList.stream();

        long count = stringStream.filter((p) -> {
            int temp =  p.indexOf("Sz");
            return temp >= 0 ? true : false;
        }).count();

        System.out.println("Liczba wyrazow zaczynajacych sie od \"Sz\" " + count);
    }
}
