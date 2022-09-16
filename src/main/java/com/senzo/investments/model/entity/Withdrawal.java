/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senzo.investments.model.entity;

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
@Table(name = "withdrawal")
@NamedQueries({
    @NamedQuery(name = "Withdrawal.findAll", query = "SELECT w FROM Withdrawal w")})
public class Withdrawal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "withdrawal_id")
    private Integer withdrawalId;
    @Basic(optional = false)
    @Column(name = "withdrawal_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date withdrawalTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "withdrawal_amount")
    private BigDecimal withdrawalAmount;
    @Column(name = "opening_balance")
    private BigDecimal openingBalance;
    @Column(name = "closing_balance")
    private BigDecimal closingBalance;
    @OneToMany(mappedBy = "withdrawal")
    private List<StatusLog> statusLogList;
    @JoinColumn(name = "investor_product_id", referencedColumnName = "ivp_id")
    @ManyToOne
    private InvestorProduct investorProduct;

    public Withdrawal() {
    }

    public Withdrawal(Integer withdrawalId) {
        this.withdrawalId = withdrawalId;
    }

    public Withdrawal(Integer withdrawalId, Date withdrawalTime) {
        this.withdrawalId = withdrawalId;
        this.withdrawalTime = withdrawalTime;
    }

    public Integer getWithdrawalId() {
        return withdrawalId;
    }

    public void setWithdrawalId(Integer withdrawalId) {
        this.withdrawalId = withdrawalId;
    }

    public Date getWithdrawalTime() {
        return withdrawalTime;
    }

    public void setWithdrawalTime(Date withdrawalTime) {
        this.withdrawalTime = withdrawalTime;
    }

    public BigDecimal getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public BigDecimal getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(BigDecimal openingBefore) {
        this.openingBalance = openingBefore;
    }

    public BigDecimal getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(BigDecimal closingBalance) {
        this.closingBalance = closingBalance;
    }

    public List<StatusLog> getStatusLogList() {
        return statusLogList;
    }

    public void setStatusLogList(List<StatusLog> statusLogList) {
        this.statusLogList = statusLogList;
    }

    public InvestorProduct getInvestorProduct() {
        return investorProduct;
    }

    public void setInvestorProduct(InvestorProduct investorProduct) {
        this.investorProduct = investorProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (withdrawalId != null ? withdrawalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Withdrawal)) {
            return false;
        }
        Withdrawal other = (Withdrawal) object;
        if ((this.withdrawalId == null && other.withdrawalId != null) || (this.withdrawalId != null && !this.withdrawalId.equals(other.withdrawalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Withdrawal[ withdrawalId=" + withdrawalId + " ]";
    }
    
}
