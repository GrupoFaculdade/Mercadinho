/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadinho.Dados;

import java.sql.Statement;
import mercadinho.ClassesBasicas.CamadaBanco;
import java.sql.ResultSet;
import java.sql.SQLException;
import mercadinho.ClassesBasicas.SetorProdutoException;
import mercadinho.ClassesBasicas.SetorProdutos;

/**
 *
 * @author NeGo
 */
public class DadosSetor  extends CamadaBanco {
    
    private Statement callBd;
    private String sqlQuery;
   private ResultSet getResultSet;
   
   
   public void  cadastrarSetor (SetorProdutos sec) throws SetorProdutoException{
       try{
           callBd =conectar();
           sqlQuery="INSERT INTO SetorProdutos VALUES";
            sqlQuery += "('"+sec.getCodigoSetor()+"', '"+sec.getNome()+"')";
            callBd.executeQuery(sqlQuery);
       }catch(ClassNotFoundException | SQLException ex){
           throw new SetorProdutoException(ex.getMessage());
           
       }finally{
           try{
               
               desconectar();
               
           }catch(SQLException ex){
               throw new SetorProdutoException(ex.getMessage());
           }
       }
           
         
       
   }
   public void  removerSetor(SetorProdutos sec) throws SetorProdutoException{
       try{
           callBd =conectar();
           sqlQuery="DELETE FROM SetorProdutos WHERE SetorProdutos = "+sec.getCodigoSetor()+",";
       }catch(ClassNotFoundException  | SQLException ex){
           throw new SetorProdutoException(ex.getMessage());
       }finally{
           try{
               desconectar();
           }catch(SQLException ex){
               throw new SetorProdutoException(ex.getMessage());
           }
       }
   }
    public void alterarSetor(SetorProdutos sec) throws SetorProdutoException{
        try{
            callBd=conectar();
            sqlQuery="PDATE SetorProdutos set nome ="+sec.getNome()+"',codigoSetor"+sec.getCodigoSetor()+"',";
        }catch(ClassNotFoundException | SQLException ex){
            throw new SecurityException(ex.getMessage());
            
        }finally{
            try{
                desconectar();
            }catch(SQLException ex){
                throw new SetorProdutoException(ex.getMessage());
            }
        }
    }
}
