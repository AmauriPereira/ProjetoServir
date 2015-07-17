/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.domainModel.repositorios;

import br.com.servirjanuaria.amauri.domainModel.Pessoa;
import java.util.List;

/**
 *
 * @author Amauri
 */
public interface PessoaRepositorio extends Repositorio<Pessoa>{

    public List<Pessoa> buscarWhereDtype(String nome, String dtype);
    
}
