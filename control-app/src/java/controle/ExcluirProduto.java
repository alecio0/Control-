
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Produto;
import modelo.ProdutoDAO;

public class ExcluirProduto implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Produto p = new Produto();
            p.setId(Integer.parseInt(request.getParameter("id")));
        
        ProdutoDAO dao = new ProdutoDAO();
            dao.removerProduto(p);
            dao.desconectar();
        
        return "produtos.jsp";
        
    }
    
}
