/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senzo.investments.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Data
@Entity
@Table(name = "investor_product")
@NamedQueries({
    @NamedQuery(name = "InvestorProduct.findAll", query = "SELECT i FROM InvestorProduct i")})
public class InvestorProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ivp_id")
    private Integer ivpId;
    @Basic(optional = false)
    @Column(name = "currentbalance")
    private BigDecimal currentbalance;
    @OneToMany(mappedBy = "investorProduct")
    private List<Withdrawal> withdrawalList;
    @JoinColumn(name = "investor_id", referencedColumnName = "investor_id")
    @ManyToOne(optional = false)
    private InvestorDetails investorDetails;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    private Product product;

}
