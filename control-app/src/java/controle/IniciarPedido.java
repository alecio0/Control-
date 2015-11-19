
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.ClienteDAO;

public class IniciarPedido implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession();
        
        Cliente c = new Cliente();
        c.setId(Integer.parseInt(request.getParameter("idCli")));
        
        ClienteDAO dao = new ClienteDAO();
            c = dao.leUmCliente(c.getId());
            session.setAttribute("cli", c);
            dao.desconectar();
            
        return "pedidos.jsp";
        
    }
    
}
