
package sistema.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
}
