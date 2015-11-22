
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Carrinho;
import modelo.CarrinhoDAO;
import modelo.Cliente;

public class RemoverProCart implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Carrinho cart = new Carrinho();
            cart.setId(Integer.parseInt(request.getParameter("id")));
        
        CarrinhoDAO dao = new CarrinhoDAO();
            dao.removerProCart(cart);
        
        return "index.jsp";
        
    }
    
}
