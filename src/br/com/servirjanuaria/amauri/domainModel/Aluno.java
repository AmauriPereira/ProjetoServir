/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.domainModel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Amauri
 */
@Entity
@Table(name = "alunos")
public class Aluno extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "etnia", nullable = false)
    private String etnia;

    @Column(name = "cidade_nascimento", nullable = false)
    private String cidadeNascimento;

    @Column(name = "estados", length = 2, nullable = false)
    private String estado;

    @Column(name = "nacionalidade", nullable = false)
    private String nacionalidade;

    @Column(name = "fotos", nullable = true)
    private String foto;

    @Column(name = "status", length = 7, nullable = true)
    private String status;

    @ManyToOne()
    private CertidaoNascimento certidaoNascimento;

    @ManyToOne()
    private Pessoa pessoa;

    @ManyToMany
    @JoinTable(name = "aluno_has_programaSocial", joinColumns = {
        @JoinColumn(name = "aluno_id")}, inverseJoinColumns = {
        @JoinColumn(name = "programaSocial_id")})
    private List<ProgramaSocial> ListaProgramasSociais;

    @ManyToMany
    @JoinTable(name = "aluno_has_deficiencia", joinColumns = {
        @JoinColumn(name = "cliente_id")}, inverseJoinColumns = {
        @JoinColumn(name = "deficiencia_id")})
    private List<Deficiencia> listaDeficiencia;

    @ManyToOne()
    private Pai pai;

    @ManyToOne()
    private Mae mae;

    @Override
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public CertidaoNascimento getCertidaoNascimento() {
        return certidaoNascimento;
    }

    public void setCertidaoNascimento(CertidaoNascimento certidaoNascimento) {
        this.certidaoNascimento = certidaoNascimento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<ProgramaSocial> getListaProgramasSociais() {
        return ListaProgramasSociais;
    }

    public void setListaProgramasSociais(List<ProgramaSocial> ListaProgramasSociais) {
        this.ListaProgramasSociais = ListaProgramasSociais;
    }

    public List<Deficiencia> getListaDeficiencia() {
        return listaDeficiencia;
    }

    public void setListaDeficiencia(List<Deficiencia> listaDeficiencia) {
        this.listaDeficiencia = listaDeficiencia;
    }

    public Pai getPai() {
        return pai;
    }

    public void setPai(Pai pai) {
        this.pai = pai;
    }

    public Mae getMae() {
        return mae;
    }

    public void setMae(Mae mae) {
        this.mae = mae;
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
        return "Alunos";
    }

}
