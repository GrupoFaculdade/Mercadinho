/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mercadinho.Dados;

import java.util.ArrayList;
import mercadinho.ClassesBasicas.BdException;
import mercadinho.ClassesBasicas.Fornecedor;
import mercadinho.ClassesBasicas.FornecedorException;

/**
 *
 * @author Douglas
 */
public interface InterfaceFornecedor {
    
    void cadastrarFornecedor(Fornecedor forn) throws BdException, FornecedorException;
    public void removerFornecedor(String codForn) throws BdException, FornecedorException;
    public void alterarFornecedor(Fornecedor forn) throws BdException, FornecedorException;
    public ArrayList<Fornecedor> listarFornecedor(String filtro) throws BdException, FornecedorException;
}
