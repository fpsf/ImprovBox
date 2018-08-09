<%-- 
    Document   : download
    Created on : 05/07/2018, 06:04:41
    Author     : swagmence
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="control.OPSBD" %>
<%
   		try{
   			OPSBD ops = new OPSBD();
			ops.recuperar(1);
			pageContext.setAttribute("nomearq", ops.arqtst.getNome());
   		}
   		catch (Exception e){
   			pageContext.setAttribute("nomearq", "Sem arquivo. Tente postar um.");
   		}
    	
   	%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="js/PastaScripts/jquery-ui-1.12.1.custom/jquery-ui.css"/>
        <script src="js/PastaScripts/jquery-3.3.1.js"></script>
        <script src="js/PastaScripts/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
        <script src="js/PastaScripts/acoes.js"></script>
        <link rel="stylesheet" href="css/visuais.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Segunda Avaliação</title>
    </head>
    <body id=download title="Página de Download">
    	<p>Este botão faz o download do arquivo:</p>
        <form action="redirdown" method="get">
        	<p>Nome do arquivo: </p>
    		<p><%= pageContext.getAttribute("nomearq") %></p>
        	<button type="submit">
        		Arquivo
        	</button>
        </form>
        
    </body>
</html>
