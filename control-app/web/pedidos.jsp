<%@page import="modelo.Produto"%>
<%@page import="modelo.ProdutoDAO"%>
<%@page import="modelo.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="modelo.PedidoDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.Conexao"%>
<%@page import="modelo.Conexao"%>
<%@include file="header.jsp" %>
<content select="">
    <section>
        <div id="section" class="sela coluna">
        <%
            Connection conn = new Conexao().trazConexao();
            PedidoDAO daoPed = new PedidoDAO(conn);
            List<Pedido> peds = daoPed.listarPedido();
            if(peds.size() > 0){
                for(Pedido ped : peds){
        %>
            <div id="id<%=ped.getId()%>" class="tab estatico">
                <table id="print<%=ped.getId()%>">
                    <caption>
                        <h2 class="h-form"><%=ped.getCliente().getNome()%></h2>
                        <div>
                            <sapan class="h-form">COD: <%=ped.getId()%></sapan><a href="#id<%=ped.getId()%>" id="seta" onclick="return ativo('id<%=ped.getId()%>')" class="h-form"><i class="icon-circle-down"> </i></a>
                        </div>
                    </caption>
                    <tbody>
                        <tr>
                            <th colspan="4" class="th-head">Pedido</th>
                        </tr>
                        <tr>
                            <th>Data:</th>
                            <td><%=ped.getData()%></td>
                            <th>Vendedor:</th>
                            <td><%=ped.getUsuario().getNome()%></td>
                        </tr>
                        <tr>
                            <th>Nome:</th>
                            <td><%=ped.getCliente().getNome()%></td>
                        </tr>
                        <tr>
                            <th>Endereco:</th>
                            <td><%=ped.getCliente().getEndereco()%></td>
                            <th>Local:</th>
                            <td><%=ped.getCliente().getCidade().getNome()%></td>
                        </tr>
                        <tr>
                            <th>Fone:</th>
                            <td><%=ped.getCliente().getTelefone()%></td>
                        </tr>
                        <tr>
                            <th colspan="4" class="th-head">Produtos Cod: <%=ped.getId()%></th>
                        </tr>
                        <tr>
                            <th>id</th>
                            <th colspan="2">nome</th>
                            <th>p. unit</th>
                        </tr>
                        <%
                            ProdutoDAO daoPro = new ProdutoDAO(conn);
                            List<Pedido> pros = daoPro.listarProdutoDoPedido(ped.getId());
                            for(Pedido pro : pros){
                        %>
                        <tr>
                            <td><%=pro.getId()%></td>
                            <td colspan="2"><%=pro.getProduto().getNome()%></td>
                            <td><%=pro.getProduto().getVenda()%></td>
                        </tr>
                        <%  }   %>
                        <tr>
                            <th colspan="3">Taxa entrega</th>
                            <td><%=ped.getCliente().getCidade().getTaxa()%></td>
                        </tr>
                        <tr>
                            <th colspan="3">Total</th>
                            <td><%=ped.getValor()%></td>
                        </tr>
                        <tr>
                            <th colspan="4" class="th-head">Obrigado Pela Preferencia</th>
                        </tr>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="4">
                                <button onclick="cont(<%=ped.getId()%>);"><i class="icon-printer"></i> Imprimir</button>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </div>
        <%  }} conn.close();    %>
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
<script src="js/cupon-pedido.js"></script>
</body>
</html>