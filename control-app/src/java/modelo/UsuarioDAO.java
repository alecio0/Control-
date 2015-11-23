
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends Conexao {
    private final Connection conn;
    
    public UsuarioDAO(Connection conn) throws ClassNotFoundException{
        this.conn = conn;
    }
    
    //::: adicionar :::
    public void addUser(Usuario u) {
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("insert into usuarios (nome, login, senha, perfil) values(?, ?, ?, ?)");
            ps.setString(1, u.getNome());
            ps.setString(2, u.getLogin());
            ps.setString(3, u.getSenha());
            ps.setString(4, u.getPerfil());
            ps.execute();
            ps.close();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: remove :::
    public void removerUsuario(Usuario u){
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("delete from usuarios where id=?");
            ps.setInt(1, u.getId());
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: altera :::
    public void alterarUsuario(Usuario u) {
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("update usuarios set nome=?, login=?, senha=?, perfil=? where id=?");
            ps.setString(1, u.getNome());
            ps.setString(2, u.getLogin());
            ps.setString(3, u.getSenha());
            ps.setString(4, u.getPerfil());
            ps.setInt(5, u.getId());
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: lista :::
    public List<Usuario> listarUsuario() throws ClassNotFoundException{
        try {
            
            List<Usuario> us = new ArrayList<Usuario>();
            PreparedStatement ps = this.conn.prepareStatement("select * from usuarios order by nome");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                //criando objeto perfil
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setPerfil(rs.getString("perfil"));
                // adicionando obijeto a lista
                us.add(u);
            }
            rs.close();
            ps.close();

            return us;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: ler Um :::
    public Usuario leUmUsuario(int id_u) throws ClassNotFoundException {
        
        Usuario u = null;
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("select * from usuarios where id = ?");
                ps.setInt(1, id_u);
                ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setPerfil(rs.getString("perfil"));
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        }
        
        return u;  
    }
    
    //::: removeTudo :::
    public void exclirTodosUsuario(){
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("delete from usuarios;");
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: logar :::
    public Usuario logar(Usuario usuario) throws ClassNotFoundException {
        
        Usuario u = null;
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("select * from usuarios where login = ? and senha = ?");
                ps.setString(1, usuario.getLogin());
                ps.setString(2, usuario.getSenha());
                ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setPerfil(rs.getString("perfil"));
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        }
        
        return u;
    }
}
