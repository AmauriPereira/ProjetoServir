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

    private final EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaServirPU");
    protected EntityManager manager;
    private final Class tipo;
    String where = "";
    String orderby = "";
    String jpql = "select c from ";
    Map<String, Object> parametros = new HashMap<>();

    public DaoGenerico(Class t) {
        this.manager = fabrica.createEntityManager();
        this.tipo = t;
    }

    @Override
    public boolean salvar(T obj) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(obj);
            transaction.commit();

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<T> buscar() {
        try {
            jpql += tipo.getSimpleName() + " c ";

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

            return consulta.getResultList();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

            where = "";
            jpql = "select c from ";
            orderby = "";
            parametros = new HashMap<>();

        }

    }

    /**
     *
     * @param campo
     * @param valor
     * @return
     */
    public DaoGenerico<T> IgualA(String campo, Object valor) {
        if (campo == null) {
            return this;
        }
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

        if (valor == null) {
            return this;
        }

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
        return (T) manager.find(tipo, id);
    }

    @Override
    public boolean apagar(T obj) {
        try {
            obj = (T) manager.merge(obj);
            manager.remove(obj);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public abstract List<T> buscar(T filtro);

}
