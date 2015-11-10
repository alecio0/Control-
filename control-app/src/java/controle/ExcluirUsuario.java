
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class ExcluirUsuario implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Usuario u = new Usuario();
            u.setId(Integer.parseInt(request.getParameter("id")));
            
        UsuarioDAO dao = new UsuarioDAO();
            dao.removerUsuario(u);
            dao.desconectar();
        return "usuario.jsp";
    }
}
