/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mercadinho.Negocios;

import mercadinho.ClassesBasicas.Funcionario;
import mercadinho.ClassesBasicas.FuncionarioException;
import mercadinho.Dados.DadosFuncionario;

/**
 *
 * @author Douglas
 */
public class NegocioFuncionario {
    
    DadosFuncionario dados;
    
    public NegocioFuncionario(){
        dados = new DadosFuncionario();
    }
    
    public void cadastrarFornecedor(Funcionario forn) throws FuncionarioException {
        //Validações:
        
        //-----
        dados.cadastrarFuncionario(forn);
    }
    public void removerFornecedor(String codFornecedor) throws FuncionarioException {
        //Validações:
        
        //-----
        dados.removerCliente(codFornecedor);
    }
    public void alterarFornecedor(Funcionario forn) throws FuncionarioException {
       //Validações:
        
        //----- 
        dados.alterarCliente(forn);
    }
    public void listarCliente(String filtro) throws FuncionarioException {
       //Validações:
        
        //-----
        dados.listarFuncionario(filtro);
    }
    
}
