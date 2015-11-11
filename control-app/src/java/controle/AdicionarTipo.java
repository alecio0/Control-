
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Tipo;
import modelo.TipoDAO;

public class AdicionarTipo implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Tipo t = new Tipo();
            t.setNome(request.getParameter("nome"));
        
        TipoDAO dao = new TipoDAO();
            dao.addTipo(t);
            dao.desconectar();
        
        return "produtos.jsp";
        
    }
    
}
