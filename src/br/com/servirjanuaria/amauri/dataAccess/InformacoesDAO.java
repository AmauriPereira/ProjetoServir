/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dataAccess;

import br.com.servirjanuaria.amauri.domainModel.Informacoes;
import br.com.servirjanuaria.amauri.domainModel.repositorios.InformacoesRepositorio;
import java.util.List;

/**
 *
 * @author amauri_pereira
 */
public class InformacoesDAO  extends DaoGenerico<Informacoes> implements InformacoesRepositorio {

    public InformacoesDAO() {
        super(Informacoes.class);
    }

    @Override
    public List<Informacoes> buscar(Informacoes filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
