
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cidade;
import modelo.Cliente;
import modelo.ClienteDAO;

public class AdicionarCliente implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Cliente c = new Cliente();
            c.setNome(request.getParameter("nome"));
            c.setEndereco(request.getParameter("endereco"));
            c.setTelefone(request.getParameter("telefone"));
                Cidade cit = new Cidade();
                    cit.setId(Integer.parseInt(request.getParameter("cidade")));
            c.setCidade(cit);
        
        ClienteDAO dao = new ClienteDAO();
            dao.addCliente(c);
            c = dao.getLastCli();
            dao.desconectar();
            
        return "clientes.jsp#cli" + c.getId() ;
        
    }
    
}
