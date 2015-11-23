
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conexao;
import modelo.Produto;
import modelo.ProdutoDAO;

public class ExcluirProduto implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Produto p = new Produto();
            p.setId(Integer.parseInt(request.getParameter("id")));
        
        Connection conn = new Conexao().trazConexao();
        
        ProdutoDAO dao = new ProdutoDAO(conn);
            dao.removerProduto(p);
            dao.desconectar();
        
        conn.close();
        
        return "produtos.jsp";
        
    }
    
}
