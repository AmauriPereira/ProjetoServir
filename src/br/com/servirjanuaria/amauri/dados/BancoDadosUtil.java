/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dados;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Amauri
 */
public class BancoDadosUtil {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/servir";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static Connection getConnection() {

        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        return connection;
    }

}
