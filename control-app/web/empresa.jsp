<%@page import="modelo.Cidade"%>
<%@page import="java.util.List"%>
<%@page import="modelo.CidadeDAO"%>
<%@include file="header.jsp" %>
<%  if(perfilUser.equals("Atendente")){ response.sendRedirect("index.jsp"); } %>
<content select="">
    <section>
        <div class="sela">
            <%  CidadeDAO daoC = new CidadeDAO();
                List<Cidade> cs = daoC.listarCidade();
                if (cs.size() > 0) {    %>
            <div class="tab">
                <div class="tabela">
                    <table>
                        <caption class="h-form">
                            <h2>Cidade</h2>
                            <div><a href="ControleServlet?logica=ExcluirCidades" class="h-form"><i class="icon-bin"></i> </a>
                            </div>
                        </caption>
                        <thead class="h-form">
                            <tr>
                                <th>Nome</th>
                                <th>Tacxa</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%  for(Cidade c : cs) {    %>
                            <tr>
                                <td><%=c.getNome()%></td>
                                <td>R$ <%=c.getTaxa()%></td>
                                <td><a href="empresa.jsp?idC=<%=c.getId()%>&nomeC=<%=c.getNome()%>&taxaC=<%=c.getTaxa()%>" class="h-form"><i class="icon-pencil"></i> </a>
                                </td>
                                <td><a href="ControleServlet?logica=ExcluirCidade&id=<%=c.getId()%>" class="h-form"><i class="icon-bin"></i> </a>
                                </td>
                            </tr>
                            <%  }   %>
                        </tbody>
                    </table>
                </div>
            </div>
            <%  }   %>
            <div class="form-conj">
                <div class="wrap">
                    <form action="ControleServlet" name="form_emp" method="get" class="formulario">
                        <h2 class="h-form">Dados da Empresa</h2>
                        <div>
                            <div class="input-group">
                                <input type="text" id="nome" name="nome" value="<%=nomeEmp%>"/>
                                <label for="nome" class="label active">Nome</label>
                            </div>
                            <div class="input-group">
                                <input type="text" id="endereco" name="endereco" value="<%=enderecoEmp%>"/>
                                <label for="endereco" class="label active">Endereco</label>
                            </div>
                            <div class="input-group">
                                <input type="tel" id="telefone" name="telefone" value="<%=telefoneEmp%>"/>
                                <label for="telefone" class="label active">Telefone</label>
                            </div>
                            <div class="input-group">
                                <input type="email" id="email" name="email" value="<%=emailEmp%>"/>
                                <label for="email" class="label active">Email</label>
                            </div>
                            <input type="hidden" name="logica" value="AlterarEmpresa"/>
                            <div class="left">
                                <button><i class="icon-pencil"></i> Alterar
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="wrap">
            <%  try{
                    int idC = Integer.parseInt(request.getParameter("idC"));
                    String nomeC = request.getParameter("nomeC");
                    String taxaC = request.getParameter("taxaC");   %>
                    <form action="ControleServlet" name="form_cid" method="post" class="formulario">
                        <h2 class="h-form">Alterar Cidade</h2>
                        <div>
                            <div class="input-group">
                                <input type="text" id="nome" name="nome" value="<%=nomeC%>"/>
                                <label for="nome" class="label active">Nome</label>
                            </div>
                            <div class="input-group">
                                <input type="text" id="taxa" name="taxa" value="<%=taxaC%>"/>
                                <label for="taxa" class="label active">Taxa</label>
                            </div>
                            <input type="hidden" name="id" value="<%=idC%>"/>
                            <input type="hidden" name="logica" value="AlterarCidade"/>
                            <div class="left">
                                <button><i class="icon-pencil"></i> Alterar
                                </button>
                            </div>
                        </div>
                    </form>
            <%  } catch (Exception e) { %>
                    <form action="ControleServlet" name="form_cid" method="post" class="formulario">
                        <h2 class="h-form">Adicionar Cidade</h2>
                        <div>
                            <div class="input-group">
                                <input type="text" id="nome" name="nome"/>
                                <label for="nome" class="label">Nome</label>
                            </div>
                            <div class="input-group">
                                <input type="text" id="taxa" name="taxa"/>
                                <label for="taxa" class="label">Taxa</label>
                            </div>
                            <input type="hidden" name="logica" value="AdicionarCidade"/>
                            <div class="left">
                                <button><i class="icon-checkmark2"></i> Adicionar
                                </button>
                            </div>
                        </div>
                    </form>      
            <%  }   %>
                </div>
            </div>
        </div>
    </section>
    <aside>
    </aside>
</content>
<footer>
    <h1 class="logo-mini">Control +</h1>
    <time>10:45</time>
</footer>
</main>
<script src="js/empresa.js"></script>
</body>
</html>