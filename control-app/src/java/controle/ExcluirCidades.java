
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CidadeDAO;
import modelo.Conexao;

public class ExcluirCidades implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Connection conn = new Conexao().trazConexao();
        
        CidadeDAO dao = new CidadeDAO(conn);
            dao.exclirTodasCidades();
            
        conn.close();
        
        return "empresa.jsp";
        
    }
    
}
