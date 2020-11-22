/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class AddtoCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html"); 
        response.setHeader("pragma", "no-cache");
        PrintWriter out = response.getWriter();  

        HttpSession session=request.getSession(false); 
        
        ArrayList<String> cartItems = new ArrayList<String>();
        try{
            cartItems=(ArrayList<String>) session.getAttribute("formData");
        }
        catch(NullPointerException nullPointer){
            response.sendRedirect("emptyCart");
        }

        out.print("<HTML><HEAD><TITLE>Cart Details</TITLE></HEAD><BODY>");
        out.println("<H1>Your Cart details here...</H1>");
        out.print("<H3>You have ");
        out.print(cartItems.size());
        out.print(" items in your cart</H3>");

        for (String i : cartItems){
            out.print(i);
            out.print("</BR>");
        }
        out.println("<BR><FORM METHOD=POST>"); 
        out.println("<BR><INPUT TYPE=SUBMIT " + "NAME=update VALUE= \"Update Your Cart\">"); 
        out.println("<BR><INPUT TYPE=SUBMIT " + "NAME=buy VALUE=\"Continue to buy\">"); 
        out.println("<BR>");
        out.println("</FORM>");
        out.println("</BODY>");
        out.println("</HTML>");
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
        
        String msg;
        if(request.getParameter("update") != null)
        {
          response.sendRedirect("AvailableItems");
        }
        else
        {
            HttpSession session = request.getSession(true);
            ArrayList<String> cartItems=(ArrayList<String>) session.getAttribute("formData");
            msg = "Wow! You have successfully bought "+ cartItems.size()+". Now your cart is empty.";
            session.invalidate();
            
            PrintWriter out = response.getWriter();
            out.println("<H1>Successfully Paid!</H1>");
            out.print(msg);
            out.print("<HR><A HREF=\"");
            out.print("cartDetails");
            out.print("\">Back to My cart</A>");
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
    }}