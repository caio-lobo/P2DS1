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
public class Funcionario_Dependente {

    /**
     * @return the responsavel1
     */
    public Funcionario getResponsavel1() {
        return responsavel1;
    }

    /**
     * @param responsavel1 the responsavel1 to set
     */
    public void setResponsavel1(Funcionario responsavel1) {
        this.responsavel1 = responsavel1;
    }

    /**
     * @return the responsavel2
     */
   

    /**
     * @return the dependente
     */
    public Dependente getDependente() {
        return dependente;
    }

    /**
     * @param dependente the dependente to set
     */
    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }
    private Funcionario responsavel1;
    private Dependente dependente;
    
}
