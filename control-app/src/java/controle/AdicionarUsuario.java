
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conexao;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class AdicionarUsuario implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Usuario u = new Usuario();
            u.setNome(request.getParameter("nome"));
            u.setLogin(request.getParameter("login"));
            u.setSenha(request.getParameter("senha1"));
            u.setPerfil(request.getParameter("perfil"));
            
        Connection conn = new Conexao().trazConexao();
        
        UsuarioDAO dao = new UsuarioDAO(conn);
            dao.addUser(u);
            dao.desconectar();
            
        conn.close();
        
        return "usuario.jsp";
        
    }
    
}
