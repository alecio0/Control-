<%@page import="modelo.Produto"%>
<%@page import="modelo.ProdutoDAO"%>
<%@page import="modelo.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="modelo.PedidoDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.Conexao"%>
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
            <content>
                <section>
                    <div id="section" class="sela">
                        <%
                            Connection conn = new Conexao().trazConexao();
                            PedidoDAO daoPed = new PedidoDAO(conn);
                            int id = Integer.parseInt(request.getParameter("id"));
                            Pedido ped = daoPed.leUmPedido(id);
                        %>
                        <div id="id1" class="tab estatico">
                            <table id="print">
                                <thead>
                                    <tr>
                                        <th colspan="4" class="th-head"><%=ped.getEmpresa().getNome()%></th>
                                    </tr>
                                    <tr>
                                        <th>CNPJ:</th>
                                        <td colspan="3"><%=ped.getEmpresa().getCnpj()%></td>
                                    </tr>
                                    <tr>
                                        <th>Endereço:</th>
                                        <td colspan="3"><%=ped.getEmpresa().getEndereco()%></td>
                                    </tr>
                                    <tr>
                                        <th>Fone:</th>
                                        <td colspan="3"><%=ped.getEmpresa().getTelefone()%></td>
                                    </tr>
                                    <tr>
                                        <th>Email:</th>
                                        <td colspan="3"><%=ped.getEmpresa().getEmail()%></td>
                                    </tr>
                                </thead>
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
                                        <th>Cidade:</th>
                                        <td><%=ped.getCliente().getCidade()%></td>
                                    </tr>
                                    <tr>
                                        <th>Fone:</th>
                                        <td><%=ped.getCliente().getTelefone()%></td>
                                    </tr>
                                    <tr>
                                        <th colspan="4" class="th-head">Produtos</th>
                                    </tr>
                                    <tr>
                                        <th>id</th>
                                        <th colspan="2">nome</th>
                                        <th>p. unit</th>
                                    </tr>
                                    <%
                                        ProdutoDAO daoPro = new ProdutoDAO(conn);
                                        List<Pedido> pros = daoPro.listarProdutoDoPedido(ped.getId());
                                        for (Pedido pro : pros) {
                                    %>
                                    <tr>
                                        <td><%=pro.getId()%></td>
                                        <td colspan="2"><%=pro.getProduto().getNome()%></td>
                                        <td><%=pro.getProduto().getVenda()%></td>
                                    </tr>
                                    <%  }%>
                                    <tr>
                                        <th colspan="3">Taxa entrega</th>
                                        <td><%=ped.getCliente().getCidade().getTaxa()%></td>
                                    </tr>
                                    <tr>
                                        <th colspan="3">Total</th>
                                        <td><%=ped.getValor()%></td>
                                        <% conn.close(); %>
                                    </tr>
                                    <tr>
                                        <th colspan="4" class="th-head">Obrigado Pela Preferencia</th>
                                    </tr>
                                </tbody>
                                <tfoot></tfoot>
                            </table>
                        </div>
                    </div>
                </section>
            </content>
        </main>
    </body>
</html>