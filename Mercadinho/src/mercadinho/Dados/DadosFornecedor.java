/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadinho.Dados;

import java.sql.SQLException;
import java.sql.Statement;
import mercadinho.ClassesBasicas.CamadaBanco;
import mercadinho.ClassesBasicas.Fornecedor;
import mercadinho.ClassesBasicas.FornecedorExeception;

/**
 *
 * @author NeGo
 */
public class DadosFornecedor {

    private CamadaBanco banco = new CamadaBanco();

    public void cadastrarFornecedor(Fornecedor f) throws FornecedorExeception {

        try {
            Statement conex = banco.conectar();
            String sql = "insert into Cliente values";
            sql += "('" + f.getCodigoFornecedor() + "','" + f.getNome() + "')";
            conex.executeQuery(sql);

        } catch (Exception ex) {

            throw new FornecedorExeception(ex.getMessage());
        } finally {
            try {
                banco.desconectar();
            } catch (SQLException ex) {
                throw new FornecedorExeception(ex.getMessage());
            }

        }

    }
}
