package SmallProjects.InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadingCharactersFromConsole {
    public static void main(String[] args) {

        char c = 'a';
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("wpisanie q zakonczy program");

        do {
            try {
                c = (char) br.read();
                System.out.println("wpisales " + c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while(c != 'q');
    }
}
