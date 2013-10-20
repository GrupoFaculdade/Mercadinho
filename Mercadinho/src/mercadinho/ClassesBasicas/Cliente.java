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
public class Cliente {
    
    private String nome;
    private String cpf;
    private String rg;
    private Endereco endcli;

    /**
     * @return the Nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.nome = Nome;
    }

    /**
     * @return the Cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param Cpf the Cpf to set
     */
    public void setCpf(String Cpf) {
        this.cpf = Cpf;
    }

    /**
     * @return the RG
     */
    public String getRG() {
        return rg;
    }

    /**
     * @param RG the RG to set
     */
    public void setRG(String RG) {
        this.rg = RG;
    }

    /**
     * @return the endcli
     */
    public Endereco getEndcli() {
        return endcli;
    }

    /**
     * @param endcli the endcli to set
     */
    public void setEndcli(Endereco endcli) {
        this.endcli = endcli;
    }
    
    
}
