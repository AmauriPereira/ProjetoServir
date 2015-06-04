/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dataAccess;

import br.com.servirjanuaria.amauri.domainModel.Bairro;
import br.com.servirjanuaria.amauri.domainModel.repositorios.BairroRepositorio;
import java.util.List;

/**
 *
 * @author Amauri
 */
public class BairroDAO extends DaoGenerico<Bairro> implements BairroRepositorio {

    public BairroDAO() {
        super(Bairro.class);
    }

    @Override
    public List<Bairro> buscar(Bairro filtro) {

        try {
            return buscar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
