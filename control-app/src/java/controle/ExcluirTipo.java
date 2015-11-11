
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Tipo;
import modelo.TipoDAO;

public class ExcluirTipo implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Tipo t = new Tipo();
            t.setId(Integer.parseInt(request.getParameter("id")));
        
        TipoDAO dao = new TipoDAO();
            dao.removerTipo(t);
            dao.desconectar();
            
        return "produtos.jsp";
        
    }
    
}
