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
    
//    public List<Pessoa> buscarPessoas() {
//        try {
//            //criar um objeto Connection para receber a conexão
//            Connection con = Conexao.criarConexao();
//            //comando sql
//            String sql = "select * from tb_pessoas";
//            PreparedStatement ps = con.prepareStatement(sql);
//            //ResultSet, representa o resultado do comando SQL
//            ResultSet rs = ps.executeQuery();
//            //cria uma lista de pessoas para retornar
//            List<Pessoa> pessoas = new ArrayList();
//            //laço para buscar todas as pessoas do banco
//            while (rs.next()) {
//                Pessoa p = new Pessoa();
//                p.setId(rs.getInt("id"));
//                p.setNome(rs.getString("nome"));
//                //add pessoa na lista
//                pessoas.add(p);
//            }
//            //retorna a lista de pessoas
//            con.close();
//            return pessoas;
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return null;
//    }
//    
//    public boolean remove(int id) {
//        try {
//            //criar um objeto Connection para receber a conexão
//            Connection con = Conexao.criarConexao();
//            //comando sql
//            String sql = "delete from tb_pessoas where id = ?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            //referênciar o parâmetro do método para a ?
//            ps.setLong(1, id);
//            if(ps.executeUpdate()==1){
//                con.close();
//                return true;
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return false;
//    }
//    
//    public boolean save(Pessoa pessoa) {
//        try {
//            //criar um objeto Connection para receber a conexão
//            Connection con = Conexao.criarConexao();
//            //comando sql
//            String sql = "insert into tb_pessoas (nome) values (?)";
//            PreparedStatement ps = con.prepareStatement(sql);
//            //referênciar o parâmetro do método para a ?
//            ps.setString(1, pessoa.getNome());
//
//            if(ps.executeUpdate()==1){
//                con.close();
//                return true;
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return false;
//    }
//    
//    public boolean update(Pessoa pessoa) {
//        try {
//            //criar um objeto Connection para receber a conexão
//            Connection con = Conexao.criarConexao();
//            //comando sql
//            String sql = "update tb_pessoas set nome=? where id=?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            //referênciar o parâmetro do método para a ?
//            ps.setString(1, pessoa.getNome());
//            ps.setLong(2, pessoa.getId());
//
//            if (ps.executeUpdate()==1){
//                con.close();
//                return true;
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return false;
//    }
//    
//    public Pessoa buscarPessoa(int id) {
//        try {
//            //criar um objeto Connection para receber a conexão
//            Connection con = Conexao.criarConexao();
//            //comando sql
//            String sql = "select * from tb_pessoas where id = ?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            //referênciar o parâmetro do método para a ?
//            ps.setInt(1, id);
//            //ResultSet, representa o resultado do comando SQL
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                Pessoa p = new Pessoa();
//                p.setId(rs.getInt("id"));
//                p.setNome(rs.getString("nome"));
//                
//                con.close();
//                return p;
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return null;
//    }
}
