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
public class UsuarioDAO {
//sql: busca usuario de acordo com o usuario e senha passado por paramentro

    private static final String SQL_SELECT_USUARIO = "SELECT * FROM LOGIN WHERE USUARIO = ?";
    private static final String SQL_INSERT_USUARIO = "INSERT INTO LOGIN (Nome, Usuario, Senha, Nivel, DataCadastro)"
            + "values(?,?,?,?,?)";

    //Verifica se o usuario passado por parâmetro está cadastrado no banco.
    public Usuario SelecionaUsuario(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario usuarioSelecionado = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_USUARIO);
            comando.setString(1, usuario.getUsuario());
            resultado = comando.executeQuery();

            if (resultado.next()) {
                usuarioSelecionado = new Usuario();
                //usuarioSelecionado.setIdlogin(resultado.getInt("IDLogin"));
                usuarioSelecionado.setNome(resultado.getString("Nome"));
                usuarioSelecionado.setUsuario(resultado.getString("Usuario"));
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

    //Cadastra um novo usuario no banco de dados.
    public void cadastraUsuario(Usuario usuario) throws SQLException {

        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT_USUARIO);

            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getUsuario());
            comando.setString(3, usuario.getSenha());
            comando.setInt(4, usuario.getNivelUsuario());

            java.util.Date dataUtil = new java.util.Date();
            dataUtil = usuario.getDataCadastro();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

            comando.setDate(5, dataSql);

            /*comando.setString(1, "Administrador");
             comando.setString(2, "admin");
             String Senha = "admin";
             comando.setString(3, Senha);
             comando.setInt(4, 1);
             System.out.println("Aki now");*/
            comando.execute();

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
    }

}
