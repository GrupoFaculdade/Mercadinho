/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadinho.Dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mercadinho.ClassesBasicas.CamadaBanco;
import mercadinho.ClassesBasicas.Cliente;
import mercadinho.ClassesBasicas.ClienteException;

/**
 *
 * @author NeGo
 */
public class DadosCliente extends CamadaBanco {

    private Statement callBd;
    private String sqlQuery;
    private ResultSet getResult;

    public void cadastrarCliente(Cliente cli) throws ClienteException {

        try {

            callBd = conectar();
            sqlQuery = "INSERT INTO cliente VALUES"
                    + "('" + cli.getNome() + "','" + cli.getCpf() + "','" + cli.getRG() + "','" + cli.getEndcli().getBairro()
                    + ",'" + cli.getEndcli().getCep() + "', '" + cli.getEndcli().getCidade() + "', '" + cli.getEndcli().getLogradouro() + "'";
            callBd.execute(sqlQuery);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new ClienteException(ex.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new ClienteException(ex.getMessage());
            }
        }
    }

    public void removerCliente(String cpf) throws ClienteException {
        try {
            this.callBd = conectar();
            sqlQuery = "DELETE FROM clientes WHERE cpf = " + cpf + ";";
            callBd.executeQuery(sqlQuery);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ClienteException(ex.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new ClienteException(ex.getMessage());
            }
        }
    }

    public void alterarCliente(Cliente cli) throws ClienteException {
        try {
            callBd = conectar();
            sqlQuery = "UPDATE clientes SET nome = '" + cli.getNome() + "', rg = '" + cli.getRG() + "', bairro = '" + cli.getEndcli().getBairro() + "', "
                    + "cep = '" + cli.getEndcli().getCep() + "', cidade = '" + cli.getEndcli().getCidade() + "',"
                    + "logradouro = '" + cli.getEndcli().getLogradouro() + "', numero = '" + cli.getEndcli().getNumero() + "' WHERE cpf = '" + cli.getCpf() + "'";

        } catch (ClassNotFoundException | SQLException ex) {
            throw new ClienteException(ex.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new ClienteException(ex.getMessage());
            }
        }
    }

    public ArrayList<Cliente> Listar(String filtro) throws ClienteException {
        try {
            ArrayList<Cliente> listagem = new ArrayList<>();
            if (filtro.equals("")) {
                sqlQuery = "SELECT * FROM clientes;";
            } else {
                sqlQuery = "SELECT * FROM clientes WHERE nome = '%" + filtro + "%';";
            }

            callBd = conectar();
            getResult = callBd.executeQuery(sqlQuery);
            while (getResult.next()) {
                Cliente cli = new Cliente();
                cli.setNome(getResult.getString("nome"));
                cli.setCpf(getResult.getString("cpf"));
                cli.setRG(getResult.getString("rg"));
                cli.getEndcli().setBairro(getResult.getString("bairro"));
                cli.getEndcli().setCep(getResult.getString("cep"));
                cli.getEndcli().setCidade(getResult.getString("cidade"));
                cli.getEndcli().setLogradouro(getResult.getString("logradouro"));
                cli.getEndcli().setNumero(getResult.getString("numero"));
                listagem.add(cli);
            }
            return listagem;
        } catch (ClassNotFoundException | SQLException e) {
            throw new ClienteException(e.getMessage());
        }
    }

}
