
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cidade;
import modelo.CidadeDAO;

public class ExcluirCidade implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Cidade c = new Cidade();
            c.setId(Integer.parseInt(request.getParameter("id")));
        
        CidadeDAO dao = new CidadeDAO();
            dao.removerCidade(c);
        
        
        return "empresa.jsp";
        
    }
    
}
