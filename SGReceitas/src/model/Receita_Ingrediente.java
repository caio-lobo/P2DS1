/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hellk
 */
public class Receita_Ingrediente {

    /**
     * @return the ingrediente
     */
    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    /**
     * @param ingrediente the ingrediente to set
     */
    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    /**
     * @return the receita
     */
    public Receita getReceita() {
        return receita;
    }

    /**
     * @param receita the receita to set
     */
    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    /**
     * @return the quantidade
     */
    public Integer getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    private Ingrediente ingrediente;
    private Receita receita;
    private Integer quantidade;
    private String unidade;
    
    
    
}
