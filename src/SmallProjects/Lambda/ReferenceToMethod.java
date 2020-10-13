package SmallProjects.Lambda;

public class ReferenceToMethod {

    public static void main(String[] args) {

        System.out.println("dodawanie 2 + 3 = " + operation(TestClass::addInt, 2, 3));

        SecondTestClass secondTestClass = new SecondTestClass();

        System.out.println("dodawanie 3 + 5 = " + operation(secondTestClass::addInt, 3, 5));
    }

    static int operation(TestInterface testInterface, int n, int m) {
        return testInterface.action(n, m);
    }
}

class TestClass {
    static int addInt(int n, int m) {
        return n + m;
    }
}

class SecondTestClass {
    int addInt(int n, int m) {
        return n + m;
    }
}

@FunctionalInterface
interface TestInterface {
    int action(int n, int m);
}
