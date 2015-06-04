/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dataAccess;

import br.com.servirjanuaria.amauri.domainModel.CertidaoNascimento;
import br.com.servirjanuaria.amauri.domainModel.repositorios.CertidaoNascimentoRepositorio;
import java.util.List;

/**
 *
 * @author Amauri
 */
public class CertidaoNascimentoDAO extends DaoGenerico<CertidaoNascimento> implements CertidaoNascimentoRepositorio{

    public CertidaoNascimentoDAO() {
        super(CertidaoNascimento.class);
    }

    @Override
    public List<CertidaoNascimento> buscar(CertidaoNascimento filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
