/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author hellk
 */
public class Ingrediente {

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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    private Integer id;
    private String nome;
    private String descricao;
    private List<Receita_Ingrediente> receitas;

    /**
     * @return the receitas
     */
    public List<Receita_Ingrediente> getReceitas() {
        return receitas;
    }

    /**
     * @param receitas the receitas to set
     */
    public void setReceitas(List<Receita_Ingrediente> receitas) {
        this.receitas = receitas;
    }
    
    
}
