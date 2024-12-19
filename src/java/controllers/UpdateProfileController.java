package controllers;

import DAO.UserDAO;
import Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProfileController extends HttpServlet {

   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
    String id = req.getParameter("userid");
    if (id == null) {
        req.setAttribute("errorMessage", "Account ID not found in session.");
        req.getRequestDispatcher("/Profile.jsp").forward(req, resp);
        return;
    }

    String username = req.getParameter("username");
    String email = req.getParameter("email");
    String password = req.getParameter("password");
    String confirmPassword = req.getParameter("confirm-password");
    int accountId = Integer.parseInt(id);

    // Kiểm tra xem các trường cần thiết có được truyền từ form không
    if (username == null || email == null || password == null || confirmPassword == null) {
        req.setAttribute("errorMessage", "Please fill in all fields.");
        req.getRequestDispatcher("/Profile.jsp").forward(req, resp);
        return;
    }

    // Kiểm tra xem mật khẩu và mật khẩu xác nhận có khớp không
    if (!password.equals(confirmPassword)) {
        req.setAttribute("errorMessage", "Passwords do not match.");
        req.getRequestDispatcher("/Profile.jsp").forward(req, resp);
        return;
    }

    UserDAO userDAO = new UserDAO();
    User user = new User(accountId, username, password, email, "user", false);
    userDAO.updateUser(user);
    
    // Cập nhật thông tin người dùng và kiểm tra kết quả
        req.getSession().setAttribute("AccSession", user);
        req.getSession().setAttribute("successMessage", "Update successful!"); // Set success message
        resp.sendRedirect(req.getContextPath() + "/Profile.jsp");
       } catch (Exception e) {
           
            req.setAttribute("errorMessage", "Update failed. Please try again.");
        req.getRequestDispatcher("/Profile.jsp").forward(req, resp);
       }
   
    }
}


