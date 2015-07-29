package DAO;

import Modelo.Cidade;
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
public class CidadeDAO {
    private Conexao Con;

    public CidadeDAO() {
    
        Con = new Conexao();
    }
    
    //METODO SALVAR
    public boolean salvarCidade(Cidade cidade){
     try {
         String sql = "INSERT INTO CIDADE(NOME, UF_CODIGO, CODIBGE)"
                 +"VALUES(?,?,?)";
         PreparedStatement stm = Con.getConnection().prepareStatement(sql);
         stm.setString(1, cidade.getNome());
         stm.setInt(2, cidade.getUf_codigo());
         stm.setInt(3, cidade.getCodibge());
         
         stm.execute();
         Con.getConnection().commit();
         
    return true;
         
     } catch (SQLException ex) {
         Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
     }
     return false;
    }
    
    //METODO EDITAR
    public boolean editarCidade(Cidade cidade){
     try {
         String sql = "UPDATE CIDADE SET NOME = ?, UF_CODIGO = ?, CODIBGE = ? WHERE CODIGO = ?;";
                 
         PreparedStatement stm = Con.getConnection().prepareStatement(sql);
         stm.setString(1, cidade.getNome());
         stm.setInt(2, cidade.getUf_codigo());
         stm.setInt(3, cidade.getCodibge());
         stm.setInt(4, cidade.getCodigo());
         
         stm.execute();
         Con.getConnection().commit();
         Con.desconecta();
         
    return true;
         
     } catch (SQLException ex) {
         Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
     }
     return false;
    }
    
     //metodo Excluir
    public boolean excluirCidade(Cidade cidade){
     try {
         String sql = "DELETE FROM CIDADE WHERE CODIGO = ?;";
                 
         PreparedStatement stm = Con.getConnection().prepareStatement(sql);
         stm.setInt(1, cidade.getCodigo());
         
         stm.execute();
         Con.getConnection().commit();
         
    return true;
         
     } catch (SQLException ex) {
         Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
     }
     return false;
    }
    
    //metodo Listar
    public List<Cidade> listarCidade(){
        List<Cidade> lista = new ArrayList<Cidade>();
     try {
         String sql = "SELECT * FROM CIDADE ORDER BY NOME;";
                 
         PreparedStatement stm = Con.getConnection().prepareStatement(sql);
         
         ResultSet rs = stm.executeQuery();
         
         while (rs.next()) {
             
             Cidade cid = new Cidade();
             cid.setCodigo(rs.getInt("CODIGO"));
             cid.setNome(rs.getString("NOME"));
             cid.setUf_codigo(rs.getInt("UF_CODIGO"));
             cid.setCodibge(rs.getInt("CODIBGE"));
             
             lista.add(cid);
         }
    }  catch (SQLException ex) {
         Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     return lista;
    }
}
