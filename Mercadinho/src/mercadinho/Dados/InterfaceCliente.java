/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mercadinho.Dados;

import java.util.ArrayList;
import mercadinho.ClassesBasicas.Cliente;
import mercadinho.ClassesBasicas.BdException;
import mercadinho.ClassesBasicas.ClienteException;

/**
 *
 * @author Douglas
 */
public interface InterfaceCliente {
    
    void cadastrarCliente(Cliente cli) throws BdException, ClienteException;
    
    void removerCliente(String cpf) throws BdException, ClienteException;
    
    void alterarCliente(Cliente cli) throws BdException, ClienteException;
    
    ArrayList<Cliente> listarCliente(String filtro) throws BdException, ClienteException;
    
}
