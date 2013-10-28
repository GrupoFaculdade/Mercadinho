/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mercadinho.Negocios;

import java.util.ArrayList;
import mercadinho.ClassesBasicas.Fornecedor;
import mercadinho.ClassesBasicas.BdException;
import mercadinho.ClassesBasicas.FornecedorException;
import mercadinho.Dados.DadosFornecedor;
import mercadinho.Dados.InterfaceFornecedor;

/**
 *
 * @author Douglas
 */
public class NegocioFornecedor implements InterfaceFornecedor {
    DadosFornecedor dados;
    
    public NegocioFornecedor(){
        dados = new DadosFornecedor();
    }
    
    @Override
    public void cadastrarFornecedor(Fornecedor forn) throws BdException, FornecedorException {
        //Validações:
        
        //-----
        dados.cadastrarFornecedor(forn);
    }
    public void removerFornecedor(String codFornecedor) throws BdException, FornecedorException {
        //Validações:
        
        //-----
        dados.removerFornecedor(codFornecedor);
    }
    @Override
    public void alterarFornecedor(Fornecedor forn) throws BdException, FornecedorException {
       //Validações:
        
        //----- 
        dados.alterarFornecedor(forn);
    }
    @Override
    public ArrayList<Fornecedor> listarFornecedor(String filtro) throws BdException, FornecedorException {
       //Validações:
        
        //-----
        return dados.listarFornecedor(filtro);
    }
}
