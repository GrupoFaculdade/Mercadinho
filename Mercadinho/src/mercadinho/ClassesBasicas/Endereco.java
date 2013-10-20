/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadinho.ClassesBasicas;

/**
 *
 * @author NeGo
 */
public class Endereco {
    
    private String bairro;
    private String cidade;
    private String numero;
    private String logradouro;
    private String cep;


    /**
     * @return the Bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param Bairro the Bairro to set
     */
    public void setBairro(String Bairro) {
        this.bairro = Bairro;
    }

    /**
     * @return the Cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param Cidade the Cidade to set
     */
    public void setCidade(String Cidade) {
        this.cidade = Cidade;
    }

    /**
     * @return the Numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param Numero the Numero to set
     */
    public void setNumero(String Numero) {
        this.numero = Numero;
    }

    /**
     * @return the Logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param Logradouro the Logradouro to set
     */
    public void setLogradouro(String Logradouro) {
        this.logradouro = Logradouro;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }
    
}
