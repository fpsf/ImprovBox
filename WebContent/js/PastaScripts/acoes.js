/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var usr = new Object();
usr.nome = "admin";
usr.senha = "admin";

$(document).ready(function() {
    //alert("Bem vindo à aplicação");
    if(document.location.href.substr(21) === "/ImprovBox/"){
        $('#index').mouseover($('#index').tooltip());
    }
    if(document.location.href.substr(21) === "/ImprovBox/updownload.html"){
        $('#deletar').mouseover($('#deletar').tooltip());
    }
    if(document.location.href.substr(21) === "/ImprovBox/download.html"){
        $('#download').mouseover($('#download').tooltip());
    }
    if(document.location.href.substr(21) === "/ImprovBox/upload.html"){
        $('#upload').mouseover($('#upload').tooltip());
    }
});

function validarArquivo(){
    var arquivo = document.getElementById("arquivo").value;
    if (arquivo === ''){
        alert('Escolha um Arquivo!');
        return false;
    }
    var upar = arquivo.replace("C:\\fakepath\\", "");
    // "C:\\fakepath\\inxi"
    alert("Arquivo Upado: " + upar);
    return false;
    
}