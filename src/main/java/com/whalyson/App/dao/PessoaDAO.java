/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whalyson.App.dao;

import com.whalyson.App.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.whalyson.App.model.Pessoa;
import java.sql.Connection;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author whalyson
 */

@Repository
public class PessoaDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public void save(Pessoa pessoa){
        em.persist(pessoa);
    }
    
    public Pessoa pessoa(int id){
        return em.find(Pessoa.class, id);
    }
    
    public List<Pessoa> pessoas(){
        Query query = em.createQuery("from Pessoa");
        return query.getResultList();
    }
    
    public void remove(int id){
        Pessoa p = em.find(Pessoa.class, id);
        em.remove(p);
    }
    
    public void update(Pessoa pessoa){
        em.merge(pessoa);
    }
}
