/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import Models.Product;
import DAO.ProductDAO;
import DAO.ProviderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import Models.Category;
import Models.ProductVariation;
import Models.Provider;

/**
 *
 * @author wvrtu
 */
public class ProductManager extends HttpServlet {

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
        ProductDAO productDAO = new ProductDAO();
        
        List<Provider> providers = productDAO.getAllProviders();
        List<Product> products = productDAO.getAllProducts();
        List<Category> categories = productDAO.getAllCategories();
        
        request.setAttribute("providers", providers);
        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
        
        request.getRequestDispatcher("admin/productManager.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("action");
        
        ProductDAO productDAO = new ProductDAO();
        
        if (action == null) {
            response.sendRedirect(request.getContextPath() + "/productmanager");
            return;
        }
        
        switch (action) {
            case "add":
                addProduct(request, productDAO);
                break;
            case "update":
                updateProduct(request, productDAO);
                break;
            case "delete":
                deleteProduct(request, productDAO);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/productmanager");
        }
        
        response.sendRedirect(request.getContextPath() + "/productmanager");
    }
    
    private void addProduct(HttpServletRequest request, ProductDAO productDAO){
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int providerId = Integer.parseInt(request.getParameter("providerId"));
        String productName = request.getParameter("productName");
        String coverImg = request.getParameter("coverImg");
        String description = request.getParameter("description");

        Product newProduct = new Product();
        newProduct.setCategory(productDAO.getCategoryById(categoryId));
        newProduct.setProvider(productDAO.getProviderById(providerId));
        newProduct.setProductName(productName);
        newProduct.setCoverImg(coverImg);
        newProduct.setDescription(description);

        productDAO.addProduct(newProduct);
    }
    
    private void updateProduct(HttpServletRequest request, ProductDAO productDAO){
        
    }
    
    private void deleteProduct(HttpServletRequest request, ProductDAO productDAO){
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
