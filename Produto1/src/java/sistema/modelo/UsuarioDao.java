
package sistema.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Familia
 */
public class UsuarioDao extends Conexao {
    public boolean existe (Usuario usuario){
        try{
            String sql = " select * from usuario where nome =? and senha=?";
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1,usuario.getNome());
             st.setString(2,usuario.getSenha());
             ResultSet rs = st.executeQuery();
             rs.last();
             if(rs.getRow()>0)
                 return true ;
             else
                 return false;
             
             
        }catch(SQLException e){
            return false;
        }
    }
      public void cadastrar(Usuario usuario){
      try{
          String sql = "insert into produto values(default,?,?,?)";
          PreparedStatement st = getConnection().prepareStatement(sql);
          st.setString(1, usuario.getNome());
          st.setString(2, usuario.getSenha());
          
          st.execute();
      }  catch(Exception e){
          e.printStackTrace();
          
      }
    }
     public List <Usuario> getUsuario(){
        
           try{
          String sql = "select * from usuario limit ?,5";
          PreparedStatement st = getConnection().prepareStatement(sql);
        
               ResultSet rs = st.executeQuery();
                List<Usuario> lista = new ArrayList<Usuario>();
               
               while(rs.next()){
                   Usuario p = new Usuario();
                 
                   p.setNome(rs.getString(1));
                  
                   p.setSenha(rs.getString(2));
                   lista.add(p);
               }
               return lista;
               
      }  catch(Exception e){
          e.printStackTrace();
          return null;
      }
        
    }
}
