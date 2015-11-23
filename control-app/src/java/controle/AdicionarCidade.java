
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cidade;
import modelo.CidadeDAO;
import modelo.Conexao;

public class AdicionarCidade implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Cidade c = new Cidade();
            c.setNome(request.getParameter("nome"));
            c.setTaxa(Double.parseDouble(request.getParameter("taxa")));
            
        Connection conn = new Conexao().trazConexao();
            
        CidadeDAO dao = new CidadeDAO(conn);
            dao.addCidade(c);
            
        conn.close();
        
        return "empresa.jsp";
        
    }
    
}
