
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoDAO extends Conexao {
    private final Connection conn;
    
    public TipoDAO(Connection conn) throws ClassNotFoundException{
        this.conn = conn;
    }
    
    //::: adiciona :::
    public void addTipo(Tipo t){
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("insert into tipos (nome) values(?)");
            ps.setString(1, t.getNome());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: lista :::
    public List<Tipo> listarTipo(){
        try {
            
            List<Tipo> ts = new ArrayList<Tipo>();
            PreparedStatement ps = this.conn.prepareStatement("select * from tipos");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Tipo t = new Tipo();
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                
                ts.add(t);
            }
            rs.close();
            ps.close();

            return ts;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: remove :::
    public void removerTipo(Tipo t){
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("delete from tipos where id=?");
            ps.setInt(1, t.getId());
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    //::: altera :::
    public void alterarTipo(Tipo t) {
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("update tipos set nome=? where id=?");
            ps.setString(1, t.getNome());
            ps.setInt(2, t.getId());
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
