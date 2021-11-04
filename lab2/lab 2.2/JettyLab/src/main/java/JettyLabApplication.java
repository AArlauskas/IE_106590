import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyLabApplication {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8680);
        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);
        servletHandler.addServletWithMapping(KenobiServlet.class, "/");
        server.start();
        server.join();
    }
}
