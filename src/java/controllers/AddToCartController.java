/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import DAO.Cart_itemDAO;
import DAO.ProductDAO;
import Models.Cart_item;
import Models.ProductVariation;
import Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
public class AddToCartController extends HttpServlet {

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
            out.println("<title>Servlet AddToCartController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCartController at " + request.getContextPath() + "</h1>");
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
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = "";
        User current = (User) request.getSession().getAttribute("AccSession");
        Cart_itemDAO cart_itemDAO = new Cart_itemDAO();
        //if the user has not logged in, redirect to login page
        if(current == null){
            msg = "You must log in first";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        //if this product is already in cart, add quantity (to stock limit)
        String svid = request.getParameter("variation_id");
        String squantity = request.getParameter("qty");
        String spid = request.getParameter("product_id");
        int variationId = Integer.parseInt(svid);
        int quantity = Integer.parseInt(squantity);
        int productId = Integer.parseInt(spid);
        Cart_item selected = cart_itemDAO.getByUserProduct(current.getUser_id(), variationId);
        if(selected != null){
            //if quantity selected > stock
            ProductDAO productDAO = new ProductDAO();
            ProductVariation pv = productDAO.getProductVariation(variationId);
            if((selected.getQuantity() + quantity) > pv.getQuantity()){
                msg = "Total quantity in cart must be smaller than stock quantity";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("product?action=details&product_id=" + productId + "&msg=" + msg)
                    .forward(request, response);
            }
            else{
            msg = "Added to cart";
            cart_itemDAO.updateQuantity(selected.getCart_item_id(), selected.getQuantity() + quantity);
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("product?action=details&product_id=" + productId + "&msg=" + msg)
                    .forward(request, response);
            }
        }
        
        //first time adding to cart
        if(selected == null){
            ProductDAO productDAO = new ProductDAO();
            ProductVariation pv = productDAO.getProductVariation(variationId);
            if((quantity) > pv.getQuantity()){
                msg = "Total quantity in cart must be smaller than stock quantity";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("product?action=details&product_id=" + productId + "&msg=" + msg)
                    .forward(request, response);
            }else{
            cart_itemDAO.addtocart(current.getUser_id(), variationId, quantity);
            msg = "Successfully added to cart";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("product?action=details&product_id=" + productId + "&msg=" + msg)
                    .forward(request, response);
            }
        }
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
