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
public class Departamento {

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return the gerente
     */
    public Funcionario getGerente() {
        return gerente;
    }

    /**
     * @param gerente the gerente to set
     */
    public void setGerente(Funcionario gerente) {
        this.gerente = gerente;
    }

    /**
     * @return the funcionarios
     */
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    /**
     * @param funcionarios the funcionarios to set
     */
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    private Integer id;
    private String nome;
    private Funcionario gerente;
    private List<Funcionario> funcionarios;
    
}
