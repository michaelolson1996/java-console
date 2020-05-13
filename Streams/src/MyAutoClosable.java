import java.io.IOException;

public class MyAutoClosable implements AutoCloseable {

    public void saySomething() throws IOException {
//        System.out.println("Something");
        throw new IOException("Exception from SaySomething");
    }



    @Override
    public void close() throws IOException {
        throw new IOException("Exception from close");
//        System.out.println("close");
    }
}
