/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whalyson.App.controller;

import com.whalyson.App.dao.PessoaDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.whalyson.App.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author whalyson
 */
@Transactional
@Controller
@RequestMapping("pessoas")
public class PessoaController {
    
    @Autowired
    PessoaDAO dao;
    
    @GetMapping("/form")
    public String form(Pessoa pessoa){
        return "/pessoas/form";
    }
    
    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("pessoas", dao.pessoas());
        return new ModelAndView("/pessoas/list", model);
    }
    
    @PostMapping("/save")
    public ModelAndView save(Pessoa pessoa){
        dao.save(pessoa);
        return new ModelAndView("redirect:/pessoas/list");
    }
    
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") int id){
        dao.remove(id);
        return new ModelAndView("redirect:/pessoas/list");
    }
    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("pessoa", dao.pessoa(id));
        return new ModelAndView("/pessoas/form", model);
    }
    
    @PostMapping("/update")
    public ModelAndView update(Pessoa pessoa) {
        dao.update(pessoa);
        return new ModelAndView("redirect:/pessoas/list");
    }
}
