
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO extends Conexao{
    private final Connection conn;
    
    public ProdutoDAO() throws ClassNotFoundException{
        this.conn = new Conexao().trazConexao();
    }
    
    //::: adiciona :::
    public void addProduto(Produto p){
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("insert into produtos (nome, custo, venda, tipos_id) values(?, ?, ?, ?)");
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getCusto());
            ps.setDouble(3, p.getVenda());
            ps.setInt(4, p.getTipo().getId());
            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: remove :::
    public void removerProduto(Produto p){
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("delete from produtos where id=?");
            ps.setInt(1, p.getId());
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: lista por Tipo :::
    public List<Produto> listarProdutoTipo(int id_t) throws ClassNotFoundException{
        try {
            
            List<Produto> pros = new ArrayList<Produto>();
            PreparedStatement ps = this.conn.prepareStatement("select * from produtos where tipos_id=? order by nome");
            ps.setInt(1, id_t);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCusto(rs.getDouble("custo"));
                p.setVenda(rs.getDouble("venda"));
                    Tipo t = new Tipo();
                    t.setId(rs.getInt("tipos_id"));
                p.setTipo(t);
                
                pros.add(p);
            }
            rs.close();
            ps.close();

            return pros;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: altera :::
    public void alterarProduto(Produto p) {
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("update produtos set nome=?, custo=?, venda=?, tipos_id=? where id=?");
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getCusto());
            ps.setDouble(3, p.getVenda());
            ps.setInt(4, p.getTipo().getId());
            ps.setInt(5, p.getId());
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: ler Um :::
    public Produto leUmProduto(int id_p) throws ClassNotFoundException {
        
        Produto p = null;
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("select * from produtos where id = ?");
                ps.setInt(1, id_p);
                ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setVenda(rs.getDouble("venda"));
                
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        }
        
        return p;  
    }
}
