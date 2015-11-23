
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO extends Conexao {
    private final Connection conn;
    
    public CidadeDAO(Connection conn) throws ClassNotFoundException{
        this.conn = conn;
    }
    
    //::: adiciona :::
    public void addCidade(Cidade t){
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("insert into cidades (nome, taxa) values(?, ?)");
            ps.setString(1, t.getNome());
            ps.setDouble(2, t.getTaxa());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: lista :::
    public List<Cidade> listarCidade(){
        try {
            
            List<Cidade> cs = new ArrayList<Cidade>();
            PreparedStatement ps = this.conn.prepareStatement("select * from cidades where id!=1");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Cidade c = new Cidade();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTaxa(rs.getDouble("taxa"));
                
                cs.add(c);
            }
            rs.close();
            ps.close();

            return cs;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: lista :::
    public List<Cidade> getCidade(){
        try {
            
            List<Cidade> cs = new ArrayList<Cidade>();
            PreparedStatement ps = this.conn.prepareStatement("select * from cidades order by nome");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Cidade c = new Cidade();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTaxa(rs.getDouble("taxa"));
                
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
    public Cidade leUmCidade(int id_c) throws ClassNotFoundException {
        
        Cidade u = null;
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("select * from cidades where id = ?");
                ps.setInt(1, id_c);
                ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                u = new Cidade();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setTaxa(rs.getDouble("taxa"));
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        }
        
        return u;  
    }
    
    //::: remove :::
    public void removerCidade(Cidade t){
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("delete from cidades where id=?");
            ps.setInt(1, t.getId());
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    //::: altera :::
    public void alterarCidade(Cidade t) {
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("update cidades set nome=?, taxa=? where id=?");
            ps.setString(1, t.getNome());
            ps.setDouble(2, t.getTaxa());
            ps.setInt(3, t.getId());
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: removeTudo :::
    public void exclirTodasCidades(){
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("delete from cidades where id!=1");
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
