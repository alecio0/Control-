
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CidadeDAO;

public class ExcluirCidades implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        CidadeDAO dao = new CidadeDAO();
            dao.exclirTodasCidades();
        
        return "empresa.jsp";
        
    }
    
}
