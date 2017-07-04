import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.sql.*;

/**
 * Created by miral on 6/30/2017.
 */
public class AuthController implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        makeConnection(filterConfig.getServletContext());
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       /* HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if(null == req.getSession(false)) {
            String user = req.getParameter("user");
            String pass = req.getParameter("pass");

            Connection connection = (Connection) req.getServletContext().getAttribute("dbConnection");
            try {
                PreparedStatement pst = connection.prepareStatement("select * from user where email=? and password=?");
                pst.setString(1, user);
                pst.setString(2, pass);
                ResultSet result = pst.executeQuery();
                if (result.next()) {
                    HttpSession session = req.getSession();
                session.setAttribute("USER", user);
                    System.out.println("in auth filter");


                } else {
                    JOptionPane.showMessageDialog(null, "Invalid email or password");
                    resp.sendRedirect("index.jsp");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            chain.doFilter(request, response);
        }*/
    }

    public void makeConnection(ServletContext context) {
        String databaseDriverClass = context.getInitParameter("databaseDriverClass");
        String databaseUser = context.getInitParameter("databaseUser");
        String databasePassword = context.getInitParameter("databasePassword");
        String databaseConnectionString = context.getInitParameter("databaseConnectionString");
        try {
            Class.forName(databaseDriverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("here....");
        }
        try {
            Connection connection = DriverManager.getConnection(databaseConnectionString, databaseUser, databasePassword);
            context.setAttribute("dbConnection", connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
