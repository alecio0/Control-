
package controle;

import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Carrinho;
import modelo.CarrinhoDAO;
import modelo.Cliente;
import modelo.Conexao;
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
        
        Connection conn = new Conexao().trazConexao();
            
        PedidoDAO daoPed = new PedidoDAO(conn);
            daoPed.addPedido(ped);
        
        CarrinhoDAO daoCar = new CarrinhoDAO(conn);
            List<Carrinho> cars = daoCar.listarProCart(cli);
            
            if (cars.size() > 0) {
                
                for (Carrinho car : cars) {
                    ped.setProduto(car.getProduto());
                    ped.setId(daoPed.getLastPedido().getId());

                    daoPed.addProPedido(ped);
                }
                
                    Carrinho car = new Carrinho();
                    car.setCliente(cli);
                    daoCar.cancelarCart(car);
                    
            } else {
                
                conn.close();
                return "index.jsp";
                
            }
        
        conn.close();
        
        session.removeAttribute("cli");
        
        return "pedidos.jsp";
        
    }
    
}
