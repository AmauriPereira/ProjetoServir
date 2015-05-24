/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servirjanuaria.amauri.dataAccess;

import br.com.servirjanuaria.amauri.domainModel.repositorios.Repositorio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Amauri
 * @param <T>
 */
public abstract class DaoGenerico<T> implements Repositorio<T> {

    private EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaServirPU");
    protected EntityManager manager;
    private Class tipo;
    String where = "";
    String orderby = "";
    String jpql = "select c from ";
    Map<String, Object> parametros = new HashMap<>();

    public DaoGenerico(Class t) {
        this.manager = fabrica.createEntityManager();
        this.tipo = t;
        jpql += t.getSimpleName() + " c";
    }

    @Override
    public boolean salvar(T obj) {
        EntityTransaction t = manager.getTransaction();
        try {
            t.begin();
            manager.persist(obj);
            t.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            t.rollback();
            return false;
        }

    }

    public List<T> buscar() {
        if (where.length() > 0) {
            jpql = jpql + " where " + where;
        }

        if (orderby.length() > 0) {
            jpql = jpql + " order by " + orderby;
        }

        Query consulta = manager.createQuery(jpql);

        for (String parametro : parametros.keySet()) {
            consulta.setParameter(parametro, parametros.get(parametro));
        }

        where = "";

        return consulta.getResultList();
    }
    
    
    public List<T> buscarUmObjeto() {
        if (where.length() > 0) {
            jpql = jpql + " where " + where;
        }

        if (orderby.length() > 0) {
            jpql = jpql + " order by " + orderby;
        }

        Query consulta = manager.createQuery(jpql);

        for (String parametro : parametros.keySet()) {
            consulta.setParameter(parametro, parametros.get(parametro));
        }

        where = "";

        return consulta.getResultList();
    }
    /**
     *
     * @param campo
     * @param valor
     * @return
     */
    public DaoGenerico<T> IgualA(String campo, Object valor) {

        if (where.length() > 0) {
            where += " and ";
        }

        if (valor != null) {
            where = where + "c." + campo + " = :" + campo;
            parametros.put(campo, valor);
        }

        return this;
    }
    
    public DaoGenerico<T> Like(String campo, String valor) {

        if (where.length() > 0) {
            where += " and ";
        }

        if (valor != null) {
            where = where + "c." + campo + " like '%" + valor + "%'";
        }

        return this;
    }


    @Override
    public T abrir(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean apagar(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public abstract List<T> buscar(T filtro);

}
