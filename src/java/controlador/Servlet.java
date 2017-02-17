/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dato.Activo;
import servicios.BD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.Servicios;

/**
 *
 * @author Isabel-Fabian
 */
public class Servlet extends HttpServlet {

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
            String txtActivo = request.getParameter("activo");
            if(txtActivo==null || txtActivo.length()==0){
               request.setAttribute("Mensaje", "No se pudo insertar satisfactoriamente");
            }else{
                try {
                   Activo activo = new Activo(txtActivo);
                   Servicios servicio = new Servicios();
                   boolean resultado = servicio.escribir(activo);
                   if(resultado == true){
                      request.setAttribute("Mensaje", "Se ha realizado la insercion satisfactoriamente");
                   }else{
                      request.setAttribute("Mensaje", "No se pudo insertar satisfactoriamente");
                   }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("Mensaje", "Problemas para listar los activos");
                }
            }
            
            RequestDispatcher dispacher = request.getRequestDispatcher("index.jsp");
            dispacher.forward(request, response);
                   
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
        processRequest(request, response);
                          
        
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
        processRequest(request, response);
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
