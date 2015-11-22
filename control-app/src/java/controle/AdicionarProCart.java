
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Carrinho;
import modelo.CarrinhoDAO;
import modelo.Cliente;
import modelo.Produto;

public class AdicionarProCart implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession();
        
            Cliente c = (Cliente)session.getAttribute("cli");
            
        if (c != null) {
            
            Carrinho cart = new Carrinho();
            cart.setCliente(c);
            
            Produto p = new Produto();
                p.setId(Integer.parseInt(request.getParameter("idPro")));
            cart.setProduto(p);
        
            CarrinhoDAO dao = new CarrinhoDAO();
                dao.addProCart(cart);
                dao.desconectar();
                
            return "index.jsp";
            
        } else {
            
            return "index.jsp";
            
        }
        
    }
    
}
