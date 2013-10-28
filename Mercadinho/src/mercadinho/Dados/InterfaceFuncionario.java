/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mercadinho.Dados;

import java.util.ArrayList;
import mercadinho.ClassesBasicas.BdException;
import mercadinho.ClassesBasicas.Funcionario;

/**
 *
 * @author Douglas
 */
public interface InterfaceFuncionario {
    
   void cadastrarFuncionario(Funcionario func) throws BdException;
   void removerCliente(String matricula) throws BdException;
   void alterarCliente(Funcionario cli) throws BdException;
   ArrayList<Funcionario> listarFuncionario(String filtro) throws BdException;
    
    
}
