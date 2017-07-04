import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by miral on 6/30/2017.
 */
public class LogoutController extends HttpServlet {


   /* @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("a", "One");
        System.out.println("Session created with attr a : "+ req.getSession(false).getAttribute("a"));
        req.getSession(false).invalidate();
        System.out.println("Session invalidated : "+ (null == req.getSession(false)));
        resp.getWriter().write("ok");
    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session!=null) {
            System.out.println("in session logout");
           // session.removeAttribute("USER");
             session.invalidate();
//            System.out.println(session.getAttribute("USER"));

        }
        resp.sendRedirect("/");
    }
}
