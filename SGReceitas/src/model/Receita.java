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
public class Receita {

    /**
     * @param ingredientes the ingredientes to set
     */
    public void setIngredientes(List<Receita_Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
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
     * @return the ingredientes
     */
    public List<Receita_Ingrediente> getIngredientes() {
        return ingredientes;
    }


    /**
     * @return the preparo
     */
    public String getPreparo() {
        return preparo;
    }

    /**
     * @param preparo the preparo to set
     */
    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }

    /**
     * @return the modoServir
     */
    public String getModoServir() {
        return modoServir;
    }

    /**
     * @param modoServir the modoServir to set
     */
    public void setModoServir(String modoServir) {
        this.modoServir = modoServir;
    }

    /**
     * @return the cat
     */
    public Categoria getCat() {
        return cat;
    }

    /**
     * @param cat the cat to set
     */
    public void setCat(Categoria cat) {
        this.cat = cat;
    }
    
    private Integer id;
    private String nome;
    private List<Receita_Ingrediente> ingredientes;
    private String preparo;
    private String modoServir;
    private Categoria cat;
    
}
