/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadinho.Negocios;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mercadinho.ClassesBasicas.Cliente;
import mercadinho.ClassesBasicas.BdException;
import mercadinho.ClassesBasicas.ClienteException;
import mercadinho.Dados.DadosCliente;
import mercadinho.Dados.InterfaceCliente;

/**
 *
 * @author Douglas
 */
public class NegocioCliente implements InterfaceCliente {

    DadosCliente dados;

    public NegocioCliente() {
        dados = new DadosCliente();
    }

    @Override
    public void cadastrarCliente(Cliente cli) throws BdException, ClienteException {
        dados.cadastrarCliente(cli); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerCliente(String cpf) throws BdException, ClienteException {
        dados.removerCliente(cpf); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterarCliente(Cliente cli) throws BdException, ClienteException {
         dados.alterarCliente(cli); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cliente> listarCliente(String filtro) throws BdException, ClienteException {
               return dados.listarCliente(filtro);
    }
    
    public boolean verificarCpf(String cpf) throws BdException, SQLException {
        boolean existe = false;
        try {
            
            Statement callBd = dados.conectar();
            String sqlQuery = "SELECT cpf FROM cliente WHERE cpf = '"+cpf+"' ;";
            if(callBd.execute(sqlQuery) == true){
                existe = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
        }finally{
            dados.desconectar();
             return existe;
        }
       
    }

    

}
