/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whalyson.App.controller;

import com.whalyson.App.dao.PessoaDAO;
import com.whalyson.App.dao.ProdutoDAO;
import com.whalyson.App.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author warius
 */
@Transactional
@Controller
@RequestMapping("produtos")
public class ProdutoController {
    @Autowired
    ProdutoDAO dao;
    
    @GetMapping("/form")
    public String form(Produto produto){
        return "/produtos/form";
    }
    
    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("produtos", dao.produtos());
        return new ModelAndView("/produtos/list", model);
    }
    
    @PostMapping("/save")
    public ModelAndView save(Produto produto){
        dao.save(produto);
        return new ModelAndView("redirect:/produtos/list");
    }
    
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") int id){
        dao.remove(id);
        return new ModelAndView("redirect:/produtos/list");
    }
    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("produto", dao.produto(id));
        return new ModelAndView("/produtos/form", model);
    }
    
    @PostMapping("/update")
    public ModelAndView update(Produto produto) {
        dao.update(produto);
        return new ModelAndView("redirect:/pessoas/list");
    }
}
