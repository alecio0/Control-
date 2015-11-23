
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CidadeDAO;
import modelo.ClienteDAO;
import modelo.Conexao;

public class ExcluirTodosCliente implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Connection conn = new Conexao().trazConexao();
        
        ClienteDAO dao = new ClienteDAO(conn);
            dao.exclirTodosCliente();
        
        conn.close();
        
        return "clientes.jsp";
        
    }
    
}
