
package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Teste {
    
    public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
        
        Connection conn = new Conexao().trazConexao();
        
        CidadeDAO daoCit = new CidadeDAO(conn);
        List<Cidade> cits = daoCit.getCidade();
        
        Pedido ped = new Pedido();
            
        PedidoDAO dao = new PedidoDAO(conn);
        System.out.println(dao.listarPedido().size());
        int total = dao.listarPedido().size();
        
        double c = (double) 1.5;
        
        System.out.println(c);
            
        for (Cidade cit : cits) {
            String persent = String.format("%.2f", (dao.listarPedidoCit(cit).size() / total));
            System.out.println(cit.getNome() + ": " + persent + " - " + dao.listarPedidoCit(cit).size());
        }
        
//        Date hora;
//
//        
//        
//        
//        Pedido p = new Pedido();
//        
//        Calendar c = Calendar.getInstance();
//        
//        DateFormat f = DateFormat.getDateInstance();
//        
//        Date data = f.parse("29/ 07/ 2005");
//        
//        System.out.println(c.getTime());
//        System.out.println(data);
//        
//        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
//        System.out.println(sdf.format(data));
    }
}
