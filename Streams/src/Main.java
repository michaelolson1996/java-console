import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    // Byte Stream Base Class - InputStream, OutputStream
    // Text Stream Base Class - Reader, Writer
    // int read() - get data


    public static void main(String[] args) throws Exception {
        readDataWithNonDep();
        readThemAll();
    }

    // Deprecated : java.file.io
    // Try With Resources Example
/*
    public static void doTryCatchFinally() {
        char[] buff = new char[8];
        int length;
        Reader reader = null;
        try
        {
            reader = Helper.openReader("file1.txt");
            while ((length = reader.read(buff)) >= 0)
            {
                System.out.println("\nlength:" + length);
                for (int i = 0; i < length; i++)
                    System.out.println(buff[i]);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        finally
        {
            try
            {
                if (reader != null)
                    reader.close();
            }
            catch (IOException e2)
            {
                System.out.println(e2.getClass().getSimpleName() + " - " + e2.getMessage());
            }
        }
    }

    public static void doTryWithResources() {
        char[] buff = new char[8];
        int length;

        // automatically close Stream Resource
        try (Reader reader = Helper.openReader("file1.txt"))
        {
            while ((length = reader.read(buff)) >= 0)
            {
                System.out.println("\nlength:" + length);
                for (int i = 0; i < length; i++)
                    System.out.println(buff[i]);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    public static void doTryWithResourcesMulti() {
        char[] buff = new char[8];
        int length;

        // automatically close Stream for multiple resources
        try (Reader reader = Helper.openReader("file1.txt");
             Writer writer = Helper.openWriter("file2.txt"))
        {
            while ((length = reader.read(buff)) >= 0)
            {
                System.out.println("\nlength:" + length);
                writer.write(buff, 0, length);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
*/
    public static void doCloseThing() {
        try (MyAutoClosable ac = new MyAutoClosable())
        {
            ac.saySomething();
        }
        catch (IOException e)
        {
//            e.getSuppressed() - gets suppressed exceptions
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());

            for (Throwable t : e.getSuppressed())
                System.out.println("Suppressed: " + t.getMessage());
        }
    }


    // dont want to interact with files directly
    // Consistent with line breaks on multiple OS
    // Unix : \n
    // Windows : \r\n
    // BufferedWriter : generate line breaks : newLine()
    // BufferedReader : line based read : readLine()
    // Buffered streams improve efficiency
    // Buffer content in memory
    // Performs read/write methods in large chunks
    // reduces underlying stream interaction
    // Available for all 4 Stream types :
    // 1. BufferedReader
    // 2. BufferedWriter
    // 3. BufferedInputStream
    // 4. BufferedOutputStream

    public static void buildBuffer() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("file1.txt")))
        {
            int intVal;
            char charVal;
            while ((intVal = br.read()) >= 0)
                charVal = (char) intVal;
        }
    }

    // MULTI LINE WRITING AND READING DATA
    public void writeData(String[] data) throws IOException
    {
        try (BufferedWriter bw =
                new BufferedWriter(new FileWriter("data.txt")))
        {
            for (String d : data)
            {
                bw.write(d);
                bw.newLine(); // seperates values by line
            }
        }
    }

    public void readData() throws IOException
    {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt")))
        {
            String inValue;
            // end of file == null
            while ((inValue = br.readLine()) != null)
            {
                System.out.println(inValue);
            }
        }
    }

    // java.nio.file package : accessing files
    public static void readDataWithNonDep() throws Exception {
        try (BufferedReader br =
                Files.newBufferedReader(Paths.get("data.txt")))
        {
            String inValue;
            while ((inValue = br.readLine()) != null)
            {
                System.out.println(inValue);
            }
        }
    }

    public static void readThemAll() throws IOException
    {
        List<String> lines = Files.readAllLines(Paths.get("data.txt"));

        for (String line : lines)
            System.out.println(line);
    }
}
