
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conexao;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class ExcluirUsuario implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Usuario u = new Usuario();
            u.setId(Integer.parseInt(request.getParameter("id")));
        
        Connection conn = new Conexao().trazConexao();
            
        UsuarioDAO dao = new UsuarioDAO(conn);
            dao.removerUsuario(u);
            
        conn.close();
        
        return "usuario.jsp";
        
    }
}
