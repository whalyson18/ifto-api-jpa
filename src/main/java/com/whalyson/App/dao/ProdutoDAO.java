/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whalyson.App.dao;

import com.whalyson.App.model.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author warius
 */
public class ProdutoDAO {
    @PersistenceContext
    private EntityManager em;
    
    public void save(Produto produto){
        em.persist(produto);
    }
    
    public Produto produto(int id){
        return em.find(Produto.class, id);
    }
    
    public List<Produto> produtos(){
        Query query = em.createQuery("from Produto");
        return query.getResultList();
    }
    
    public void remove(int id){
        Produto p = em.find(Produto.class, id);
        em.remove(p);
    }
    
    public void update(Produto produto){
        em.merge(produto);
    }
}
