
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conexao;
import modelo.Tipo;
import modelo.TipoDAO;

public class AlterarTipo implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Tipo t = new Tipo();
            t.setNome(request.getParameter("nome"));
            t.setId(Integer.parseInt(request.getParameter("id")));
        
        Connection conn = new Conexao().trazConexao();
        
        TipoDAO dao = new TipoDAO(conn);
            dao.alterarTipo(t);
            
        conn.close();
            
        return "produtos.jsp";
        
    }
    
}
