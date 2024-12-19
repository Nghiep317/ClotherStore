package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import DAO.UserDAO;

/**
 * Servlet implementation class for deleting user profiles
 */
public class DeleteProfileController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userID"));
        UserDAO userDAO = new UserDAO();
        try {
            userDAO.deleteUserByID(userId);
            request.setAttribute("successMessage", "User deletion successful!");
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "User deletion failed!");
        }
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
