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
import mercadinho.ClassesBasicas.Funcionario;
import mercadinho.ClassesBasicas.BdException;

/**
 *
 * @author NeGo
 */
public class DadosFuncionario extends CamadaBanco {

    private Statement callBd;
    private String sqlQuery;
    private ResultSet getResult;

    public void cadastrarFuncionario(Funcionario func) throws BdException {
        try {
            callBd = conectar();
            sqlQuery = "INSERT INTO Funcionarios VALUES"
                    +"('" + func.getMatricula() + "','" + func.getNome() + "','" + func.getCpf() + "','" + func.getRG() + "','" + func.getEndfun().getBairro() + "'"
             + ",'" + func.getEndfun().getCep() + "', '" + func.getEndfun().getCidade() + "', '" + func.getEndfun().getLogradouro() + "'";
            callBd.execute(sqlQuery);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new BdException(ex.getMessage());
        }
    }
    
    public void removerCliente(String matricula) throws BdException {
        try {
            this.callBd = conectar();
            sqlQuery = "DELETE FROM funcionarios WHERE matricula = " + matricula + " ;";
            callBd.execute(sqlQuery);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new BdException(ex.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new BdException(ex.getMessage());
            }
        }
    }
    
    public void alterarCliente(Funcionario cli) throws BdException {
        try {
            callBd = conectar();
            sqlQuery = "UPDATE funcionarios SET nome = '" + cli.getNome() + "', rg = '" + cli.getRG() + "', bairro = '" + cli.getEndfun().getBairro() + "', "
                    + "cep = '" + cli.getEndfun().getCep() + "', cidade = '" + cli.getEndfun().getCidade() + "',"
                    + "logradouro = '" + cli.getEndfun().getLogradouro() + "', numero = '" + cli.getEndfun().getNumero() + "', cpf = '" + cli.getCpf() + "'"
                    + "WHERE matricula = "+cli.getMatricula()+" ;";

           
        } catch (ClassNotFoundException | SQLException ex) {
            throw new BdException(ex.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new BdException(ex.getMessage());
            }
        }
    }
    
    public ArrayList<Funcionario> listarFuncionario(String filtro) throws BdException {
        try {
            ArrayList<Funcionario> listagem = new ArrayList<>();
            if (filtro.equals("")) {
                sqlQuery = "SELECT * FROM funcionarios;";
            } else {
                sqlQuery = "SELECT * FROM funcionarios WHERE nome LIKE '%" + filtro + "%';";
            }

            callBd = conectar();
            getResult = callBd.executeQuery(sqlQuery);
            while (getResult.next()) {
                Funcionario fun = new Funcionario();
                fun.setMatricula(getResult.getInt("matricula"));
                fun.setNome(getResult.getString("nome"));
                fun.setCpf(getResult.getString("cpf"));
                fun.setRG(getResult.getString("rg"));
                fun.getEndfun().setBairro(getResult.getString("bairro"));
                fun.getEndfun().setCep(getResult.getString("cep"));
                fun.getEndfun().setCidade(getResult.getString("cidade"));
                fun.getEndfun().setLogradouro(getResult.getString("logradouro"));
                fun.getEndfun().setNumero(getResult.getString("numero"));
                listagem.add(fun);
            }
            return listagem;
        } catch (ClassNotFoundException | SQLException e) {
            throw new BdException(e.getMessage());
        }
    }
}
