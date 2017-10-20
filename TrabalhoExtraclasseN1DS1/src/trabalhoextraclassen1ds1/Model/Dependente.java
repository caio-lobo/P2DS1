/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoextraclassen1ds1.Model;

/**
 *
 * @author hellk
 */
public class Dependente {

    /**
     * @return the cpf
     */
    public Integer getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the responsaveis
     */
    public Funcionario_Dependente getResponsaveis() {
        return responsaveis;
    }

    /**
     * @param responsaveis the responsaveis to set
     */
    public void setResponsaveis(Funcionario_Dependente responsaveis) {
        this.responsaveis = responsaveis;
    }
    private Integer cpf;
    private String nome;
    private Funcionario_Dependente responsaveis;
    
}
