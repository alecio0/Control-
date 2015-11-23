<%@page import="java.sql.Connection"%>
<%@page import="modelo.Conexao"%>
<%@page import="modelo.Cliente"%>
<%@page import="modelo.ClienteDAO"%>
<%@page import="modelo.Cidade"%>
<%@page import="java.util.List"%>
<%@page import="modelo.CidadeDAO"%>
<%@include file="header.jsp" %>
<content select="">
    <section>
        <div class="sela">
            <div class="tab">
        <%        Connection conn = new Conexao().trazConexao();
            try{
                int x = Integer.parseInt(request.getParameter("x"));
                String pesqTel = request.getParameter("pesqTel");
                ClienteDAO daoCliP = new ClienteDAO(conn);
                List<Cliente> clis = daoCliP.pesqCliente(pesqTel);
                if(clis.size() > 0){%>
                <table>
                    <caption class="h-form">
                        <h2>Clientes</h2>
                        <div>
                            <span><%=clis.size()%></span>
                            <a href="ControleServlet?logica=ExcluirTodosCliente" class="h-form" onclick="return checa()"><i class="icon-bin"></i> </a>
                        </div>
                    </caption>
                    <thead class="h-form">
                        <tr>
                            <th></th>
                            <th>Nome</th>
                            <th>Telefone</th>
                            <th>Endereço</th>
                            <th>Cidade</th>
                        </tr>
                    </thead>
                    <tbody>
                <%  for(Cliente cli : clis) {   %>
                    <tr id="cli<%=cli.getId()%>">
                        <td><a href="ControleServlet?logica=IniciarPedido&idCli=<%=cli.getId()%>" class="h-form" onclick="return checa()"><i class="icon-cart"></i></a></td>
                        <td><%=cli.getNome()%></td>
                        <td><%=cli.getTelefone()%></td>
                        <td><%=cli.getEndereco()%></td>
                        <td><%=cli.getCidade().getNome()%></td>
                        <td><a href="clientes.jsp?idC=<%=cli.getId()%>&nome=<%=cli.getNome()%>&telefone=<%=cli.getTelefone()%>&endereco=<%=cli.getEndereco()%>&idCit=<%=cli.getCidade().getId()%>" class="h-form"><i class="icon-pencil"></i></a></td>
                        <td><a href="ControleServlet?logica=ExcluirCliente&id=<%=cli.getId()%>" class="h-form" onclick="return checa()"><i class="icon-user-minus"></i></a></td>
                    </tr>
                <%  }   %>
                    </tbody>
                </table>
            <%  }   %>
            <%  } catch(Exception e){ %>
            <%  ClienteDAO daoCli = new ClienteDAO(conn);
                List<Cliente> clis = daoCli.listarCliente();
                if(clis.size() > 0){%>
                <table>
                    <caption class="h-form">
                        <h2>Clientes</h2>
                        <div>
                            <span><%=clis.size()%></span>
                            <a href="ControleServlet?logica=ExcluirTodosCliente" class="h-form" onclick="return checa()"><i class="icon-bin"></i> </a>
                        </div>
                    </caption>
                    <thead class="h-form">
                        <tr>
                            <th></th>
                            <th>Nome</th>
                            <th>Telefone</th>
                            <th>Endereço</th>
                            <th>Cidade</th>
                        </tr>
                    </thead>
                    <tbody>
                <%  for(Cliente cli : clis) {   %>
                    <tr id="cli<%=cli.getId()%>">
                        <td><a href="ControleServlet?logica=IniciarPedido&idCli=<%=cli.getId()%>" class="h-form" onclick="return checa()"><i class="icon-cart"></i></a></td>
                        <td><%=cli.getNome()%></td>
                        <td><%=cli.getTelefone()%></td>
                        <td><%=cli.getEndereco()%></td>
                        <td><%=cli.getCidade().getNome()%></td>
                        <td><a href="clientes.jsp?idC=<%=cli.getId()%>&nome=<%=cli.getNome()%>&telefone=<%=cli.getTelefone()%>&endereco=<%=cli.getEndereco()%>&idCit=<%=cli.getCidade().getId()%>" class="h-form"><i class="icon-pencil"></i></a></td>
                        <td><a href="ControleServlet?logica=ExcluirCliente&id=<%=cli.getId()%>" class="h-form" onclick="return checa()"><i class="icon-user-minus"></i></a></td>
                    </tr>
                <%  }   %>
                    </tbody>
                </table>
            <%  }   %>
            <%  }   %>
            </div>
            <div class="form-conj">
                <div class="wrap">
                <%  try {
                            int  idC = Integer.parseInt(request.getParameter("idC"));
                            String nome = request.getParameter("nome");
                            String telefone = request.getParameter("telefone");
                            String endereco = request.getParameter("endereco");
                            int  idCit = Integer.parseInt(request.getParameter("idCit"));    %>
                    <form action="ControleServlet" name="form_cad_cli" class="formulario">
                        <h2 class="h-form">Alterar Cliente</h2>
                        <div>
                            <div class="input-group">
                                <input type="text" id="nome" name="nome" value="<%=nome%>"/>
                                <label for="nome" class="label active"><i class="icon-profile"></i> Nome</label>
                            </div>
                            <div class="input-group">
                                <input type="tel" id="telefone" name="telefone" value="<%=telefone%>"/>
                                <label for="telefone" class="label active"><i class="icon-phone"></i> Telefone</label>
                            </div>
                            <div class="input-group">
                                <input type="text" id="endereco" name="endereco" value="<%=endereco%>"/>
                                <label for="endereco" class="label active"><i class="icon-location"></i> Endereço</label>
                            </div>
                            <div class="input-group radio">
                                <h3 class="h-form">Cidade / Bairro</h3>
                            <%  CidadeDAO daoCit = new CidadeDAO(conn);
                                List<Cidade> cits = daoCit.listarCidade();
                                for(Cidade cit : cits){ %>
                                <input type="radio" name="cidade" id="<%=cit.getNome()%>" value="<%=cit.getId()%>" <%   if(cit.getId() == idCit){  out.print("checked");   }   %>/>
                                <label for="<%=cit.getNome()%>"><%=cit.getNome()%></label>
                            <%  }   %>
                            </div>
                                <input type="hidden" name=id value="<%=idC%>"/>
                                <input type="hidden" name="logica" value="AlterarCliente"/>
                            <div class="left">
                                <button><i class="icon-pencil"></i> Alterar</button>
                            </div>
                        </div>
                    </form>
                <%  } catch (Exception e) { %>
                    <form action="ControleServlet" name="form_cad_cli" class="formulario">
                        <h2 class="h-form">Novo Cliente</h2>
                        <div>
                            <div class="input-group">
                                <input type="text" id="nome" name="nome"/>
                                <label for="nome" class="label"><i class="icon-profile"></i> Nome</label>
                            </div>
                            <div class="input-group">
                                <input type="tel" id="telefone" name="telefone"/>
                                <label for="telefone" class="label"><i class="icon-phone"></i> Telefone</label>
                            </div>
                            <div class="input-group">
                                <input type="text" id="endereco" name="endereco"/>
                                <label for="endereco" class="label"><i class="icon-location"></i> Endereço</label>
                            </div>
                            <div class="input-group radio">
                                <h3 class="h-form">Cidade / Bairro</h3>
                            <%  CidadeDAO dao = new CidadeDAO(conn);
                                List<Cidade> cs = dao.listarCidade();
                                for(Cidade c : cs){ %>
                                <input type="radio" name="cidade" id="<%=c.getNome()%>" value="<%=c.getId()%>"/>
                                <label for="<%=c.getNome()%>"><%=c.getNome()%></label>
                            <%  }   %>
                            </div>
                                <input type="hidden" name="logica" value="AdicionarCliente"/>
                            <div class="left">
                                <button><i class="icon-user-plus"></i> Adicionar</button>
                            </div>
                        </div>
                    </form>
                <%  }   conn.close();   %>
                </div>
                <div class="wrap">
                    <form action="clientes.jsp" name="form_pesq_cli" class="formulario">
                        <h2 class="h-form">Pesquisar Clientes</h2>
                        <div>
                            <div class="input-group">
                                <input type="tel" id="telefonep" name="pesqTel"/>
                                <label for="telefonep" class="label"><i class="icon-phone"></i> Telefone</label>
                                <input type="hidden" name="x" value="1"/>
                            </div>
                        </div>
                        <div class="left">
                            <button><i class="icon-search"></i> Pesquisar</button>
                        </div>
                    </form>
                </div>
            </div>
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
<script src="js/cliente.js"></script>
</body>
</html>