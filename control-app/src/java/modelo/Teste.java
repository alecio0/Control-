
package modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Teste {
    
    public static void main(String[] args) throws ParseException, ClassNotFoundException {
        
//        Empresa e = new Empresa();
//            e.setNome("Pizzaria Egipt");
//            e.setEndereco("QNO 4 conjunto M lote 32");
//            e.setTelefone("3332 - 5492");
//            e.setEmail("pizzariaegipt@emal.com");
        
        EmpresaDAO dao = new EmpresaDAO();
            dao.getEmpresa();
        
        
        
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
