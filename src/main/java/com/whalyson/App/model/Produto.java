/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whalyson.App.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author whalyson
 */
@Entity
@Table(name = "tb_produto")
@ToString
public class Produto implements Serializable {
    @Id
    @GeneratedValue
    @Setter @Getter private int id;
    @Setter @Getter private String descricao;
    @Setter @Getter private double valor;
}
