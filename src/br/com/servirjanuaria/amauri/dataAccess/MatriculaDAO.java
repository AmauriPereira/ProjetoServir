/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dataAccess;

import br.com.servirjanuaria.amauri.domainModel.Matricula;
import br.com.servirjanuaria.amauri.domainModel.repositorios.MatriculaRepositorio;
import java.util.List;

/**
 *
 * @author Amauri
 */
public class MatriculaDAO extends DaoGenerico<Matricula> implements MatriculaRepositorio {

    public MatriculaDAO() {
        super(Matricula.class);
    }

    @Override
    public List<Matricula> buscar(Matricula filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id_Aluno
     * @return
     */
    @Override
    public List<Matricula> buscarPorAluno(Long id_Aluno) {
        return IgualA("aluno_id", id_Aluno)
                .buscar();
    }

}
