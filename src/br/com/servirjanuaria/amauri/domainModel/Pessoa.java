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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Amauri
 */
@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "sexo", length = 1, nullable = true)
    private String sexo;

    @Column(name = "rg", length = 11, nullable = false, unique = true)
    private String rg;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento", nullable = true)
    private Date dataNascimento;    

    @ManyToOne
    private Endereco endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return ("M".equals(sexo)) ? "Masculino" : "Feminino";
    }

    public void setSexo(String sexo) {
        if ("Masculino".equals(sexo)) {
            this.sexo = "M";
        } else {
            this.sexo = "F";
        }
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        if (cpf.length() < 11) {
            return "";
        }
        return cpf.substring(0, 3).concat(".")
                + cpf.substring(3, 6).concat(".")
                + cpf.substring(6, 9).concat("-")
                + cpf.substring(9, 11);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.replace(".", "").replace("-", "");
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.servirjanuaria.amauri.domainModel.Pessoa[ id=" + id + " ]";
    }

}
