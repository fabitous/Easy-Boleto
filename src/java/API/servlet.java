package API;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Integer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String result = "";
        String iboleto = request.getParameter("boleto");
        request.setAttribute("iboleto",iboleto);
        boolean valido = true;
        int mod10 = 0;
        int mod11 = 0;
        int facMod10 = 1;
        int facMod11 = 1;
        int posCV = 0;       
        
        String vencYear; 
        String vencM;
        String vencDay;
        String value;
        String valueCents;
        
        if(iboleto.length() == 48)  {
                posCV = 3;
                for(int point = 0; point < iboleto.length(); point++) {
                    int num10;
                    String number10;
                    if(point != posCV || point != 11 || point != 23 || point != 35 || point != 47) {
                        if(facMod10 == 1) {
                            facMod10 = 2;
                        } else {
                            facMod10 = 1;
                        }
                        number10 = String.valueOf(iboleto.charAt(point)); 
                        if("0".equals(number10) || 
                                "1".equals(number10) || 
                                    "2".equals(number10) || 
                                        "3".equals(number10) || 
                                            "4".equals(number10) || 
                                                "5".equals(number10) ||
                                                    "6".equals(number10) || 
                                                        "7".equals(number10) || 
                                                            "8".equals(number10) || 
                                                                "9".equals(number10)) {
                            num10 = Integer.parseInt(number10);
                            num10 = num10*facMod10;
                            if(num10 >= 10) {
                                mod10 = mod10 + num10%10;
                                mod10 = mod10 + num10/10;
                            } else {
                                mod10 = mod10 + num10;
                            }
                        } else {
                            valido = false;
                        }

                    }
                }
                mod10 = mod10%10;
                if(mod10 != 0) {
                    mod10 = 10-mod10;                    
                }
                for(int point = iboleto.length() - 1; point >= 0; point--) {
                    int num11;
                    String number11;
                    if(facMod11 == 9) {
                        facMod11 = 1;
                    }
                    if(point != posCV || point != 11 || point != 23 || point != 35 || point != 47) {
                        facMod11++;              
                        number11 = String.valueOf(iboleto.charAt(point)); 
                        if("0".equals(number11) || 
                                "1".equals(number11) || 
                                    "2".equals(number11) || 
                                        "3".equals(number11) || 
                                            "4".equals(number11) || 
                                                "5".equals(number11) ||
                                                    "6".equals(number11) || 
                                                        "7".equals(number11) || 
                                                            "8".equals(number11) || 
                                                                "9".equals(number11)) {
                            num11 = Integer.parseInt(number11);
                            num11 = num11*facMod11;
                            mod11 = mod11 + num11;                        
                        } else {
                            valido = false;
                        }
                    } else {
                        facMod11 = 1;
                    }
                }
                mod11 = mod11%11;
                if(mod11 == 1) {
                    mod11 = 0;
                }
                if(mod11 == 10) {
                    mod11 = 1;
                }
                if((!String.valueOf(mod10).equals(String.valueOf(iboleto.charAt(posCV))) && 
                            !String.valueOf(mod11).equals(String.valueOf(iboleto.charAt(posCV))))||(!valido)) {
                    result = "Boleto inválido! Código de verificação incompatível e/ou contém caracrete não numérico";
                } else {
                    vencYear = iboleto.substring(41, 43);
                    vencM = iboleto.substring(43, 45);
                    vencDay = iboleto.substring(45, 47);
                    value = iboleto.substring(5, 14);
                    valueCents = iboleto.substring(14, 16);
                    result = "Boleto válido!" + 
                                "</br>CV módulo 10: " + mod10 +
                                "</br>CV módulo 11: " + mod11 +
                                "</br>Valor do boleto: " + value + ","  + valueCents +
                                "</br>Vencimento do boleto: " + vencDay + "/" + vencM + "/20" + vencYear +
                                "</br>Número: " + iboleto;
                }
            } else {
                result = "Desculpe! </br> O sistema avalia números com 48 dígitos relativo ao código de barra" +
                            " mais os códigos de verificação";
        }
           
        //RequestDispatcher rd = new RequestDispatcher();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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
