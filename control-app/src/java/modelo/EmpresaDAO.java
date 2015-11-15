
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaDAO extends Conexao {
    private final Connection conn;
    
    public EmpresaDAO() throws ClassNotFoundException{
        this.conn = new Conexao().trazConexao();
    }
    
    //::: altera :::
    public void alterarEmpresa(Empresa e) {
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("update empresa set nome=?, endereco=?, telefone=?, email=? where id=1");
            ps.setString(1, e.getNome());
            ps.setString(2, e.getEndereco());
            ps.setString(3, e.getTelefone());
            ps.setString(4, e.getEmail());
            
            ps.execute();
            ps.close();

        } catch (SQLException er) {
            throw new RuntimeException(er);
        }
    }
    
    //::: ler Um :::
    public Empresa getEmpresa() throws ClassNotFoundException {
        
        Empresa e = null;
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("select * from empresa where id=1");
                ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                e = new Empresa();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setEndereco(rs.getString("endereco"));
                e.setTelefone(rs.getString("telefone"));
                e.setEmail(rs.getString("email"));
            }
            
            ps.close();
            rs.close();

        } catch (SQLException er) {
            System.out.println("ERRO DE SQL: " + er.getMessage());
        }
        
        return e;  
    }
}
