
package modelo;

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
        
        PedidoDAO dao = new PedidoDAO();
            System.out.println(dao.getLastPedido().getValor());
            
        
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
