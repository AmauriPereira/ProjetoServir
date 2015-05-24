/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dataAccess;

import br.com.servirjanuaria.amauri.domainModel.Endereco;
import br.com.servirjanuaria.amauri.domainModel.repositorios.EnderecoRepositorio;
import java.util.List;

/**
 *
 * @author Amauri
 */
public class EnderecoDAO extends DaoGenerico<Endereco> implements EnderecoRepositorio{

    public EnderecoDAO() {
        super(Endereco.class);
    }

    @Override
    public List<Endereco> buscar(Endereco filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
