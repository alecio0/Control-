
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO extends Conexao {
    private final Connection conn;
    
    public PedidoDAO(Connection conn) throws ClassNotFoundException{
        this.conn = conn;
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
                
                    ClienteDAO daoCli = new ClienteDAO(conn);
                p.setCliente(daoCli.leUmCliente(rs.getInt("clientes_id")));
                
                    UsuarioDAO daoUser = new UsuarioDAO(conn);
                p.setUsuario(daoUser.leUmUsuario(rs.getInt("usuarios_id")));
                
                    EmpresaDAO daoEmp = new EmpresaDAO(conn);
                p.setEmpresa(daoEmp.getEmpresa());
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        }
        
        return p;  
    }
    
    //::: lista :::
    public List<Pedido> listarPedido() throws ClassNotFoundException{
        try {
            
            List<Pedido> peds = new ArrayList<Pedido>();
            PreparedStatement ps = this.conn.prepareStatement("select * from pedidos order by id desc");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Pedido ped = new Pedido();
                ped = new Pedido();
                ped.setId(rs.getInt("id"));
                ped.setValor(rs.getDouble("valor"));
                ped.setData(rs.getDate("data"));
                ped.setHora(rs.getTime("hora"));
                
                    ClienteDAO daoCli = new ClienteDAO(conn);
                ped.setCliente(daoCli.leUmCliente(rs.getInt("clientes_id")));
                
                    UsuarioDAO daoUser = new UsuarioDAO(conn);
                ped.setUsuario(daoUser.leUmUsuario(rs.getInt("usuarios_id")));
                
                    EmpresaDAO daoEmp = new EmpresaDAO(conn);
                ped.setEmpresa(daoEmp.getEmpresa());
                
                peds.add(ped);
            }
            rs.close();
            ps.close();

            return peds;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: ler Um :::
    public Pedido leUmPedido(int id_prd) throws ClassNotFoundException {
        
        Pedido ped = null;
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("select * from pedidos where id = ?");
                ps.setInt(1, id_prd);
                ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                ped = new Pedido();
                ped.setId(rs.getInt("id"));
                ped.setValor(rs.getDouble("valor"));
                ped.setData(rs.getDate("data"));
                ped.setHora(rs.getTime("hora"));
                
                    ClienteDAO daoCli = new ClienteDAO(conn);
                ped.setCliente(daoCli.leUmCliente(rs.getInt("clientes_id")));
                
                    UsuarioDAO daoUser = new UsuarioDAO(conn);
                ped.setUsuario(daoUser.leUmUsuario(rs.getInt("usuarios_id")));
                
                    EmpresaDAO daoEmp = new EmpresaDAO(conn);
                ped.setEmpresa(daoEmp.getEmpresa());
                
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        }
        
        return ped;  
    }
    
    public List<Pedido> listarPedidoUser(Usuario user) throws ClassNotFoundException{
        
        try {
            
            List<Pedido> peds = new ArrayList<Pedido>();
            PreparedStatement ps = conn.prepareStatement("select id from pedidos where usuarios_id = ?");
            ps.setInt(1, user.getId());
                ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Pedido ped = new Pedido();
                ped = new Pedido();
                ped.setId(rs.getInt("id"));
                
                peds.add(ped);
            }
            rs.close();
            ps.close();

            return peds;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Pedido> listarPedidoCit(Cidade cit) throws ClassNotFoundException{
        
        try {
            
            List<Pedido> peds = new ArrayList<Pedido>();
            PreparedStatement ps = conn.prepareStatement("select id from pedidos where clientes_id in (select id from clientes where cidades_id = ?)");
            ps.setInt(1, cit.getId());
                ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Pedido ped = new Pedido();
                ped = new Pedido();
                ped.setId(rs.getInt("id"));
                
                peds.add(ped);
            }
            rs.close();
            ps.close();

            return peds;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Pedido> listarPedidoTipo(Tipo t) throws ClassNotFoundException{
        
        try {
            
            List<Pedido> peds = new ArrayList<Pedido>();
            PreparedStatement ps = conn.prepareStatement("select * from pedidos where id in (select pedidos_id from pedidos_has_produtos where produtos_id in (select id from produtos where tipos_id =? ))");
            ps.setInt(1, t.getId());
                ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Pedido ped = new Pedido();
                ped = new Pedido();
                ped.setId(rs.getInt("id"));
                
                peds.add(ped);
            }
            rs.close();
            ps.close();

            return peds;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Pedido> listarPedidoPro(Produto pro) throws ClassNotFoundException{
        
        try {
            
            List<Pedido> peds = new ArrayList<Pedido>();
            PreparedStatement ps = conn.prepareStatement("select * from pedidos where id in (select pedidos_id from pedidos_has_produtos where produtos_id = ?)");
            ps.setInt(1, pro.getId());
                ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Pedido ped = new Pedido();
                ped = new Pedido();
                ped.setId(rs.getInt("id"));
                
                peds.add(ped);
            }
            rs.close();
            ps.close();

            return peds;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Pedido> totalVendido() throws ClassNotFoundException{
        
        try {
            
            List<Pedido> peds = new ArrayList<Pedido>();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM pedidos_has_produtos");
                ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Pedido ped = new Pedido();
                ped = new Pedido();
                ped.setId(rs.getInt("pedidos_id"));
                
                
                peds.add(ped);
            }
            rs.close();
            ps.close();

            return peds;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Pedido> TotalVendPorTipo(Tipo t) throws ClassNotFoundException{
        
        try {
            
            List<Pedido> peds = new ArrayList<Pedido>();
            PreparedStatement ps = conn.prepareStatement("SELECT pedidos_id FROM pedidos_has_produtos where produtos_id in(select id from produtos where tipos_id = ?)");
            ps.setInt(1, t.getId());
                ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Pedido ped = new Pedido();
                ped = new Pedido();
                ped.setId(rs.getInt("pedidos_id"));
                
                peds.add(ped);
            }
            rs.close();
            ps.close();

            return peds;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Pedido> TotalPorVend_por_Tipo(Produto p) throws ClassNotFoundException{
        
        try {
            
            List<Pedido> peds = new ArrayList<Pedido>();
            PreparedStatement ps = conn.prepareStatement("SELECT pedidos_id FROM pedidos_has_produtos where produtos_id = ?");
            ps.setInt(1, p.getId());
                ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Pedido ped = new Pedido();
                ped = new Pedido();
                ped.setId(rs.getInt("pedidos_id"));
                
                peds.add(ped);
            }
            rs.close();
            ps.close();

            return peds;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
