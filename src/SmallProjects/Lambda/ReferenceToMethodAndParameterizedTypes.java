package SmallProjects.Lambda;

public class ReferenceToMethodAndParameterizedTypes {

    static <T> int myOp(MyInterface<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String[] args) {

        String[] strings = { "Szymon", "Szymmm", "Szymon", "SZymon", "Szymon"};
        Integer[] integers = { 1, 2, 3, 4, 5, 6, 1, 2, 2, 3, 4, 1};

        System.out.println("Liczba wystapien \"Szymon\" " + myOp(MyArrayOps::<String>countMatching, strings, "Szymon"));
        System.out.println("Liczba wystapien liczby 1 " + myOp(MyArrayOps::<Integer>countMatching, integers, 1));

    }

}

interface MyInterface<T> {
    int func(T[] vals, T v);
}

class MyArrayOps {
    static <T> int countMatching(T[] vals, T v) {
        int count = 0;

        for(int i = 0; i < vals.length; i++) {
            if (vals[i].equals(v) == true)
                count++;
        }

        return count;
    }
}
