package SmallProjects.LabelCodeBlock;

public class BreakInstruction {

    public static void main(String args[]) {

        first: {
            second: {
                third: {
                    System.out.println("third block");
                    if (1 == 1) break second;
                }
                System.out.println("second block -- will not be done");
            }
            System.out.println("first block");
        }

    }
}
