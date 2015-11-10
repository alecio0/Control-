
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.UsuarioDAO;

public class ExcluirTodosUsuario implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        UsuarioDAO dao = new UsuarioDAO();
            dao.exclirTodosUsuario();
        
        return "usuario.jsp";
    }
    
}
