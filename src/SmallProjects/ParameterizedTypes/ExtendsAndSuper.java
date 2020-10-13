package SmallProjects.ParameterizedTypes;

import java.util.ArrayList;
import java.util.List;

public class ExtendsAndSuper {

    public static void main(String[] args) {

        A varA = new A(1 , 2, 3);
        B varB = new B(1, 2, 3, 4, 5, 6);
        C varC = new C(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // useExtendB(varA); this don't work
        useExtendB(varB);
        useExtendB(varC);


        System.out.println("\nSuper Wildcard \n");

        List<A> aList = new ArrayList<>();
        aList.add(varA);
        aList.add(varB);
        aList.add(varC);
        useWildcardSuperB(aList);

        List<B> bList = new ArrayList<>();
        // bList.add(varA); don't work
        bList.add(varB);
        bList.add(varC);
        useWildcardSuperB(bList);

        List<C> cList = new ArrayList<>();
        // bList.add(varA); don't work
        // cList.add(varB); don't work
        cList.add(varC);
        // useWildcardSuperB(cList); don't work

        // useWildcardExtendB(aList); don't work
        useWildcardExtendB(bList);
        useWildcardExtendB(cList);


    }

    public static <T extends B> void useExtendB(T var) {
        System.out.println(var);
    }

    public static void useWildcardSuperB(List<? super B> list) {
        list.stream().forEach(o -> System.out.println(o));
    }

    public static void useWildcardExtendB(List<? extends B> list) {
        list.stream().forEach((o) -> System.out.println(o));
    }
}

class A {
    private int privA;
    protected int protA;
    public int publA;

    public A(int privA, int protA, int publA) {
        this.privA = privA;
        this.protA = protA;
        this.publA = publA;
    }

    @Override
    public String toString() {
        return "A{" +
                "privA=" + privA +
                ", protA=" + protA +
                ", publA=" + publA +
                '}';
    }
}

class B extends A {

    private int privB;
    protected int protB;
    public int publB;

    public B(int privA, int protA, int publA, int privB, int protB, int publB) {
        super(privA, protA, publA);
        this.privB = privB;
        this.protB = protB;
        this.publB = publB;
    }

    @Override
    public String toString() {
        return "B{" +
                "protA=" + protA +
                ", publA=" + publA +
                ", privB=" + privB +
                ", protB=" + protB +
                ", publB=" + publB +
                '}';
    }
}

class C extends B {
    private int privC;
    protected int protC;
    public int publC;

    public C(int privA, int protA, int publA, int privB, int protB, int publB, int privC, int protC, int publC) {
        super(privA, protA, publA, privB, protB, publB);
        this.privC = privC;
        this.protC = protC;
        this.publC = publC;
    }

    @Override
    public String toString() {
        return "C{" +
                "protA=" + protA +
                ", publA=" + publA +
                ", protB=" + protB +
                ", publB=" + publB +
                ", privC=" + privC +
                ", protC=" + protC +
                ", publC=" + publC +
                '}';
    }
}
