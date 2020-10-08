package SmallProjects.InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadingStringFromConsole {
    public static void main(String[] args) {

        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("wpisanie stop zakonczy program");

        do {
            try {
                str = br.readLine();
                System.out.println("wpisales " + str);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } while(!str.equals("stop"));
    }
}
