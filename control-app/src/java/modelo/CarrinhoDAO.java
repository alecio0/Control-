
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDAO extends Conexao {
    private final Connection conn;
    
    public CarrinhoDAO(Connection conn) throws ClassNotFoundException{
        this.conn = conn;
    }
    
    //::: adicionar :::
    public void addProCart(Carrinho c) {
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("insert into carrinhos (cliente, produto) values(?, ?)");
            ps.setInt(1, c.getCliente().getId());
            ps.setInt(2, c.getProduto().getId());
            ps.execute();
            ps.close();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: remove :::
    public void removerProCart(Carrinho c){
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("delete from carrinhos where id=?");
            ps.setInt(1, c.getId());
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: remove :::
    public void cancelarCart(Carrinho c){
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("delete from carrinhos where cliente=?");
            ps.setInt(1, c.getCliente().getId());
            
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //::: lista :::
    public List<Carrinho> listarProCart(Cliente c) throws ClassNotFoundException{
        try {
            
            List<Carrinho> carts = new ArrayList<Carrinho>();
            PreparedStatement ps = this.conn.prepareStatement("select * from carrinhos where cliente=? order by produto");
            ps.setInt(1, c.getId());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Carrinho cart = new Carrinho();
                ProdutoDAO daop = new ProdutoDAO(conn);
                cart.setId(rs.getInt("id"));
                cart.setProduto(daop.leUmProduto(rs.getInt("produto")));
                
                carts.add(cart);
            }
            rs.close();
            ps.close();

            return carts;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
