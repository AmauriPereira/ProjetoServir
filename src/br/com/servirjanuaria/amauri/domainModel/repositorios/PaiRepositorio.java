/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.domainModel.repositorios;

import br.com.servirjanuaria.amauri.domainModel.Pai;
import java.util.List;

/**
 *
 * @author Amauri
 */
public interface PaiRepositorio extends Repositorio<Pai>{

    public List<Pai> buscarPorCodigo(Long id);
    
}
