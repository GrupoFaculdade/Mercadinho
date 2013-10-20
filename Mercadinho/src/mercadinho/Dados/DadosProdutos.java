/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadinho.Dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mercadinho.ClassesBasicas.CamadaBanco;
import mercadinho.ClassesBasicas.Produtos;
import mercadinho.ClassesBasicas.ProdutosException;

/**
 *
 * @author NeGo
 */
public class DadosProdutos extends CamadaBanco {
    
    private Statement callBd;
    private String sqlQuery;
    private ResultSet getResult;
    
     public void cadastrarProduto (Produtos p) throws ProdutosException {

        try {
            
            callBd = conectar();
            
            sqlQuery = "INSERT INTO Produtos VALUES";
            sqlQuery += "('"+p.getCodigoProduto()+"', '"+p.getNomeProduto()+"')";
           callBd.execute(sqlQuery);

        } catch(ClassNotFoundException | SQLException ex) {
            throw new ProdutosException(ex.getMessage());
        }finally{
            try {
                 desconectar();
               } catch (SQLException ex) {
                throw new ProdutosException(ex.getMessage());
            }
        }
    }   
     public void removerProduto(Produtos p) throws ProdutosException {
         
         try{
              callBd = conectar();
              sqlQuery ="DELETE FROM Produtos where codigoProduto = "+p.getCodigoProduto()+",";
              callBd.executeQuery(sqlQuery);
             
         }catch(ClassNotFoundException | SQLException ex){
             throw new ProdutosException(ex.getMessage());
         }finally{
             try{
                 desconectar();
             }catch(SQLException ex){
                 
                 throw new ProdutosException(ex.getMessage());
             }
         }
        
         
     }
     public void alterarProduto( Produtos p) throws ProdutosException{
         try{
             callBd = conectar();
             sqlQuery="UPDATE Produtos set nome = '"+ p.getCodigoProduto()+"', nomeProduto = '"+p.getNomeProduto()+"'";
         }catch(ClassNotFoundException | SQLException ex){
             throw new ProdutosException(ex.getMessage());
             
         }finally{
             try{
                 desconectar();
             }catch(SQLException ex){
                 
                 throw new ProdutosException(ex.getMessage());
             }
         }
         
     }
}
    
    
