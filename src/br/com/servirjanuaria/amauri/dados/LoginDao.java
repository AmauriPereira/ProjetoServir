/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dados;

import br.com.servirjanuaria.amauri.entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amauri
 */
public class LoginDao {

    //sql: busca usuario de acordo com o usuario e senha passado por paramentro
    private static final String SQL_SELECT_LOGIN_USUARIO = "SELECT * FROM LOGIN WHERE USUARIO = ?  AND SENHA = ?";

    //SELECIONA O USUARIO QUE POSSUI LOGIN IGUAL AOS PARAMETROS(LOGIN E SENHA)
    public Usuario selectLogin(String Usuario, String Senha) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario usuarioSelecionado = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_LOGIN_USUARIO);
            comando.setString(1, Usuario);
            comando.setString(2, Senha);
            resultado = comando.executeQuery();

            if (resultado.next()) {
                usuarioSelecionado = new Usuario();
                //usuarioSelecionado.setId(resultado.getString("IDLogin"));
                usuarioSelecionado.setNome(resultado.getString("Nome"));
                usuarioSelecionado.setUsuario(resultado.getString("Usuario"));
                usuarioSelecionado.setNivelUsuario(resultado.getInt("Nivel"));
                usuarioSelecionado.setDataCadastro(resultado.getDate("DataCadastro"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);

        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return usuarioSelecionado;
    }

}
