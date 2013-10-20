/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mercadinho.Negocios;

import mercadinho.ClassesBasicas.Fornecedor;
import mercadinho.ClassesBasicas.FornecedorException;
import mercadinho.Dados.DadosFornecedor;

/**
 *
 * @author Douglas
 */
public class NegocioFornecedor {
    DadosFornecedor dados;
    
    public NegocioFornecedor(){
        dados = new DadosFornecedor();
    }
    
    public void cadastrarFornecedor(Fornecedor forn) throws FornecedorException {
        //Validações:
        
        //-----
        dados.cadastrarFornecedor(forn);
    }
    public void removerFornecedor(String codFornecedor) throws FornecedorException {
        //Validações:
        
        //-----
        dados.removerFornecedor(codFornecedor);
    }
    public void alterarFornecedor(Fornecedor forn) throws FornecedorException {
       //Validações:
        
        //----- 
        dados.alterarFornecedor(forn);
    }
    public void listarFornecedor(String filtro) throws FornecedorException {
       //Validações:
        
        //-----
        dados.listarFornecedor(filtro);
    }
}
