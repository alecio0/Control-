
package controle;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Carrinho;
import modelo.CarrinhoDAO;
import modelo.Cliente;
import modelo.Pedido;
import modelo.PedidoDAO;
import modelo.Usuario;

public class FinalizarPedido implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession();
        
        Cliente cli = (Cliente)session.getAttribute("cli");
        
        Pedido ped = new Pedido();
            ped.setValor(Double.parseDouble(request.getParameter("valor")));
            ped.setCliente(cli);
            ped.setUsuario((Usuario)session.getAttribute("user"));
        
        PedidoDAO daoPed = new PedidoDAO();
            daoPed.addPedido(ped);
        
        CarrinhoDAO daoCar = new CarrinhoDAO();
            List<Carrinho> cars = daoCar.listarProCart(cli);
            for(Carrinho car: cars){
                ped.setProduto(car.getProduto());
                ped.setId(daoPed.getLastPedido().getId());
                
                daoPed.addProPedido(ped);
            }
        
        daoCar.desconectar();
        daoPed.desconectar();
        
        session.removeAttribute("cli");
        
        return "pedidos.jsp";
        
    }
    
}
