<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='estilo.css' type='text/css'/>
        <title>EASY BOLETO</title>
    </head>
    <body>
        <%
            String status = (String) request.getAttribute("status");
            String value = (String) request.getAttribute("value");
            String shelf = (String) request.getAttribute("shelf");
            String bar = (String) request.getAttribute("bar");
            String details = "";
            if(!"Boleto inválido".equals(status.substring(0,15))) {
                details = status + 
                            "</br>Valor do boleto: " + value +
                            "</br>Vencimento do boleto: " + shelf +
                            "</br>Código de barras: " + bar;
            }
        %>
        <h2>/EasyBoleto</h2>
        <h3><%=status%></h3>
        <p><%=details%></p>
        <a href='index.html'>SEND ME ANOTHER BOLETO</a>
        <img src="img/man_thinking_numbers.jpg" width="520">
    </body>
</html>
