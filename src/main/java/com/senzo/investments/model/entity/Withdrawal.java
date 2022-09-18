/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senzo.investments.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author user
 */
@Entity
@Data
public class Withdrawal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "withdrawal_id")
    @JsonIgnore
    private Integer withdrawalId;
    @Basic(optional = false)
    @Column(name = "withdrawal_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date withdrawalTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "withdrawal_amount")
    @ApiModelProperty(name = "withdrawnAmount", notes = "amount withdrawn", example = "200.55")
    private BigDecimal withdrawalAmount;
    @Column(name = "opening_balance")
    @ApiModelProperty(name = "openingBalance", notes = "amount investor had before withdrawal", example = "500.55")
    private BigDecimal openingBalance;
    @Column(name = "closing_balance")
    @ApiModelProperty(name = "closingBalance", notes = "amount investor has after withdrawal", example = "300.00")
    private BigDecimal closingBalance;
    @JoinColumn(name = "investor_product_id", referencedColumnName = "ivp_id")
    @ManyToOne
    private InvestorProduct investorProduct;

}
