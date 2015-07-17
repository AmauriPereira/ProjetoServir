/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dataAccess;

import br.com.servirjanuaria.amauri.domainModel.Usuario;
import br.com.servirjanuaria.amauri.domainModel.repositorios.UsuarioRepositorio;
import java.util.List;

/**
 *
 * @author Amauri
 */
public class UsuarioDAO extends DaoGenerico<Usuario> implements UsuarioRepositorio {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    @Override
    public Usuario AbrirPorNomeDeUsuario(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> buscar(Usuario filtro) {

        return Like("usuario", filtro.getUsuario())
                .Like("senha", filtro.getSenha())
                .buscar();

    }

}
