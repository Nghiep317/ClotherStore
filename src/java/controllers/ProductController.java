/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import DAO.ProductDAO;
import Models.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author wvrtu
 */
public class ProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Product</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Product at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            ProductDAO productDAO = new ProductDAO();

            List<Provider> providers = productDAO.getAllProviders();
            List<Product> products = productDAO.getAllProducts();
            List<Category> categories = productDAO.getAllCategories();
            handlePagination(request, products, 9);
            request.setAttribute("productDAO", productDAO);
            request.setAttribute("providers", providers);
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("categories.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("listByCategory")) {
            int category_id = Integer.parseInt(request.getParameter("category_id"));
            ProductDAO productDAO = new ProductDAO();
            List<Product> productList = productDAO.getProductsByCategory(category_id);
            List<Category> categories = productDAO.getAllCategories();
            handlePagination(request, productList, 9);
            request.setAttribute("productDAO", productDAO);
            request.setAttribute("categories", categories);
            request.setAttribute("category_id", category_id);
            request.getRequestDispatcher("categories.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("details")) {
            int product_id = Integer.parseInt(request.getParameter("product_id"));

            ProductDAO productDAO = new ProductDAO();
            Product product = productDAO.getProductById(product_id);
            int category_id = product.getCategory().getCategoryId();
            List<ProductVariation> variations = productDAO.getAllProductVariations(product);
            List<Product> productList = productDAO.getProductsByCategory(category_id);
            List<Image> imgList = productDAO.getAllImages(product);
            handlePagination(request, productList, 9);
            request.setAttribute("productDAO", productDAO);
            request.setAttribute("product", product);
            request.setAttribute("variations", variations);
            request.setAttribute("images", imgList);
            request.getRequestDispatcher("product-details.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
