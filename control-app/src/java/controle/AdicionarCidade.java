
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cidade;
import modelo.CidadeDAO;

public class AdicionarCidade implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Cidade c = new Cidade();
            c.setNome(request.getParameter("nome"));
            c.setTaxa(Double.parseDouble(request.getParameter("taxa")));
            
        CidadeDAO dao = new CidadeDAO();
            dao.addCidade(c);
            dao.desconectar();
        
        return "empresa.jsp";
        
    }
    
}
