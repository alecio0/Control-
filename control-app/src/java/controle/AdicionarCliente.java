
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cidade;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Conexao;

public class AdicionarCliente implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Cliente c = new Cliente();
            c.setNome(request.getParameter("nome"));
            c.setEndereco(request.getParameter("endereco"));
            c.setTelefone(request.getParameter("telefone"));
                Cidade cit = new Cidade();
                    try {
                        cit.setId(Integer.parseInt(request.getParameter("cidade")));
                    } catch (Exception e) {
                        cit.setId(1);
                    }
            c.setCidade(cit);
            
        Connection conn = new Conexao().trazConexao();
            
        ClienteDAO dao = new ClienteDAO(conn);
        
        if (c.getCidade().getId() > 1) {
            
            dao.addCliente(c);
            c = dao.getLastCli();

            conn.close();

            return "clientes.jsp#cli" + c.getId() ;
            
        } else {
            
            dao.addCliente(c);
            c = dao.getLastCli();
            
            conn.close();
            
            return "ControleServlet?logica=IniciarPedido&idCli=" + c.getId() ;
            
        }
        
    }
    
}
