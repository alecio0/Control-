<%@page import="java.sql.Connection"%>
<%@page import="modelo.Conexao"%>
<%@page import="modelo.Produto"%>
<%@page import="modelo.ProdutoDAO"%>
<%@page import="modelo.Tipo"%>
<%@page import="modelo.TipoDAO"%>
<%@page import="modelo.Cidade"%>
<%@page import="modelo.CidadeDAO"%>
<%@page import="modelo.Pedido"%>
<%@page import="modelo.PedidoDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.UsuarioDAO"%>
<%@include file="header.jsp" %>
<%  if (perfilUser.equals("Atendente")) {
        response.sendRedirect("index.jsp");
    } %>
<content select="">
    <section>
        <div class="sela">
            <div class="tab">
                <%
                    Connection conn = new Conexao().trazConexao();
                    PedidoDAO daoPed = new PedidoDAO(conn);
                    double total = daoPed.listarPedido().size();
                    UsuarioDAO daoUser = new UsuarioDAO(conn);
                    List<Usuario> us = daoUser.listarUsuario();
                    if(us.size() > 0 ){ %>
                <div class="tab tab-graf">
                    <table>
                        <caption class="h-form">
                            <h2>Usuarios Que Mais Venden</h2>
                        </caption>
                        <tbody>
                    
                    <%  for (Usuario u : us) {
                            double totalUser = daoPed.listarPedidoUser(u).size();
                            double percent = totalUser / total; %>
                            <tr>
                                <td><a href="#casa" class="h-form"><%=u.getNome()%></a></td>
                                <td class="bar-graf"> 
                                    <meter value="<%=percent%>"></meter>
                                </td>
                                <td><%=String.format("%.2f", ((totalUser*100) / total))%> %</td>
                            </tr>
                        
                    <%  }   %>
                            
                        </tbody>
                    </table>
                </div>
                <%  }   %>
                <%
                    CidadeDAO daoCit = new CidadeDAO(conn);
                    List<Cidade> cits = daoCit.getCidade();
                    if(cits.size() > 0 ){
                    Pedido ped = new Pedido();  %>
                <div class="tab tab-graf">
                    <table>
                        <caption class="h-form">
                            <h2>Lugares Mais Atendidos</h2>
                        </caption>
                        <tbody>
                    
                    <%  for (Cidade cit : cits) {
                            double totalCit = daoPed.listarPedidoCit(cit).size();
                            double percent = totalCit / total; %>
                            <tr>
                                <td><a href="#casa" class="h-form"><%=cit.getNome()%></a></td>
                                <td class="bar-graf"> 
                                    <meter value="<%=percent%>"></meter>
                                </td>
                                <td><%=String.format("%.2f", ((totalCit*100) / total))%> %</td>
                            </tr>
                        
                    <%  }   %>
                            
                        </tbody>
                    </table>
                </div>
                <%  }   %>
                <%
                    double TotalTipo = daoPed.totalVendido().size();
                    double totalProduto = 0;
                    TipoDAO daoT = new TipoDAO(conn);
                    List<Tipo> ts = daoT.listarTipo();
                    if(ts.size() > 0 ){ %>
                <div class="tab tab-graf">
                    <table>
                        <caption class="h-form">
                            <h2>Graficos dos Tipos</h2>
                        </caption>
                        <tbody>
                    
                    <%  for (Tipo t : ts) {
                            totalProduto = daoPed.TotalVendPorTipo(t).size();
                            double percent = totalProduto / TotalTipo; %>
                            <tr>
                                <td><a href="#casa" class="h-form"><%=t.getNome()%></a></td>
                                <td class="bar-graf"> 
                                    <meter value="<%=percent%>"></meter>
                                </td>
                                <td><%=String.format("%.2f", ((totalProduto*100) / TotalTipo))%> %</td>
                            </tr>
                        
                    <%  }   %>
                            
                        </tbody>
                    </table>
                </div>
                <%  }   %>
                <%
                    if(ts.size() > 0 ){
                        
                    for(Tipo t : ts) { 
                    ProdutoDAO daoPro = new ProdutoDAO(conn);
                    List<Produto> pros = daoPro.listarProdutoTipo(t.getId());
                    double tTipo = daoPed.TotalVendPorTipo(t).size();
                    
                    if(pros.size() > 0){    %>
                <div class="tab tab-graf">
                    <table>
                        <caption class="h-form">
                            <h2><%=t.getNome()%></h2>
                        </caption>
                        <tbody>
                            <%  for(Produto pro : pros){
                                double totalPro = daoPed.TotalPorVend_por_Tipo(pro).size();
                                double percent = totalPro / tTipo;%>
                            <tr>
                                <td><a href="#casa" class="h-form"><%=pro.getNome()%></a></td>
                                <td class="bar-graf"> 
                                    <meter value="<%=percent%>"></meter>
                                </td>
                                <td><%=String.format("%.2f", ((totalPro*100) / tTipo))%> %</td>
                            </tr>
                            <%  }   %>
                        </tbody>
                    </table>
                </div>
                <%  }}} conn.close();   %>
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
</body>
</html>