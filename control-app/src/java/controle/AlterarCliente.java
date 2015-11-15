
package controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cidade;
import modelo.Cliente;
import modelo.ClienteDAO;

public class AlterarCliente implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Cliente c = new Cliente();
            c.setId(Integer.parseInt(request.getParameter("id")));
            c.setNome(request.getParameter("nome"));
            c.setTelefone(request.getParameter("telefone"));
            c.setEndereco(request.getParameter("endereco"));
                Cidade cit = new Cidade();
                cit.setId(Integer.parseInt(request.getParameter("cidade")));
            c.setCidade(cit);
        
        ClienteDAO dao = new ClienteDAO();
            dao.alterarCliente(c);
            dao.desconectar();
        
        return "clientes.jsp#cli" + c.getId() ;
        
    }
    
}
