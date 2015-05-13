/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.domainModel.repositorios;

import java.util.List;

/**
 *
 * @author Amauri
 */
public interface Repositorio<T> {
    public boolean salvar(T obj);
    public T abrir(Long id);
    public boolean apagar(T obj);
    public List<T> buscar(T filtro);
    
}
