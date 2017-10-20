/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoextraclassen1ds1.Model;

import java.util.List;

/**
 *
 * @author hellk
 */
public class Funcionario {

    /**
     * @return the cpf
     */
    public int getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(int cpf) {
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
     * @return the departamento
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the dependentes
     */
    public List<Funcionario_Dependente> getDependentes() {
        return dependentes;
    }

    /**
     * @param dependentes the dependentes to set
     */
    public void setDependentes(List<Funcionario_Dependente> dependentes) {
        this.dependentes = dependentes;
    }
    
    private int cpf;
    private String nome;
    private Departamento departamento;
    private List<Funcionario_Dependente> dependentes;
    
    
}
