import java.io.File;

public class RecursiveFilePrinter {
    public void run(String s) {
        traverseAndPrint(new File(s));
    }

    private void traverseAndPrint(File current) {
        System.out.println(current.getAbsoluteFile());
        traverseAndPrintHelper(current);
    }

    private void traverseAndPrintHelper(File current) {
        if (current.isDirectory()) {
            File[] children = current.listFiles();
            for (File child : children) {
                traverseAndPrint(child);
            }
        }
    }
}
