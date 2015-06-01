/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.negocio;

import br.com.servirjanuaria.amauri.dataAccess.UsuarioDAO;
import br.com.servirjanuaria.amauri.domainModel.Usuario;
import br.com.servirjanuaria.amauri.excecao.UsuarioExistenteException;
import java.sql.SQLException;

/**
 *
 * @author Amauri
 */
public class UsuarioBO {

    public void cadastrarUsuario(Usuario usuario) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        boolean validaUsuario = usuarioExistente(usuario);

        if (validaUsuario) {
            usuarioDAO.cadastraUsuario(usuario);

        } else {
            throw new UsuarioExistenteException();

        }
    }

    private boolean usuarioExistente(Usuario usuario) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioExiste = usuarioDAO.SelecionaUsuario(usuario);

        if (usuarioExiste == null) {
            return true;

        } else {
            return false;
        }
    }

}
