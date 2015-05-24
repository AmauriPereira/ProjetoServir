/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dataAccess;

import br.com.servirjanuaria.amauri.domainModel.UnidadeEscolar;
import br.com.servirjanuaria.amauri.domainModel.repositorios.UnidadeEscolarRepositorio;
import java.util.List;

/**
 *
 * @author Amauri
 */
public class UnidadeEscolarDAO extends DaoGenerico<UnidadeEscolar> implements UnidadeEscolarRepositorio {

    public UnidadeEscolarDAO() {
        super(UnidadeEscolar.class);
    }

    @Override
    public List<UnidadeEscolar> buscar(UnidadeEscolar filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
