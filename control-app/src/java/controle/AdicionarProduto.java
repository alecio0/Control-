
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conexao;
import modelo.Produto;
import modelo.ProdutoDAO;
import modelo.Tipo;

public class AdicionarProduto implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Produto p = new Produto();
            p.setNome(request.getParameter("nome"));
            p.setCusto(Double.parseDouble(request.getParameter("custo")));
            p.setVenda(Double.parseDouble(request.getParameter("venda")));
                Tipo t = new Tipo();
                    t.setId(Integer.parseInt(request.getParameter("tipo")));
                    
            p.setTipo(t);
            
        Connection conn = new Conexao().trazConexao(); 
        
        ProdutoDAO dao = new ProdutoDAO(conn);
            dao.addProduto(p);
            
        conn.close();
            
        return "produtos.jsp";
    }
    
}
