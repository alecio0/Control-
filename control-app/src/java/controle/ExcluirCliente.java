
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Conexao;

public class ExcluirCliente implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Cliente c = new Cliente();
            c.setId(Integer.parseInt(request.getParameter("id")));
        
        Connection conn = new Conexao().trazConexao();
        
        ClienteDAO dao = new ClienteDAO(conn);
            dao.removerCliente(c);
            dao.desconectar();
        
        conn.close();
            
        return "clientes.jsp";
        
    }
    
}
