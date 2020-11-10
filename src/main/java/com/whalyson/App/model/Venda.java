/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whalyson.App.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import com.whalyson.App.model.Produto;

/**
 *
 * @author warius
 */
public class Venda {
    @Id
    @GeneratedValue
    @Setter @Getter private int id;
    @Setter @Getter private Date data;
    
    @ManyToMany(mappedBy = "produtos")
    private List<Produto> produto=new ArrayList();
    
    public double total(){
        return 1.5;
    }
}
