/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.sql.JDBCType.NULL;
import java.util.List;

/**
 *
 * @author hellk
 */
public class Categoria {

    /**
     * @param receitas the receitas to set
     */
    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

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

    /**
     * @return the receitas
     */
    public List<Receita> getReceitas() {
        return receitas;
    }

    private Integer id;
    private String nome;
    private String descricao;
    List<Receita> receitas;

public boolean equals(Object outro){
    if(!(outro instanceof Categoria)){
        return false;
    }
    Categoria o = (Categoria)outro;
    if((this.id == null && o.getId() != null)||(this.getId()!=null && o.getId().equals(this))){
    return false;
    }
    return true;
}
    
}

