package lt.viktornar.currdiff.server;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

/**
 * Created by v.nareiko on 2016-06-25.
 */
public class Starter {
    public static final int DEFAULT_PORT = 8080;
    private static final String CONTEXT_PATH = "/";
    private static final String WEB_APPDIR_LOCATION = "src/main/webapp";
    private int port;
    private Tomcat server;

    public Starter() {
        this(DEFAULT_PORT);
    }

    public Starter(int port) {
        server = new Tomcat();
        this.port = port;
    }

    public String getBaseUri() {
        return String.format("http://localhost:%d/%s", this.port, this.CONTEXT_PATH);
    }

    public void start() {
        server.setPort(this.port);
        try {
            server.addWebapp(this.CONTEXT_PATH, new File(WEB_APPDIR_LOCATION).getAbsolutePath());
            System.out.println("configuring app with basedir: " + new File("./" + WEB_APPDIR_LOCATION).getAbsolutePath());
            server.start();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            server.stop();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
