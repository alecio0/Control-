<%@page import="modelo.Produto"%>
<%@page import="modelo.ProdutoDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Tipo"%>
<%@page import="modelo.Tipo"%>
<%@page import="modelo.TipoDAO"%>
<%@include file="header.jsp" %>
<content select="">
    <section>
        <div class="sela">
            <div class="tab">
                <%  TipoDAO daot = new TipoDAO();
                    List<Tipo> ts = daot.listarTipo();
                    for(Tipo t : ts) {
                %>
                <div class="tabela">
                    <table>
                        <caption class="h-form">
                            <h2><%=t.getNome()%></h2>
                            <div>
                                <a href="produtos.jsp?idT=<%=t.getId()%>&nomeT=<%=t.getNome()%>" class="h-form"><i class="icon-pencil"></i> </a>
                                <a href="ControleServlet?logica=ExcluirTipo&id=<%=t.getId()%>" class="h-form" onclick="return checa()"><i class="icon-bin"></i> </a>
                            </div>
                        </caption>
                    <%  ProdutoDAO daop = new ProdutoDAO();
                        List<Produto> ps = daop.listarProdutoTipo(t.getId());
                        if(ps.size() > 0) {%>
                        <thead class="h-form">
                            <tr>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>Custo Unit.</th>
                                <th>Venda Unit.</th>
                            </tr>
                        </thead>
                        <tbody>
                    <%  }
                        for(Produto p : ps){ %>
                            <tr>
                                <td><%=p.getId()%></td>
                                <td><%=p.getNome()%></td>
                                <td><%=p.getCusto()%></td>
                                <td><%=p.getVenda()%></td>
                                <td><a href="produtos.jsp?idP=<%=p.getId()%>&nomeP=<%=p.getNome()%>&custoP=<%=p.getCusto()%>&vendaP=<%=p.getVenda()%>&tipoP=<%=p.getTipo().getId()%>" class="h-form"><i class="icon-pencil"></i> </a></td>
                                <td><a href="ControleServlet?logica=ExcluirProduto&id=<%=p.getId()%>" class="h-form" onclick="return checa()"><i class="icon-bin"></i> </a></td>
                            </tr>
                    <%  }   %>
                        </tbody>
                    </table>
                </div>
                <%  }   %>
            </div>
            <div class="form-conj">
                <div class="wrap">
                <%  try {
                        int idP = Integer.parseInt(request.getParameter("idP"));
                        String nomeP = request.getParameter("nomeP"); 
                        String custoP = request.getParameter("custoP");
                        String vendaP = request.getParameter("vendaP");
                        int tipoP = Integer.parseInt(request.getParameter("tipoP")); %>
                    <form action="ControleServlet" name="form_cad_pro" method="get" class="formulario">
                        <h2 class="h-form">Alterar Produto</h2>
                        <div>
                            <div class="input-group">
                                <input type="text" id="nome" name="nome" value="<%=nomeP%>"/>
                                <label for="nome" class="label active"><i class="icon-file-text"></i> Nome</label>
                            </div>
                            <div class="input-group">
                                <input type="text" id="compra" name="custo" value="<%=custoP%>"/>
                                <label for="custo" class="label active"><i class="icon-dollar"></i> P. Custo Unit.</label>
                            </div>
                            <div class="input-group">
                                <input type="text" id="venda" name="venda" value="<%=vendaP%>"/>
                                <label for="venda" class="label active"><i class="icon-dollar"></i> P. Venda Unit.</label>
                            </div>
                            <div class="input-group radio">
                                <h3 class="h-form">Tipo</h3>
                                <%  for(Tipo t : ts) {  %>
                                <input id="<%=t.getNome()%>" type="radio" name="tipo" value="<%=t.getId()%>" <% if(t.getId() == tipoP) { out.print("checked"); } %>/>
                                <label for="<%=t.getNome()%>"><%=t.getNome()%></label>
                                <%  }   %>
                            </div>
                            <input type="hidden" name="id" value="<%=idP%>"/>
                            <input type="hidden" name="logica" value="AlterarProduto"/>
                                <div class="left">
                                    <button><i class="icon-pencil"></i> Alterar</button>
                                </div>
                        </div>
                    </form>
                <%  } catch (Exception e){    %>
                    <form action="ControleServlet" name="form_cad_pro" method="get" class="formulario">
                        <h2 class="h-form">Novo Produto</h2>
                        <div>
                            <div class="input-group">
                                <input type="text" id="nome" name="nome"/>
                                <label for="nome" class="label"><i class="icon-file-text"></i> Nome</label>
                            </div>
                            <div class="input-group">
                                <input type="text" id="compra" name="custo"/>
                                <label for="custo" class="label"><i class="icon-dollar"></i> P. Custo Unit.</label>
                            </div>
                            <div class="input-group">
                                <input type="text" id="venda" name="venda"/>
                                <label for="venda" class="label"><i class="icon-dollar"></i> P. Venda Unit.</label>
                            </div>
                            <div class="input-group radio">
                                <h3 class="h-form">Tipo</h3>
                                <%  for(Tipo t : ts) {  %>
                                <input id="<%=t.getNome()%>" type="radio" name="tipo" value="<%=t.getId()%>"/>
                                <label for="<%=t.getNome()%>"><%=t.getNome()%></label>
                                <%  }   %>
                            </div>
                            <input type="hidden" id="venda" name="logica" value="AdicionarProduto"/>
                                <div class="left">
                                    <button><i class="icon-checkmark2"></i> Adicionar</button>
                                </div>
                        </div>
                    </form>
                <%  }   %>
                </div>
                <div class="wrap">
                <%  try {
                        int idT = Integer.parseInt(request.getParameter("idT"));
                        String nomeT = request.getParameter("nomeT");   %>
                        <form action="ControleServlet?logica=AlterarTipo" name="form_cad_tip" method="post" class="formulario">
                            <h2 class="h-form">Alterar Tipo</h2>
                            <div>
                                <div class="input-group">
                                    <input type="text" id="nome" name="nome" value="<%=nomeT%>"/>
                                    <label for="nome" class="label active"><i class="icon-table2"></i> Nome</label>
                                    <input type="hidden" name="id" value="<%=idT%>"/>
                                </div>
                                <div class="left">
                                    <button><i class="icon-pencil"></i> Alterar</button>
                                </div>
                            </div>
                        </form>
                <%  } catch (Exception e){    %>
                        <form action="ControleServlet?logica=AdicionarTipo" name="form_cad_tip" method="post" class="formulario">
                            <h2 class="h-form">Novo Tipo</h2>
                            <div>
                                <div class="input-group">
                                    <input type="text" id="nome" name="nome"/>
                                    <label for="nome" class="label"><i class="icon-table2"></i> Nome</label>
                                </div>
                                <div class="left">
                                    <button><i class="icon-checkmark2"></i> Adicionar</button>
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
    <time></time>
</footer>
</main>
<script src="js/produtos.js"></script>
</body>
</html>