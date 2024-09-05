/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.email;

import murach.bussiness.User;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

/**
 *
 * @author DELL
 */
public class EmailListServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.html";
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }
        if (action.equals("join")) {
            url = "/index.html";
        } else if (action.equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String birthDate = request.getParameter("birthDate");
            User user = new User(firstName, lastName, email, birthDate);
            request.setAttribute("user", user);
            String hear = request.getParameter("hear");
            request.setAttribute("hear", hear);
            String mess="";
            String[] selectedValue = request.getParameterValues("value");
            for (String value : selectedValue) {
                   if ("like".equals(value)) {
                    mess += "Yes, I'd like that ";
                } else if ("send".equals(value)) {
                    mess += "Yes, please send me the email announcement";
                }
            }
            request.setAttribute("value", mess);

            String contactMethod = request.getParameter("contact");

            // Kiểm tra giá trị đã nhận được và xử lý tương ứng
            String message;
            if (contactMethod != null) {
                switch (contactMethod) {
                    case "email_postal":
                        message = "Email or postal";
                        break;
                    case "email":
                        message = "Email only";
                        break;
                    case "postal":
                        message = "Postal only";
                        break;
                    default:
                        message = "Unknown contact method selected";
                        break;
                }
            } else {
                message = "No contact method selected";
            }
            

            // Gán message vào request attribute để gửi tới JSP
            request.setAttribute("contact", message);
            url = "/thanks.jsp";

        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
