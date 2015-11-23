
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Carrinho;
import modelo.CarrinhoDAO;
import modelo.Cliente;
import modelo.Conexao;

public class RemoverProCart implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Carrinho cart = new Carrinho();
            cart.setId(Integer.parseInt(request.getParameter("id")));
        
        Connection conn = new Conexao().trazConexao();
        
        CarrinhoDAO dao = new CarrinhoDAO(conn);
            dao.removerProCart(cart);
        
        conn.close();
        
        return "index.jsp";
        
    }
    
}
