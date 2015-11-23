

function ativo(x){

    var nota = document.getElementById(x);
    var estado = nota.getAttribute("class");

    if (estado == "tab estatico"){

        nota.setAttribute("class", "tab ativo");

    } else {

        nota.setAttribute("class", "tab estatico");

    }

}
function cont(id){
   var conteudo = document.getElementById(id).innerHTML;
   tela_impressao = window.open('about:blank');
   tela_impressao.document.write(conteudo);
   tela_impressao.window.print();
   tela_impressao.window.close();
}
