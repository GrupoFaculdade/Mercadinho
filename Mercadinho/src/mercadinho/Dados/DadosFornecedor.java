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
import mercadinho.ClassesBasicas.Fornecedor;
import mercadinho.ClassesBasicas.FornecedorException;

/**
 *
 * @author NeGo
 */
public class DadosFornecedor extends CamadaBanco {

    private Statement callBd;
    private String sqlQuery;
    private ResultSet getResult;

    public void cadastrarFornecedor(Fornecedor forn) throws FornecedorException {

        try {
            callBd = conectar();
            sqlQuery = "INSERT INTO fornecedores VALUES"
            + "('" + forn.getCodigoFornecedor() + "','" + forn.getNome() + "')";
            callBd.execute(sqlQuery);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new FornecedorException(ex.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new FornecedorException(ex.getMessage());
            }

        }

    }
    
     public void removerFornecedor(String codForn) throws FornecedorException {
        try {
            this.callBd = conectar();
            sqlQuery = "DELETE FROM fornecedores WHERE codFornecedor = " + codForn + ";";
            callBd.execute(sqlQuery);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new FornecedorException(ex.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new FornecedorException(ex.getMessage());
            }
        }
    }
    
    public void alterarFornecedor(Fornecedor forn) throws FornecedorException {
        try {
            callBd = conectar();
            sqlQuery = "UPDATE fornecedores SET nome = '"+forn.getNome()+"' WHERE codFornecedor = "+forn.getCodigoFornecedor()+" ;"; 

        } catch (ClassNotFoundException | SQLException ex) {
            throw new FornecedorException(ex.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new FornecedorException(ex.getMessage());
            }
        }
    }
    
    public ArrayList<Fornecedor> listarFornecedor(String filtro) throws FornecedorException {
        try {
            ArrayList<Fornecedor> listagem = new ArrayList<>();
            if (filtro.equals("")) {
                sqlQuery = "SELECT * FROM fornecedores;";
            } else {
                sqlQuery = "SELECT * FROM fornecedores WHERE nome LIKE '%" + filtro + "%';";
            }

            callBd = conectar();
            getResult = callBd.executeQuery(sqlQuery);
            while (getResult.next()) {
                Fornecedor forn = new Fornecedor();
                forn.setNome(getResult.getString("nome"));
                forn.setCodigoFornecedor(getResult.getString("codFornecedor"));
                listagem.add(forn);
            }
            return listagem;
        } catch (ClassNotFoundException | SQLException e) {
            throw new FornecedorException(e.getMessage());
        }
    }
}
