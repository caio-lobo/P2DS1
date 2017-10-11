/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hellk
 */
public class Aluno {

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
     * @return the massa
     */
    public float getMassa() {
        return massa;
    }

    /**
     * @param massa the massa to set
     */
    public void setMassa(float massa) {
        this.massa = massa;
    }

    /**
     * @return the estatura
     */
    public float getEstatura() {
        return estatura;
    }

    /**
     * @param estatura the estatura to set
     */
    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    /**
     * @return the idade
     */
    public Integer getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    private Integer id;
    private String nome;
    private float massa;
    private float estatura;
    private Integer idade;
    private String sexo;
    private float imc;

    /**
     * @return the imc
     */
    public float getImc() {
        return imc;
    }

    /**
     * @param imc the imc to set
     */
    public void setNewImc() {
        this.imc = this.massa/(this.estatura * 2);
    }
    
    
    public void setImc(float imc) {
        this.imc = imc;
    }
    
}
