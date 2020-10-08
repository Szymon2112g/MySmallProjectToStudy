package SmallProjects.InputOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteAndReadFromFile {

    public static void main(String[] args){

        try (FileOutputStream fout = new FileOutputStream("plik.txt");
             FileInputStream fin = new FileInputStream("plik.txt")) {

            fout.write(22);
            System.out.println(fin.read());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
