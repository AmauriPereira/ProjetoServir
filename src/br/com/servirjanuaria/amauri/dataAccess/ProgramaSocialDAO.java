/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dataAccess;

import br.com.servirjanuaria.amauri.domainModel.ProgramaSocial;
import br.com.servirjanuaria.amauri.domainModel.repositorios.ProgramaSocialRepositorio;
import java.util.List;

/**
 *
 * @author Amauri
 */
public class ProgramaSocialDAO extends DaoGenerico<ProgramaSocial> implements ProgramaSocialRepositorio {

    public ProgramaSocialDAO() {
        super(ProgramaSocial.class);
    }

    @Override
    public List<ProgramaSocial> buscar(ProgramaSocial filtro) {

        try {
            return Like("nome", filtro.getNome())
                    .buscar();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
