
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Carrinho;
import modelo.CarrinhoDAO;
import modelo.Cliente;

public class CancelarPedido implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession();
        
        Cliente c = (Cliente)session.getAttribute("cli");
        
        Carrinho cart = new Carrinho();
            cart.setCliente(c);
            
        CarrinhoDAO dao  = new CarrinhoDAO();
            dao.cancelarCart(cart);
            session.removeAttribute("cli");
            
        return "pedidos.jsp";
        
    }
    
}
