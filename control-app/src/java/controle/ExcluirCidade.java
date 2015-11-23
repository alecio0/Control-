
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cidade;
import modelo.CidadeDAO;
import modelo.Conexao;

public class ExcluirCidade implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Cidade c = new Cidade();
            c.setId(Integer.parseInt(request.getParameter("id")));
        
        Connection conn = new Conexao().trazConexao();
        
        CidadeDAO dao = new CidadeDAO(conn);
            dao.removerCidade(c);
        
        conn.close();
        
        return "empresa.jsp";
        
    }
    
}
