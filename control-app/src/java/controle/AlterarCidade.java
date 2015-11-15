
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cidade;
import modelo.CidadeDAO;

public class AlterarCidade implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Cidade c = new Cidade();
            c.setNome(request.getParameter("nome"));
            c.setTaxa(Double.parseDouble(request.getParameter("taxa")));
            c.setId(Integer.parseInt(request.getParameter("id")));
            
        CidadeDAO dao = new CidadeDAO();
            dao.alterarCidade(c);
            
        return "empresa.jsp";
        
    }
    
}
