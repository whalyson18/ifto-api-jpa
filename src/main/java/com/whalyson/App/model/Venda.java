/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whalyson.App.model;

import java.util.Date;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.OneToMany;

/**
 *
 * @author warius
 */
public class Venda {
    @Id
    @GeneratedValue
    @Setter @Getter private int id;
    @Setter @Getter private Date data;
    
    @OneToMany(mappedBy = "itemvenda")
    private List<ItemVenda> itensVenda;
    
    public void total(){
    }
}
