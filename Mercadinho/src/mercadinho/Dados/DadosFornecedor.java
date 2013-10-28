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
import mercadinho.ClassesBasicas.BdException;

/**
 *
 * @author NeGo
 */
public class DadosFornecedor extends CamadaBanco implements InterfaceFornecedor {

    private Statement callBd;
    private String sqlQuery;
    private ResultSet getResult;

    @Override
    public void cadastrarFornecedor(Fornecedor forn) throws BdException {

        try {
            callBd = conectar();
            sqlQuery = "INSERT INTO fornecedores VALUES"
            + "('" + forn.getCodigoFornecedor() + "','" + forn.getNome() + "')";
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
    
    @Override
     public void removerFornecedor(String codForn) throws BdException {
        try {
            this.callBd = conectar();
            sqlQuery = "DELETE FROM fornecedores WHERE codFornecedor = " + codForn + ";";
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
    
    @Override
    public void alterarFornecedor(Fornecedor forn) throws BdException {
        try {
            callBd = conectar();
            sqlQuery = "UPDATE fornecedores SET nome = '"+forn.getNome()+"' WHERE codFornecedor = "+forn.getCodigoFornecedor()+" ;"; 

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
    @Override
    public ArrayList<Fornecedor> listarFornecedor(String filtro) throws BdException {
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
            throw new BdException(e.getMessage());
        }
    }
}
