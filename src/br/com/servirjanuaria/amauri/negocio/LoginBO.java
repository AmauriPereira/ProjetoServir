/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.negocio;

import br.com.servirjanuaria.amauri.dataAccess.LoginDao;
import br.com.servirjanuaria.amauri.domainModel.Usuario;
import br.com.servirjanuaria.amauri.excecao.ErroLoginException;
import java.sql.SQLException;

/**
 *
 * @author Amauri
 */
public class LoginBO {

    public Usuario VerificaLogin(String Usuario,String Senha) throws SQLException{

        Usuario usuarioLogado = new Usuario();
        LoginDao loginDao = new LoginDao();
        usuarioLogado = loginDao.selectLogin(Usuario,Senha);

        if (usuarioLogado == null) {
            throw new ErroLoginException();
        } else {
            return usuarioLogado;
        }

    }

}
