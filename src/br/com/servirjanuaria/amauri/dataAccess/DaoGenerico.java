/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dataAccess;

import br.com.servirjanuaria.amauri.domainModel.repositorios.Repositorio;
import java.util.List;

/**
 *
 * @author Amauri
 */
public abstract class DaoGenerico<T> implements Repositorio<T>{

    @Override
    public boolean salvar(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T abrir(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean apagar(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> buscar(T filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
