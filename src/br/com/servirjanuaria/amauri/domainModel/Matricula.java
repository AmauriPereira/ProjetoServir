/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.domainModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Amauri
 */
@Entity
@Table(name = "matriculas")
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ano")
    private String ano;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_matricula", nullable = false)
    private Date dataMatricula;

    @Column(name = "serie", length = 10, nullable = false)
    private String serie;

    @Column(name = "turno", nullable = false)
    private int turno;

    @Column(name = "egresso_rede", nullable = false)
    private String egressoRede;

    @ManyToOne()
    private UnidadeEscolar unidadeEscolar;

    @ManyToOne()
    private Aluno aluno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {

        this.serie = serie;
    }

    public int getTurno() {

        return turno;
    }

    public void setTurno(String turno) {
        if (null != turno) {
            switch (turno) {
                case "Matutino":
                    this.turno = 1;
                    break;
                case "Vespertino":
                    this.turno = 2;
                    break;
                case "Noturno":
                    this.turno = 3;
                    break;
            }
        }

    }

    public String getEgressoRede() {
        return egressoRede;
    }

    public void setEgressoRede(String egressoRede) {
        this.egressoRede = egressoRede;
    }

    public UnidadeEscolar getUnidadeEscolar() {
        return unidadeEscolar;
    }

    public void setUnidadeEscolar(UnidadeEscolar unidadeEscolar) {
        this.unidadeEscolar = unidadeEscolar;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.servirjanuaria.amauri.entidade.Matricula[ id=" + id + " ]";
    }

}
