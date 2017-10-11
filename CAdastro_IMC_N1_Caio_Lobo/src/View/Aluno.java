/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author hellk
 */
@Entity
@Table(name = "aluno", catalog = "IMCDB", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a")
    , @NamedQuery(name = "Aluno.findById", query = "SELECT a FROM Aluno a WHERE a.id = :id")
    , @NamedQuery(name = "Aluno.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome")
    , @NamedQuery(name = "Aluno.findByMassa", query = "SELECT a FROM Aluno a WHERE a.massa = :massa")
    , @NamedQuery(name = "Aluno.findByEstatura", query = "SELECT a FROM Aluno a WHERE a.estatura = :estatura")
    , @NamedQuery(name = "Aluno.findByIdade", query = "SELECT a FROM Aluno a WHERE a.idade = :idade")
    , @NamedQuery(name = "Aluno.findBySexo", query = "SELECT a FROM Aluno a WHERE a.sexo = :sexo")
    , @NamedQuery(name = "Aluno.findByImc", query = "SELECT a FROM Aluno a WHERE a.imc = :imc")})
public class Aluno implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "massa")
    private Float massa;
    @Column(name = "estatura")
    private Float estatura;
    @Column(name = "idade")
    private Integer idade;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "imc")
    private Float imc;

    public Aluno() {
    }

    public Aluno(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public Float getMassa() {
        return massa;
    }

    public void setMassa(Float massa) {
        Float oldMassa = this.massa;
        this.massa = massa;
        changeSupport.firePropertyChange("massa", oldMassa, massa);
    }

    public Float getEstatura() {
        return estatura;
    }

    public void setEstatura(Float estatura) {
        Float oldEstatura = this.estatura;
        this.estatura = estatura;
        changeSupport.firePropertyChange("estatura", oldEstatura, estatura);
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        Integer oldIdade = this.idade;
        this.idade = idade;
        changeSupport.firePropertyChange("idade", oldIdade, idade);
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        String oldSexo = this.sexo;
        this.sexo = sexo;
        changeSupport.firePropertyChange("sexo", oldSexo, sexo);
    }

    public Float getImc() {
        return imc;
    }

    public void setImc(Float imc) {
        Float oldImc = this.imc;
        this.imc = imc;
        changeSupport.firePropertyChange("imc", oldImc, imc);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Aluno[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
