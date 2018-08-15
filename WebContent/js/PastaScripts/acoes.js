/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var adm = new Object();
adm.nome = "admin";
adm.senha = "admin";

$(document).ready(function() {
    if(document.location.href.substr(21) === "/ImprovBox/"){
    	document.getElementById("index").addEventListener("mouseover", alert("Página de Login."));
    }
    if(document.location.href.substr(21) === "/ImprovBox/redirecao"){
    	document.getElementById("updownload").addEventListener("mouseover", alert("Página de Navegação."));
    	criarBotoes();
    }
    if(document.location.href.substr(21) === "/ImprovBox/updel"){
    	document.getElementById("updownload").addEventListener("mouseover", alert("Página de Navegação."));
    	criarBotoes();
    }
    if(document.location.href.substr(21) === "/ImprovBox/redirecao?del_redir=deletar"){
    	document.getElementById("deletar").addEventListener("mouseover", alert("Página de Exclusão."));
    }
    if(document.location.href.substr(21) === "/ImprovBox/redirecao?down_redir=download"){
    	document.getElementById("download").addEventListener("mouseover", alert("Página de Download."));
    }
    if(document.location.href.substr(21) === "/ImprovBox/redirecao?up_redir=upload"){
    	document.getElementById("upload").addEventListener("mouseover", alert("Página de Envio."));
    }
});

function criarBotoes(){
	
	var up = document.createElement("BUTTON");
	var text = document.createTextNode("Upload");
	up.appendChild(text);
	up.setAttribute('type', 'submit');
	up.setAttribute('name', 'up_redir');
	up.setAttribute('value', 'upload');
	document.getElementById("navform").appendChild(up);
	
	up = document.createElement("BUTTON");
	text = document.createTextNode("Download");
	up.appendChild(text);
	up.setAttribute('type', 'submit');
	up.setAttribute('name', 'down_redir');
	up.setAttribute('value', 'download');
	document.getElementById("navform").appendChild(up);
	
	up = document.createElement("BUTTON");
	text = document.createTextNode("Deletar");
	up.appendChild(text);
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
    	var xreq = new XMLHttpRequest();
    	
        xreq.open("GET", 'http://localhost:8080/ImprovBox/getusuario', false);
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
    	    	window.location.replace("http://localhost:8080/ImprovBox/redirecao");
    	    	// document.location.href = "/ImprovBox/redirecao";
    	    	return false;
    	    }
        }
	    if ((usuario === adm.nome) && (senha === adm.senha)){
	    	window.location.replace("http://localhost:8080/ImprovBox/redirecao");
	    	// document.location.href = "/ImprovBox/redirecao";
	    }
	    else{
	        alert("Utilize o login de teste!");
	        window.location.replace("http://localhost:8080/ImprovBox/");
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