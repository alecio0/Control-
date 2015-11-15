
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.ClienteDAO;

public class ExcluirCliente implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Cliente c = new Cliente();
            c.setId(Integer.parseInt(request.getParameter("id")));
        
        ClienteDAO dao = new ClienteDAO();
            dao.removerCliente(c);
            dao.desconectar();
        
        return "clientes.jsp";
        
    }
    
}
