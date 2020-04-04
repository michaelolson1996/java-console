package olson.michael.fileio;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestDriver {
    public static void main(String[] args) throws IOException {
        FileDataManager fdm = new FileDataManager();
//        fdm.write("this is my text test", "myfile.txt");
        String content = fdm.read("myfile.txt");
        System.out.println(content);
    }
}
