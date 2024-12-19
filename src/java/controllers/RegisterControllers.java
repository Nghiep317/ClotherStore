package controllers;

import Models.User;
import DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterControllers extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("txtCopName");
        String email = req.getParameter("txtEmail");
        String password = req.getParameter("txtPass");
        String rePassword = req.getParameter("txtRePass");
        if (username == null || email == null || password == null || rePassword == null || username.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
            req.setAttribute("msg", "Vui lòng điền đầy đủ thông tin đăng ký.");
            req.getRequestDispatcher("/Register.jsp").forward(req, resp);
            return;
        }
        if (!isValidEmail(email)) {
            req.setAttribute("msg", "Email không hợp lệ.");
            req.getRequestDispatcher("/Register.jsp").forward(req, resp);
            return;
        }
        if (!password.equals(rePassword)) {
            req.setAttribute("msg", "Mật khẩu không khớp.");
            req.getRequestDispatcher("/Register.jsp").forward(req, resp);
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("user");
        user.setIs_removed(false);

        UserDAO userDAO = new UserDAO();
        User RegisteredUser = userDAO.registerAccount(user);

        if (RegisteredUser != null) {
            resp.sendRedirect("Login"); 
        } else {
            req.setAttribute("msg", "Đăng ký không thành công. Vui lòng thử lại sau.");
            req.getRequestDispatcher("/Register.jsp").forward(req, resp);
        }
    }

    private boolean isValidEmail(String email) {
        // Sử dụng regex để kiểm tra định dạng email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        if (req.getSession().getAttribute("AccSession") == null) {
            req.getRequestDispatcher("/Register.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher(req.getContextPath() + "/Login.jsp").forward(req, resp);
        }
    }

}
