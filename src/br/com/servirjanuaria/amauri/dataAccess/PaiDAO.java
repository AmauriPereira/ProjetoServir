/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dataAccess;

import br.com.servirjanuaria.amauri.domainModel.Pai;
import br.com.servirjanuaria.amauri.domainModel.repositorios.PaiRepositorio;
import java.util.List;

/**
 *
 * @author Amauri
 */
public class PaiDAO extends DaoGenerico<Pai> implements PaiRepositorio {

    public PaiDAO() {
        super(Pai.class);
    }

    @Override
    public List<Pai> buscar(Pai filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pai> buscarPorCodigo(Long pai_id) {
        return IgualA("id", pai_id)
                .buscar();

    }

}
