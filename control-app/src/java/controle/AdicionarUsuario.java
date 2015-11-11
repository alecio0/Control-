
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        
        UsuarioDAO dao = new UsuarioDAO();
            dao.addUser(u);
            dao.desconectar();
            
        return "usuario.jsp";
        
    }
    
}
