
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class Login implements Logica {
    
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession();
        Usuario u = new Usuario();
            u.setLogin(request.getParameter("login"));
            u.setSenha(request.getParameter("senha"));
        
        UsuarioDAO dao = new UsuarioDAO();
            u = dao.logar(u);
            String passa = "login.jsp";
            if (u != null) {
                session.setAttribute("user", u);
                passa = "index.jsp";
            }
            dao.desconectar();
        return passa;
    }
    
}
