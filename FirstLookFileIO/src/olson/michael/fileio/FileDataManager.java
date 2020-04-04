package olson.michael.fileio;

import java.io.*;

public class FileDataManager {
    public void write(String txt, String fileName) throws FileNotFoundException {
        PrintStream outFile = new PrintStream(fileName);
        try {
            outFile.println(txt);
        }
        finally {
            outFile.close();
        }
    }

    public String read(String fileName) throws IOException {
//        FileInputStream fileInputStream = new FileInputStream(fileName);
//        InputStreamReader reader = new InputStreamReader(fileInputStream);
//        BufferedReader inFile = new BufferedReader(reader);

        BufferedReader inFile = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        String content = "";
        while (inFile.ready()) {
            content += inFile.readLine() + "\r\n";
        }
        inFile.close();
        return content;
    }
}
