

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
   tela_impressao = window.open('boleto.jsp?id='+id);
   tela_impressao.window.print();
//   tela_impressao.window.close();
}

