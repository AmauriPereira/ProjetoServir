/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dataAccess;

import br.com.servirjanuaria.amauri.domainModel.Pessoa;
import br.com.servirjanuaria.amauri.domainModel.repositorios.PessoaRepositorio;
import java.util.List;

/**
 *
 * @author Amauri
 */
public class PessoaDAO extends DaoGenerico<Pessoa> implements PessoaRepositorio {

    public PessoaDAO() {
        super(Pessoa.class);
    }

    @Override
    public List<Pessoa> buscar(Pessoa filtro) {
        try {
            return Like("nome", filtro.getNome())
                    .buscar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
