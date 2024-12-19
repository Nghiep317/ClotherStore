package controllers;

import DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Models.User;

public class LoginControllers extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        resp.setContentType("text/html;charset=utf-8");
        String email = req.getParameter("txtEmail");
        String pass = req.getParameter("txtPass");
        String msgEmail = "";
        String msgPass = "";

        if (email.isEmpty()) {
            msgEmail = "Email is required";
            req.setAttribute("msgEmail", msgEmail);
        }

        if (pass.isEmpty()) {
            msgPass = "Password is required";
            req.setAttribute("msgPass", msgPass);
        }

        if (!msgEmail.isEmpty() || !msgPass.isEmpty()) {
            req.getRequestDispatcher("/Login.jsp").forward(req, resp);
        } else {
            User acc = dao.getAccount(email, pass);
            if (acc != null) {
                // Set session attribute
                req.getSession().setAttribute("AccSession", acc);
                req.getSession().setAttribute("successMessage", "Login successful!"); // Set success message

                resp.sendRedirect(req.getContextPath() + "/ProductList"); 
                //tại t để load data ở controllers trước nên phải truyền từ file đó
              
            } else {
                // Send error message to Login.jsp
                req.setAttribute("txtEmail", email);
                req.setAttribute("msg", "Account not exist");
                req.getRequestDispatcher("/Login.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        if (req.getSession().getAttribute("AccSession") != null) {
            req.getSession().removeAttribute("AccSession");
            resp.sendRedirect(req.getContextPath() + "/ProductList");
        } else {
            req.getRequestDispatcher("/Login.jsp").forward(req, resp);
        }
    }
}
