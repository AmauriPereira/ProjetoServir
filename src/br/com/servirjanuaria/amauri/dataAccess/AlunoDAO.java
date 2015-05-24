/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dataAccess;

import br.com.servirjanuaria.amauri.domainModel.Aluno;
import br.com.servirjanuaria.amauri.domainModel.repositorios.AlunoRepositorio;
import java.util.List;

/**
 *
 * @author Amauri
 */
public class AlunoDAO extends DaoGenerico<Aluno> implements AlunoRepositorio {

    public AlunoDAO() {
        super(Aluno.class);
    }

    @Override
    public List<Aluno> buscar(Aluno filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
