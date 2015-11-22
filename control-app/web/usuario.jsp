<%@page import="java.util.List"%>
<%@page import="modelo.UsuarioDAO"%>
<%@page import="modelo.Usuario"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp" %>
<%  if(perfilUser.equals("Atendente")){ response.sendRedirect("index.jsp"); } %>
<content select="">
    <section>
        <div class="sela">
            <%  UsuarioDAO dao = new UsuarioDAO();
                List<Usuario> us = dao.listarUsuario();
                if (us.size() > 0){
            %>
            <div class="tab">
                <table>
                    <caption class="h-form">
                        <h2>Usuarios</h2>
                        <div>
                            <a href="ControleServlet?logica=ExcluirTodosUsuario" class="h-form" onclick="return checa()"><i class="icon-bin"></i> </a>
                        </div>
                    </caption>
                    <thead class="h-form">
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Perfil</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%  for(Usuario ul : us){%>
                        <tr>
                            <td><%=ul.getId()%></td>
                            <td><%=ul.getNome()%></td>
                            <td>
                            <%  if(ul.getPerfil().equals("Administrador")){  %>
                                <i class="icon-user-admin"></i>
                            <%  } else {    %>
                                <i class="icon-user"></i>
                            <%  }   %> </td>
                            <td><a href="usuario.jsp?id=<%=ul.getId()%>" class="h-form"><i class="icon-pencil"></i></a></td>
                            <td><a href="ControleServlet?logica=ExcluirUsuario&id=<%=ul.getId()%>" class="h-form" onclick="return checa()"><i class="icon-user-minus"></i></a></td>
                        </tr>
                        <%  }}   %>
                    </tbody>
                </table>
            </div>
        <%  try {
                int id = Integer.parseInt(request.getParameter("id"));
                Usuario u  = dao.leUmUsuario(id);
                dao.desconectar();   %>
            <div class="wrap">
                <form action="ControleServlet" name="form_cad_user" method="get" class="formulario">
                    <h2 class="h-form">Alterar Usuario</h2>
                    <div>
                        <div class="input-group">
                            <input type="text" id="nome" name="nome" value="<%=u.getNome()%>"/>
                            <label for="nome" class="label active"><i class="icon-profile"></i> Nome</label>
                        </div>
                        <div class="input-group">
                            <input type="text" id="login" name="login" value="<%=u.getLogin()%>"/>
                            <label for="login" class="label active"><i class="icon-keyboard"></i> Login</label>
                        </div>
                        <div class="input-group">
                            <input type="password" id="senha1" name="senha1" value="<%=u.getSenha()%>"/>
                            <label for="senha1" class="label active"><i class="icon-key"></i> Senha</label>
                        </div>
                        <div class="input-group">
                            <input type="password" id="senha2" name="senha2" value="<%=u.getSenha()%>"/>
                            <label for="senha2" class="label active"><i class="icon-key"></i> Repita a Senha</label>
                        </div>
                        <div class="input-group radio">
                            
                            <input id="atendente" type="radio" name="perfil" value="Atendente" <% if(u.getPerfil().equals("Atendente")){ out.print("checked"); }%>/>
                            <label for="atendente"><i class="icon-user"></i> Atendente
                            </label>
                            <input id="administrador" type="radio" name="perfil" value="Administrador" <% if(u.getPerfil().equals("Administrador")){ out.print("checked"); }%>/>
                            <label for="administrador"><i class="icon-user-admin"></i> Adminstrador
                            </label>
                            <input type="hidden" name="logica" value="AlterarUsuario"/>
                            <input type="hidden" name="id" value="<%=id%>"/>
                        </div>
                        <div class="left">
                            <button><i class="icon-pencil"></i> Alterar</button>
                        </div>
                    </div>
                </form>
            </div>    
        <%  } catch(Exception e) {  %>
            <div class="wrap">
                <form action="ControleServlet" name="form_cad_user" method="get" class="formulario">
                    <h2 class="h-form">Adicionar Usuario</h2>
                    <div>
                        <div class="input-group">
                            <input type="text" id="nome" name="nome"/>
                            <label for="nome" class="label"><i class="icon-profile"></i> Nome</label>
                        </div>
                        <div class="input-group">
                            <input type="text" id="login" name="login"/>
                            <label for="login" class="label"><i class="icon-keyboard"></i> Login</label>
                        </div>
                        <div class="input-group">
                            <input type="password" id="senha1" name="senha1"/>
                            <label for="senha1" class="label"><i class="icon-key"></i> Senha</label>
                        </div>
                        <div class="input-group">
                            <input type="password" id="senha2" name="senha2"/>
                            <label for="senha2" class="label"><i class="icon-key"></i> Repita a Senha</label>
                        </div>
                        <div class="input-group radio">
                            <input id="atendente" type="radio" name="perfil" value="Atendente"/>
                            <label for="atendente"><i class="icon-user"></i> Atendente</label>
                            <input id="administrador" type="radio" name="perfil" value="Administrador"/>
                            <label for="administrador"><i class="icon-user-admin"></i> Adminstrador</label>
                            <input type="hidden" name="logica" value="AdicionarUsuario"/>
                        </div>
                        <div class="left">
                            <button><i class="icon-user-plus"></i> Adicionar</button>
                        </div>
                    </div>
                </form>
            </div>
            <%  }  %>
        </div>
    </section>
    <aside>
    </aside>
</content>
<footer>
    <h1 class="logo-mini">Control +</h1>
    <time></time>
</footer>
</main>
<script src="js/usuario.js"></script>
</body>
</html>