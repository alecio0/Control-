
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends Conexao{
    private final Connection conn;
    
    public ClienteDAO() throws ClassNotFoundException{
        this.conn = new Conexao().trazConexao();
    }
    
    //::: adicionar :::
    public void addCliente(Cliente c) {
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("insert into clientes (nome, telefone, endereco, cidades_id) values(?, ?, ?, ?)");
            ps.setString(1, c.getNome());
            ps.setString(2, c.getTelefone());
            ps.setString(3, c.getEndereco());
            ps.setInt(4, c.getCidade().getId());
            ps.execute();
            ps.close();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: remove :::
    public void removerCliente(Cliente c){
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("delete from clientes where id=?");
            ps.setInt(1, c.getId());
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: altera :::
    public void alterarCliente(Cliente u) {
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("update clientes set nome=?, telefone=?, endereco=?, cidades_id=? where id=?");
            ps.setString(1, u.getNome());
            ps.setString(2, u.getTelefone());
            ps.setString(3, u.getEndereco());
            ps.setInt(4, u.getCidade().getId());
            ps.setInt(5, u.getId());
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: lista :::
    public List<Cliente> listarCliente() throws ClassNotFoundException{
        try {
            
            List<Cliente> cs = new ArrayList<Cliente>();
            PreparedStatement ps = this.conn.prepareStatement("select * from clientes order by nome");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                //criando objeto perfil
                Cliente c = new Cliente();
                    c.setId(rs.getInt("id"));
                    c.setNome(rs.getString("nome"));
                    c.setTelefone(rs.getString("telefone"));
                    c.setEndereco(rs.getString("endereco"));
                        CidadeDAO cit = new CidadeDAO();
                    c.setCidade(cit.leUmCidade(rs.getInt("cidades_id")));
                    
                cs.add(c);
            }
            rs.close();
            ps.close();

            return cs;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: ler Um :::
    public Cliente leUmCliente(int id_c) throws ClassNotFoundException {
        
        Cliente c = null;
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("select * from clientes where id = ?");
                ps.setInt(1, id_c);
                ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                    CidadeDAO cit = new CidadeDAO();
                c.setCidade(cit.leUmCidade(rs.getInt("cidades_id")));
                
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        }
        
        return c;  
    }
    
    //::: ler Um :::
    public Cliente pesqCliente(String tel) throws ClassNotFoundException {
        
        Cliente c = null;
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("select * from clientes where telefone = ?");
                ps.setString(1, tel);
                ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                    CidadeDAO cit = new CidadeDAO();
                c.setCidade(cit.leUmCidade(rs.getInt("cidades_id")));
                
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        }
        
        return c;  
    }
    
    //::: ler Ultima  :::
    public Cliente getLastCli() throws ClassNotFoundException, SQLException {
        
        Cliente c = null;
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("select id from clientes order by id desc limit 1");
                ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                c = new Cliente();
                c.setId(rs.getInt("id"));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        }
        return c;  
    }
    
    //::: removeTudo :::
    public void exclirTodosCliente(){
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("delete from clientes;");
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
