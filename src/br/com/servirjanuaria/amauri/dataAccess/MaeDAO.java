/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dataAccess;

import br.com.servirjanuaria.amauri.domainModel.Mae;
import br.com.servirjanuaria.amauri.domainModel.repositorios.MaeRepositorio;
import java.util.List;

/**
 *
 * @author Amauri
 */
public class MaeDAO extends DaoGenerico<Mae> implements MaeRepositorio{

    public MaeDAO() {
        super(Mae.class);
    }

    @Override
    public List<Mae> buscar(Mae filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
