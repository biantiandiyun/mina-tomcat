import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by admin on 2017/3/13.
 */
public class TestServlet implements Servlet {

    public void init(ServletConfig config) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("from service");
        Response response = (Response)res;
        String context = " this is test servlet";
        response.setContentLength(context.getBytes().length);
        response.sendResponseHeaders();
        PrintWriter out = res.getWriter();
        out.print(context);
        out.flush();
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("destroy");
    }
}
