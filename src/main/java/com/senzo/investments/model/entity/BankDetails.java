/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senzo.investments.model.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "bank_details")
@NamedQueries({
    @NamedQuery(name = "BankDetails.findAll", query = "SELECT b FROM BankDetails b")})
public class BankDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bank_details_id")
    private Integer bankDetailsId;
    @Basic(optional = false)
    @Column(name = "bank_name")
    private String bankName;
    @Basic(optional = false)
    @Column(name = "account_number")
    private BigInteger accountNumber;
    @Column(name = "account_type")
    private String accountType;
    @JoinColumn(name = "investor_id", referencedColumnName = "investor_id")
    @ManyToOne
    private InvestorDetails investorDetails;

    public BankDetails() {
    }

    public BankDetails(Integer bankDetailsId) {
        this.bankDetailsId = bankDetailsId;
    }

    public BankDetails(Integer bankDetailsId, String bankName, BigInteger accountNumber) {
        this.bankDetailsId = bankDetailsId;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    public Integer getBankDetailsId() {
        return bankDetailsId;
    }

    public void setBankDetailsId(Integer bankDetailsId) {
        this.bankDetailsId = bankDetailsId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BigInteger getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(BigInteger accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public InvestorDetails getInvestorDetails() {
        return investorDetails;
    }

    public void setInvestorDetails(InvestorDetails investorDetails) {
        this.investorDetails = investorDetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankDetailsId != null ? bankDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BankDetails)) {
            return false;
        }
        BankDetails other = (BankDetails) object;
        if ((this.bankDetailsId == null && other.bankDetailsId != null) || (this.bankDetailsId != null && !this.bankDetailsId.equals(other.bankDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.BankDetails[ bankDetailsId=" + bankDetailsId + " ]";
    }
    
}
