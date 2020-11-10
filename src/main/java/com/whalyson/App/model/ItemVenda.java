/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whalyson.App.model;

import java.util.List;
import javax.persistence.OneToMany;
import com.whalyson.App.model.Produto;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author warius
 */
@Entity
@Table(name = "tb_item_venda")
public class ItemVenda implements Serializable{
    
    @Id
    @GeneratedValue
    @Setter @Getter private int id;
    @Setter @Getter private double valor;
    
    @OneToMany(mappedBy = "produto")
    private List<Produto> produto;
    
    
    public double total(){
        return 1.4;
    }
}
