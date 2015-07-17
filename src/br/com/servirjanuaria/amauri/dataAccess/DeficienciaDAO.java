/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dataAccess;

import br.com.servirjanuaria.amauri.domainModel.Deficiencia;
import br.com.servirjanuaria.amauri.domainModel.repositorios.DeficienciaRepositorio;
import java.util.List;

/**
 *
 * @author Amauri
 */
public class DeficienciaDAO extends DaoGenerico<Deficiencia> implements DeficienciaRepositorio {

    public DeficienciaDAO() {
        super(Deficiencia.class);
    }

    @Override
    public List<Deficiencia> buscar(Deficiencia filtro) {
        return Like("nome", filtro.getNome())
                .buscar();
    }

}
