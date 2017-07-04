import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.sql.*;

/**
 * Created by miral on 6/28/2017.
 */
public class LoginController extends HttpServlet {


    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
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


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
                System.out.println("i am here ");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("blog.jsp");
                requestDispatcher.forward(req, resp);


            } else {
                JOptionPane.showMessageDialog(null, "Invalid email or password");
                resp.sendRedirect("index.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
