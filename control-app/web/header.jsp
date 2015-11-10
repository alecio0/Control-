<%@page import="modelo.Usuario"%>
<%
    int idUser;
    String perfilUser;
    try{
        Usuario user = (Usuario)session.getAttribute("user");
            idUser = user.getId();
            perfilUser = user.getPerfil();   %>
                   
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8"/>
    <title>Control+</title>
    <link rel="stylesheet" href="estilos/main.css"/>
    <link rel="stylesheet" href="estilos/icomoon/style.css"/>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
  </head>
  <body>
    <main>
      <header>
        <div>
          <h1 class="logo">logo</h1>
          <hgroup class="user">
            <h3 class="user"><%=user.getPerfil()%>:</h3>
            <h2 class="user"><%=user.getNome()%></h2>
          </hgroup>
        </div>
        <nav class="menu-pri">           
          <ul>
            <li><a href="index.jsp"><i class="icon-home"></i> Inicio</a></li>
            <li><a href="pedidos.jsp"><i class="icon-cart"></i> Pedidos</a></li>
            <li><a href="clientes.jsp"><i class="icon-address-book"></i> Clientes</a></li>
            <li><a href="produtos.jsp"><i class="icon-"></i> Produtos</a></li>
            <%  if(user.getPerfil().equals("Administrador")){   %>
            
            <li><a href="usuario.jsp"><i class="icon-user"></i> Usuario</a></li>
            <li><a href="relatorio.jsp"><i class="icon-stats"></i> Relatorio</a></li>
            <li><a href="empresa.jsp"><i class="icon-office"></i> Empresa</a></li>
            
            <%  }   %>
          </ul><a href="ControleServlet?logica=Logoff"><i class="icon-exit"></i> Sair</a>
        </nav>
      </header>
            
<%  } catch (Exception e) {
        response.sendRedirect("login.jsp");
    }
%>

