package servlet;

import API.barcod;
import API.checks;
import API.informations;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet extends HttpServlet {
    boolean valid = true;
    String result;
    String barCode;
    String shelfLife;
    String value; 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String digitableLine = request.getParameter("digitable").trim();
            
        if(digitableLine.length() == 47)  {
                valid = checks.numeric(digitableLine);
                if(valid) {
                    valid = checks.validMod10(digitableLine.substring(0, 32));
                    if(valid) {
                        barCode = barcod.doBar(digitableLine);
                        shelfLife = informations.shelflife(digitableLine.substring(33, 37));
                        value = informations.value(digitableLine.substring(37));
                        result = "Boleto válido!" + 
                                "</br>Valor do boleto: " + value +
                                "</br>Vencimento do boleto (fator): " + shelfLife +
                                "</br>Código de barras: " + barCode;
                    } else {
                        result = "Boleto inválido! </br>" + 
                            "Problemas na confirmação dos códigos de verificação do boleto.";
                    }
                } else {
                    result = "Boleto inválido! </br>" + 
                            "A sequencia digitada contém caracteres não numéricos.";
                }
            } else {
                result = "Desculpe! Digitos insuficientes. </br>" + 
                            "O sistema avalia linha digitável de 47 dígitos.";
        }      
        //RequestDispatcher rd = new RequestDispatcher();    
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>EASY BOLETO - BOLETO DECRIPTION</title>"); 
            out.println("<link rel='stylesheet' href='estilo.css' type='text/css'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>" + request.getContextPath() + "</h2>");
            out.println("<p>");out.println(result);
            out.println("</p>");
            out.println("</br>");
            out.println("</br>");
            out.println("<img src=\"img/man_thinking_numbers.jpg\" width=\"520\">");
            out.println("<br><a href='index.html'>SEND ME ANOTHER BOLETO</a>");
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
