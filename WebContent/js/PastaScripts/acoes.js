/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var adm = new Object();
adm.nome = "admin";
adm.senha = "admin";

$(document).ready(function() {
	// alert(window.location.pathname);
    if(window.location.pathname === "/ImprovBox/"){
    	document.getElementById("index").onmouseover = alert("Página de Login."); // .addEventListener("mouseover", alert("Página de Login."));
    }
    if(window.location.pathname === "/ImprovBox/redirecao"){
    	document.getElementById("updownload").addEventListener("mouseover", alert("Página de Navegação."));
    	criarBotoes();
    }
    if(window.location.pathname === "/ImprovBox/redircadastro"){
    	document.getElementById("index").onmouseover = alert("Página de Login."); // .addEventListener("mouseover", alert("Página de Login."));
    }
    if(window.location.pathname === "/ImprovBox/updel"){
    	document.getElementById("updownload").addEventListener("mouseover", alert("Página de Navegação."));
    	criarBotoes();
    }
    if(window.location.pathname === "/ImprovBox/redirdown"){
    	document.getElementById("updownload").addEventListener("mouseover", alert("Página de Navegação."));
    	criarBotoes();
    }
    /*
    if(window.location.pathname === "/ImprovBox/redirecao?del_redir=deletar"){
    	document.getElementById("deletar").addEventListener("mouseover", alert("Página de Exclusão."));
    }
    if(window.location.pathname === "/ImprovBox/redirecao?down_redir=download"){
    	document.getElementById("download").addEventListener("mouseover", alert("Página de Download."));
    }
    if(window.location.pathname === "/ImprovBox/redirecao?up_redir=upload"){
    	document.getElementById("upload").addEventListener("mouseover", alert("Página de Envio."));
    }
    */
});

/*
$('#upinput').on('change', function(){
	var up = document.createElement("BUTTON");
	var text = document.createTextNode("Enviar");
	up.appendChild(text);
	up.setAttribute('class', 'margem');
	up.setAttribute('type', 'submit');
	document.getElementById("upform").appendChild(up);
});
*/

function revelarBotao(){
	var up = document.createElement("BUTTON");
	var text = document.createTextNode("Enviar");
	up.appendChild(text);
	up.setAttribute('class', 'margem');
	up.setAttribute('type', 'submit');
	document.getElementById("upform").appendChild(up);
}

function criarBotoes(){
	
	var up = document.createElement("BUTTON");
	var text = document.createTextNode("Upload");
	up.appendChild(text);
	up.setAttribute('class', 'margem');
	up.setAttribute('type', 'submit');
	up.setAttribute('name', 'up_redir');
	up.setAttribute('value', 'upload');
	document.getElementById("navform").appendChild(up);
	
	up = document.createElement("BUTTON");
	text = document.createTextNode("Download");
	up.appendChild(text);
	up.setAttribute('class', 'margem');
	up.setAttribute('type', 'submit');
	up.setAttribute('name', 'down_redir');
	up.setAttribute('value', 'download');
	document.getElementById("navform").appendChild(up);
	
	up = document.createElement("BUTTON");
	text = document.createTextNode("Deletar");
	up.appendChild(text);
	up.setAttribute('class', 'margem');
	up.setAttribute('type', 'submit');
	up.setAttribute('name', 'del_redir');
	up.setAttribute('value', 'deletar');
	document.getElementById("navform").appendChild(up);
	
}

var usr;

function validarLogin(){
    var usuario = document.getElementById("usuario").value;
    var senha = document.getElementById("senha").value;
    var res = "";
    function comecaValidacao(){
    	if(window.location.pathname === "/ImprovBox/redircadastro"){
    		window.history.replaceState({}, document.title,
    				window.location.toString().substring(0, window.location.toString().indexOf("redircadastro")));
    	}
    	var xreq = new XMLHttpRequest();
    	
        xreq.open("GET", window.location.href + 'getusuario', false);
        xreq.onreadystatechange = function (){
        	if (xreq.readyState === 4){
        		if (xreq.status === 200 || xreq.status === 0){
        			res = xreq.responseText;
        		}
        	}
        }
        xreq.send(null);
        if (res !== ""){
        	usr = JSON.parse(res);
        	if ((usuario === usr.nome) && (senha === usr.senha)){
    	    	window.location.replace(window.location.href + "redirecao");
    	    	// document.location.href = "/ImprovBox/redirecao";
    	    	return false;
    	    }
        }
	    if ((usuario === adm.nome) && (senha === adm.senha)){
	    	window.location.replace(window.location.href + "redirecao");
	    	// document.location.href = "/ImprovBox/redirecao";
	    }
	    else{
	        alert("Utilize o login de teste!");
	        // window.location.replace(window.location.href);
	        // document.location.href = "/ImprovBox/";
	    }
    }
    comecaValidacao();
}

function validarArquivo(){
    var arquivo = document.getElementById("arquivo").value;
    if (arquivo === ''){
        alert('Escolha um Arquivo!');
    }
    var upar = arquivo.replace("C:\\fakepath\\", "");
    // "C:\\fakepath\\inxi"
    alert("Arquivo Upado: " + upar);
    
}