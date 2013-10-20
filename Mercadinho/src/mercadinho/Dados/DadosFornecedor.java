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
public class DadosFornecedor extends CamadaBanco {


    public void cadastrarFornecedor(Fornecedor f) throws FornecedorExeception {

        try {
            Statement conex = conectar();
            String sql = "INSERT INTO fornecedores VALUES";
            sql += "('" + f.getCodigoFornecedor() + "','" + f.getNome() + "')";
            conex.executeQuery(sql);

        } catch (Exception ex) {

            throw new FornecedorExeception(ex.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new FornecedorExeception(ex.getMessage());
            }

        }

    }
}
