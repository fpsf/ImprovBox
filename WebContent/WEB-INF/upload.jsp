<%-- 
    Document   : upload
    Created on : 05/07/2018, 06:04:31
    Author     : swagmence
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="control.OPSBD" %>
<html>
    <head>
        <link rel="stylesheet" href="js/PastaScripts/jquery-ui-1.12.1.custom/jquery-ui.css"/>
        <script src="js/PastaScripts/jquery-3.3.1.js"></script>
        <script src="js/PastaScripts/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
        <script src="js/PastaScripts/acoes.js" charset="utf-8"></script>
        <link rel="stylesheet" href="css/visuais.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Segunda Avaliação</title>
    </head>
    <body id=upload>
        <form action="updel" method="post" enctype="multipart/form-data">
            <p>Poste um arquivo aqui:</p><br/>
            <input type="file" name="arquivo"/>
            <button class=margem type='submit'>
            	Enviar
            </button>
        </form>
    </body>
</html>
