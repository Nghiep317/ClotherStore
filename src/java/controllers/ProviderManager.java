/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import DAO.ProviderDAO;
import Models.Provider;
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
public class ProviderManager extends HttpServlet {

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
            out.println("<title>Servlet ProviderManager</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProviderManager at " + request.getContextPath() + "</h1>");
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
        // Create a ProviderDAO object
        ProviderDAO providerDAO = new ProviderDAO();
        
        // Get all providers and set them as request attribute
        List<Provider> providers = providerDAO.getAllProviders();
        request.setAttribute("providers", providers);
        
        // Forward request to JSP
        request.getRequestDispatcher("admin/providerManager.jsp").forward(request, response);
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
        ProviderDAO providerDAO = new ProviderDAO();

        String action = request.getParameter("action");

        if (action == null) {
            response.sendRedirect(request.getContextPath() + "/providermanager");
            return;
        }

        switch (action) {
            case "add":
                addProvider(request, providerDAO);
                break;
            case "update":
                updateProvider(request, providerDAO);
                break;
            case "delete":
                deleteProvider(request, providerDAO);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/providermanager");
        }

        // Redirect to doGet to refresh the page with updated data
        response.sendRedirect(request.getContextPath() + "/providermanager");
    }
    private void addProvider(HttpServletRequest request, ProviderDAO providerDAO) {
        String companyName = request.getParameter("companyName");

        Provider newProvider = new Provider();
        newProvider.setCompanyName(companyName);

        providerDAO.addProvider(newProvider);
    }

    private void updateProvider(HttpServletRequest request, ProviderDAO providerDAO) {
        int providerId = Integer.parseInt(request.getParameter("providerId"));
        String companyName = request.getParameter("companyName");

        Provider updatedProvider = new Provider();
        updatedProvider.setProviderId(providerId);
        updatedProvider.setCompanyName(companyName);

        providerDAO.updateProvider(updatedProvider);
    }

    private void deleteProvider(HttpServletRequest request, ProviderDAO providerDAO) {
        int providerId = Integer.parseInt(request.getParameter("providerId"));
        providerDAO.deleteProvider(providerId);
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
