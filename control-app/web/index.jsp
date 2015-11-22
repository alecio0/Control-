<%@page import="modelo.Carrinho"%>
<%@page import="modelo.CarrinhoDAO"%>
<%@page import="modelo.Cliente"%>
<%@page import="modelo.Produto"%>
<%@page import="modelo.ProdutoDAO"%>
<%@page import="modelo.TipoDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Tipo"%>
<%@include file="header.jsp" %>
<content select="">
    <section>
        <div class="sela">
            <div class="tab">
                <%  TipoDAO daot = new TipoDAO();
                    List<Tipo> ts = daot.listarTipo();
                    for (Tipo t : ts) {
                %>
                <div class="tabela">
                    <table>
                        <caption class="h-form">
                            <h2><%=t.getNome()%></h2>
                            <div>

                            </div>
                        </caption>
                        <%  ProdutoDAO daop = new ProdutoDAO();
                            List<Produto> ps = daop.listarProdutoTipo(t.getId());
                            if (ps.size() > 0) {%>
                        <thead class="h-form">
                            <tr>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>P. Custo</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%  }
                                for (Produto p : ps) {%>
                            <tr>
                                <td><%=p.getId()%></td>
                                <td><%=p.getNome()%></td>
                                <td>R$ <%=p.getVenda()%></td>
                                <td><a href="ControleServlet?logica=AdicionarProCart&idPro=<%=p.getId()%>" class="h-form"><i class="icon-plus"></i></a></td>
                            </tr>
                            <%  }   %>
                        </tbody>
                    </table>
                </div>
                <%  }%>
            </div>
        </div>
    </section>
    <aside>
        <div class="lis-ped">
    <%  
            if(session.getAttribute("cli") != null){
            Cliente c = (Cliente)session.getAttribute("cli");
    %>
            <div class="tab">
                <div class="tabela">
                    <table>
                        <caption class="h-form">
                            <h2><%=c.getNome()%></h2>
                            <div>
                                <span>id: <%=c.getId()%></span>
                            </div>
                        </caption>
                        <thead class="h-form">
                            <tr>
                                <th>Descricao</th>
                                <th>P. Unit</th>
                            </tr>
                        </thead>
                        <tbody>
                    <%  CarrinhoDAO daocar = new CarrinhoDAO();
                        List<Carrinho> carts = daocar.listarProCart(c);
                        daocar.desconectar();
                        double total = 0;
                        for(Carrinho cart : carts) {
                    %>
                            <tr>
                                <td><%=cart.getProduto().getNome()%></td>
                                <td><%=cart.getProduto().getVenda()%></td>
                                <td><a href="ControleServlet?logica=RemoverProCart&id=<%=cart.getId()%>" class="h-form"><i class="icon-minus"></i> </a></td>
                            </tr>
                            <% total = cart.getProduto().getVenda() + total; %>
                    <%  }   %>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="">
                                    Valor Taxa Entrega:
                                </td>
                                <td colspan="">
                                    <%=c.getCidade().getTaxa()%>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="">
                                    Valor Total:
                                </td>
                                <td colspan="">
                                    <%=total+c.getCidade().getTaxa()%>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="5">
                                    <a href="ControleServlet?logica=CancelarPedido" class="btn cancel"><i class="icon-cancel-circle"></i> Cancelar</a>
                                    <a href="ControleServlet?logica=FinalizarPedido&valor=<%=total+c.getCidade().getTaxa()%>" class="btn"><i class="icon-checkmark2"></i> Finalizar</a>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
    <%  } else {   %>
            <div class="form-conj">
                <div class="wrap">
                    <form action="ControleServlet" name="form_ped" method="get" class="formulario">
                        <h2 class="h-form">Novo Cliente</h2>
                        <div>
                            <div class="input-group">
                                <input type="text" id="nome" name="nome"/>
                                <label for="nome" class="label"><i class="icon-profile"></i> Nome</label>
                            </div>
                            <input type="hidden" name="logica" value="AdicionarCliente">
                            <div class="left">
                                <button><i class="icon-checkmark2"></i> Adicionar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
    <%  }   %>
        </div>
    </aside>
</content>
<footer>
    <h1 class="logo-mini">Control +</h1>
    <time></time>
</footer>
</main>
<script src="js/pedidos.js"></script>
</body>
</html>
