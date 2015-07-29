package DAO;

import Modelo.Estado;
import Util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francisco Junior
 */
public class EstadoDAO {
    private Conexao Con;

    public EstadoDAO() {
    Con = new Conexao();
    }
//METODO SALVAR
    public boolean salvarContato(Estado estado){
     try {
         String sql = "INSERT INTO UF(NOME, SIGLA, CODIBGE)"
                 +"VALUES(?,?,?)";
         PreparedStatement stm = Con.getConnection().prepareStatement(sql);
         stm.setString(1, estado.getNome());
         stm.setString(2, estado.getSigla());
         stm.setInt(3, estado.getCodibge());
         
         stm.execute();
         Con.getConnection().commit();
         
    return true;
         
     } catch (SQLException ex) {
         Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
     }
     return false;
    }
    
    //METODO EDITAR
    public boolean editarEstado(Estado estado){
     try {
         String sql = "UPDATE UF SET NOME = ?, SIGLA = ?, CODIBGE = ? WHERE CODIGO = ?;";
                 
         PreparedStatement stm = Con.getConnection().prepareStatement(sql);
         stm.setString(1, estado.getNome());
         stm.setString(2, estado.getSigla());
         stm.setInt(3, estado.getCodibge());
         stm.setInt(4, estado.getCodigo());
         
         stm.execute();
         Con.getConnection().commit();
         Con.desconecta();
         
    return true;
         
     } catch (SQLException ex) {
         Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
     }
     return false;
    }
    
    //metodo Excluir
    public boolean excluirEstado(Estado estado){
     try {
         String sql = "DELETE FROM uf WHERE CODIGO = ?;";
                 
         PreparedStatement stm = Con.getConnection().prepareStatement(sql);
         stm.setInt(1, estado.getCodigo());
         
         stm.execute();
         Con.getConnection().commit();
         
    return true;
         
     } catch (SQLException ex) {
         Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
     }
     return false;
    }
    
    //metodo Listar
    public List<Estado> listarEstado(){
        List<Estado> lista = new ArrayList<Estado>();
     try {
         String sql = "SELECT * FROM uf ORDER BY NOME;";
                 
         PreparedStatement stm = Con.getConnection().prepareStatement(sql);
         
         ResultSet rs = stm.executeQuery();
         
         while (rs.next()) {
             
             Estado est = new Estado();
             est.setCodigo(rs.getInt("CODIGO"));
             est.setNome(rs.getString("NOME"));
             est.setSigla(rs.getString("SIGLA"));
             est.setCodibge(rs.getInt("CODIBGE"));
             
             lista.add(est);
         }
    }  catch (SQLException ex) {
         Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     return lista;
    }
    
}
