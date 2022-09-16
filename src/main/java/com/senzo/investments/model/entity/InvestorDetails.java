/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senzo.investments.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "investor_details")
@NamedQueries({
    @NamedQuery(name = "InvestorDetails.findAll", query = "SELECT i FROM InvestorDetails i")})
public class InvestorDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "investor_id")
    private Integer investorId;
    @Basic(optional = false)
    @Column(name = "idnumber")
    private String idnumber;
    @Basic(optional = false)
    @Column(name = "investor_name")
    private String investorName;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "contact_number")
    private String contactNumber;
    @OneToMany(mappedBy = "investorDetails")
    private List<BankDetails> bankDetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "investorDetails")
    private List<InvestorProduct> investorProductList;

    public InvestorDetails() {
    }

    public InvestorDetails(Integer investorId) {
        this.investorId = investorId;
    }

    public InvestorDetails(Integer investorId, String idnumber, String investorName, String surname, Date dob) {
        this.investorId = investorId;
        this.idnumber = idnumber;
        this.investorName = investorName;
        this.surname = surname;
        this.dob = dob;
    }

    public Integer getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Integer investorId) {
        this.investorId = investorId;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<BankDetails> getBankDetailsList() {
        return bankDetailsList;
    }

    public void setBankDetailsList(List<BankDetails> bankDetailsList) {
        this.bankDetailsList = bankDetailsList;
    }

    public List<InvestorProduct> getInvestorProductList() {
        return investorProductList;
    }

    public void setInvestorProductList(List<InvestorProduct> investorProductList) {
        this.investorProductList = investorProductList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (investorId != null ? investorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvestorDetails)) {
            return false;
        }
        InvestorDetails other = (InvestorDetails) object;
        if ((this.investorId == null && other.investorId != null) || (this.investorId != null && !this.investorId.equals(other.investorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.InvestorDetails[ investorId=" + investorId + " ]";
    }
    
}
