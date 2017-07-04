import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by miral on 6/29/2017.
 */
public class BlogController extends HttpServlet {
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
        HttpSession session = req.getSession(false);
        if (session != null) {
            String userid = (String) session.getAttribute("USER");
            String title = req.getParameter("title");
            String content = req.getParameter("blog");

            if (title.isEmpty() || content.isEmpty()) {

                JOptionPane.showMessageDialog(null, "please fill the details");

            } else {
                Connection connection = (Connection) getServletContext().getAttribute("dbConnection");
                try {
                    PreparedStatement pst = connection.prepareStatement("insert into blog(title,content,userid) values(?,?,?)");
                    pst.setString(1, title);
                    pst.setString(2, content);
                    pst.setString(3, userid);
                    int result = pst.executeUpdate();
                    if (result == 1) {
                        JOptionPane.showMessageDialog(null, "Blog saved");
                        RequestDispatcher dispatcher = req.getRequestDispatcher("blog.jsp");
                        dispatcher.forward(req, resp);


                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry Blog cannot save.");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        } else
            resp.sendRedirect("index.jsp");
    }

}
