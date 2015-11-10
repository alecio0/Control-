
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    
    public Connection trazConexao() throws ClassNotFoundException{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                return DriverManager.getConnection("jdbc:mysql://localhost:3306/controlDB", "root", "root");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
    public void desconectar() throws ClassNotFoundException{
        try {
            trazConexao().close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {;
//        
//        Conexao c = new Conexao();
//        c.trazConexao();
//        System.out.println("conexao aberta");
//        c.desconectar();
//   }
}
