package lt.viktornar.currdiff;

import lt.viktornar.currdiff.server.Starter;
import java.io.IOException;

/**
 * Created by v.nareiko on 2016-06-25.
 */
public class Main {

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final Starter starter = new Starter(8080);
        starter.start();
        System.in.read();
        starter.stop();
    }
}