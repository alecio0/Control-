
package controle;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Conexao;
import modelo.Empresa;
import modelo.EmpresaDAO;

public class AlterarEmpresa implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession();
        
        Empresa e = new Empresa();
            e.setNome(request.getParameter("nome"));
            e.setCnpj(request.getParameter("cnpj"));
            e.setEndereco(request.getParameter("endereco"));
            e.setTelefone(request.getParameter("telefone"));
            e.setEmail(request.getParameter("email"));
            e.setMensagem(request.getParameter("mensagem"));
            
        Connection conn = new Conexao().trazConexao();
            
        EmpresaDAO dao = new EmpresaDAO(conn);
            dao.alterarEmpresa(e);
            
        conn.close();
            
        session.setAttribute("emp", e);
        
        return "empresa.jsp";
        
    }
    
}
