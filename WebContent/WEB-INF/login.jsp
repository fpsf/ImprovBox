<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.io.IOException" %>

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

    <body id=index>
    	<h1>Login:</h1><br/>
        <label for="usuario">Usuário:</label><br/>
        <input class=margem name=nome id=usuario type="text" required/><br/>
        <label for="senha">Senha:</label><br/>
        <input class=margem name=senha id=senha type="password" required/><br/>
        <button class=margem onclick="validarLogin()" >Entrar</button>
        <br/>
        <p>Não possui um usuário? Crie um.</p>
        <p>Para cadastrar um usuário, utilize o botão abaixo:</p>
        <form action=redircadastro method=get>
    		<input class=margem type='submit'/>
    	</form>
    </body>
</html>
