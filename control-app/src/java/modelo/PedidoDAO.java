
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAO extends Conexao {
    private final Connection conn;
    
    public PedidoDAO() throws ClassNotFoundException{
        this.conn = new Conexao().trazConexao();
    }
    
    //::: adicionar :::
    public void addPedido(Pedido p) {
        
        try {
            
            String sql = "insert into pedidos (valor, data, hora, clientes_id, usuarios_id, empresa_id)"
                    + "values (?, current_date(), current_time(), ?, ?, 1)";
            
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setDouble(1, p.getValor());
            ps.setInt(2, p.getCliente().getId());
            ps.setInt(3, p.getUsuario().getId());
            ps.execute();
            ps.close();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: adicionar :::
    public void addProPedido(Pedido p) {
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("insert into pedidos_has_produtos (pedidos_id, produtos_id) VALUES (?, ?)");
            ps.setInt(1, p.getId());
            ps.setInt(2, p.getProduto().getId());
            ps.execute();
            ps.close();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: ler Ultima  :::
    public Pedido getLastPedido() throws ClassNotFoundException, SQLException {
        
        Pedido p = null;
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("select * from pedidos order by id desc limit 1");
                ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                p = new Pedido();
                p.setId(rs.getInt("id"));
                p.setValor(rs.getDouble("valor"));
                p.setData(rs.getDate("data"));
                p.setHora(rs.getTime("hora"));
                
                    ClienteDAO daoCli = new ClienteDAO();
                p.setCliente(daoCli.leUmCliente(rs.getInt("clientes_id")));
                
                    UsuarioDAO daoUser = new UsuarioDAO();
                p.setUsuario(daoUser.leUmUsuario(rs.getInt("usuarios_id")));
                
                    EmpresaDAO daoEmp = new EmpresaDAO();
                p.setEmpresa(daoEmp.getEmpresa());
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        }
        
        return p;  
    }
}
