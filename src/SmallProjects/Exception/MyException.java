package SmallProjects.Exception;

public class MyException {

    static int compute(int a, int b) throws TooBigIntException {

        int result = a + b;

        if (result > 10) {
            throw new TooBigIntException(10);
        }

        return result;
    }

    public static void main(String args[]) {

        try {
            int test = compute(10, 20);
        } catch (TooBigIntException e) {
            e.printStackTrace();
        }

    }
}

class TooBigIntException extends Exception {

    private int detail;

    TooBigIntException(int detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "TooBigIntException " + detail;
    }
}
