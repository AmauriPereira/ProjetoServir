/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.domainModel.repositorios;

import br.com.servirjanuaria.amauri.domainModel.Usuario;

/**
 *
 * @author Amauri
 */
public interface UsuarioRepositorio extends Repositorio<Usuario> {

    public Usuario AbrirPorNomeDeUsuario(String nome);

}
