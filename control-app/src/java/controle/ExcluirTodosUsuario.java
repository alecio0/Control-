
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conexao;
import modelo.UsuarioDAO;

public class ExcluirTodosUsuario implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Connection conn = new Conexao().trazConexao();
        
        UsuarioDAO dao = new UsuarioDAO(conn);
            dao.exclirTodosUsuario();
        
        conn.close();
        
        return "usuario.jsp";
        
    }
    
}
