/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.sun.net.httpserver.HttpContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import DAO.ProductDAO;
import Models.Product;

import java.util.List;

/**
 *
 * @author thien
 */
public class ProductListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.getAllProducts();
        handlePagination(req, products, 9);
        req.getRequestDispatcher("HomePage.jsp").forward(req, resp);

    }

    private void handlePagination(HttpServletRequest request, List<Product> products, int num_per_page) {
        ProductDAO productDAO = new ProductDAO();
        int page;
        int size = products.size();
        int num = (size % num_per_page == 0 ? (size / num_per_page) : ((size / num_per_page)) + 1);//so trang
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page - 1) * num_per_page;
        end = Math.min(page * num_per_page, size);
        List<Product> product = productDAO.getListByPage(products, start, end);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        request.setAttribute("products", product);
    }

}
