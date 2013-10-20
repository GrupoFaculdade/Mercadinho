/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mercadinho.Negocios;

import mercadinho.ClassesBasicas.Cliente;
import mercadinho.ClassesBasicas.ClienteException;
import mercadinho.Dados.DadosCliente;

/**
 *
 * @author Douglas
 */
public class NegocioCliente {
    DadosCliente dados;
    
    public NegocioCliente(){
        dados = new DadosCliente();
    }
    
    public void cadastrarFornecedor(Cliente forn) throws ClienteException {
        //Validações:
        
        //-----
        dados.cadastrarCliente(forn);
    }
    public void removerFornecedor(String codFornecedor) throws ClienteException {
        //Validações:
        
        //-----
        dados.removerCliente(codFornecedor);
    }
    public void alterarFornecedor(Cliente forn) throws ClienteException {
       //Validações:
        
        //----- 
        dados.alterarCliente(forn);
    }
    public void listarCliente(String filtro) throws ClienteException {
       //Validações:
        
        //-----
        dados.listarCliente(filtro);
    }
    
}
