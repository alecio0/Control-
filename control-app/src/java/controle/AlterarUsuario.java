
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conexao;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class AlterarUsuario implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Usuario u = new Usuario();
            u.setId(Integer.parseInt(request.getParameter("id")));
            u.setNome(request.getParameter("nome"));
            u.setLogin(request.getParameter("login"));
            u.setSenha(request.getParameter("senha1"));
            u.setPerfil(request.getParameter("perfil"));
            
        Connection conn = new Conexao().trazConexao();
        
        UsuarioDAO dao = new UsuarioDAO(conn);
            dao.alterarUsuario(u);
        
        conn.close();
        
        return "usuario.jsp";
        
    }
    
}
