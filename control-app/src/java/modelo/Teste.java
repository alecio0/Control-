
package modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Teste {
    
    public static void main(String[] args) throws ParseException {
        
        try {
            Usuario u = new Usuario();
            u.setNome("vida");
            u.setLogin("vida");
            u.setSenha("vida");
            u.setPerfil("vida");

            UsuarioDAO dao = new UsuarioDAO();
            dao.addUser(u);
        } catch (Exception e) {
            System.out.println("nao deu: " + e);
        }
        
        
        
//        try {
//            UsuarioDAO dao = new UsuarioDAO();
//            List<Usuario> us = dao.listarUsuario();
//            for(Usuario u : us){
//                System.out.println(u.getNome());
//            }
//        } catch (Exception e) {
//        }
        
        
        
        
        
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
