package servlet;

import API.barcod;
import API.checks;
import API.informations;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
            
        switch (digitableLine.length()) {
            case 47:
                valid = checks.numeric(digitableLine);
                if(valid) {
                    valid = checks.validMod10(digitableLine.substring(0, 32));
                    if(valid) {
                        barCode = barcod.doBar(digitableLine);
                        shelfLife = informations.shelflife(digitableLine.substring(33, 37));
                        value = informations.value(digitableLine.substring(37));
                        result = "Boleto válido! Título bancário.";
                    } else {
                        result = "Boleto inválido (título bancário)! </br>" +
                                "Problemas na confirmação dos códigos de verificação do boleto.";
                    }
                } else {
                    result = "Boleto inválido (título bancário)! </br>" + 
                            "A sequencia digitada contém caracteres não numéricos.";
                }
                break;
            case 48:
                valid = checks.numeric(digitableLine);
                if(valid) {
                    valid = checks.validMod10con(digitableLine);
                    if(valid) {
                        barCode = barcod.doBarCon(digitableLine);
                        shelfLife = "infelizmente, não foi possível determinar o vencimento";
                        value = informations.valueCon(barCode.substring(4,15));
                        result = "Boleto válido! Pagamento de concenssionária.";
                    } else {
                        result = "Boleto inválido (pagamento de concessionaria)! </br>" +
                                "Problemas na confirmação dos códigos de verificação do boleto.";
                    }
                } else {
                    result = "Boleto inválido (pagamento de concessionaria)! </br>" + 
                            "A sequencia digitada contém caracteres não numéricos.";
                }
                break;
            default:
                result = "Boleto inválido, desculpe! Digitos insuficientes. </br>" +
                            "O sistema avalia linha digitável de 47 dígitos (títulos bancários) </br>" +
                            "ou 48 dígitos (pagamento de concessionárias).";
                break;
        }
        request.setAttribute("status", result);
        request.setAttribute("value", value);
        request.setAttribute("shelf", shelfLife);
        request.setAttribute("bar", barCode);

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("jsp/description.jsp");
        rd.forward(request, response);
        
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
