
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Conexao;

public class IniciarPedido implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession();
        
        Cliente c = new Cliente();
        c.setId(Integer.parseInt(request.getParameter("idCli")));
        
        Connection conn = new Conexao().trazConexao();
        
        ClienteDAO dao = new ClienteDAO(conn);
            c = dao.leUmCliente(c.getId());
            session.setAttribute("cli", c);
            dao.desconectar();
            
        conn.close();
            
        return "index.jsp";
        
    }
    
}
