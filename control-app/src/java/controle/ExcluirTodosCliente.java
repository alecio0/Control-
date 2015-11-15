
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CidadeDAO;
import modelo.ClienteDAO;

public class ExcluirTodosCliente implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ClienteDAO dao = new ClienteDAO();
            dao.exclirTodosCliente();
        
        return "clientes.jsp";
        
    }
    
}
