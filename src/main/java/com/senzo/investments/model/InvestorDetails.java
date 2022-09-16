package com.senzo.investments.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "investor_details", schema = "public", catalog = "investmentdb")
public class InvestorDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "investor_id")
    private int investorId;
    @Basic
    @Column(name = "investor_name")
    private String investorName;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "dob")
    private Date dob;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "contact_number")
    private String contactNumber;

    public int getInvestorId() {
        return investorId;
    }

    public void setInvestorId(int investorId) {
        this.investorId = investorId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvestorDetails that = (InvestorDetails) o;
        return investorId == that.investorId && Objects.equals(investorName, that.investorName) && Objects.equals(surname, that.surname) && Objects.equals(dob, that.dob) && Objects.equals(address, that.address) && Objects.equals(email, that.email) && Objects.equals(contactNumber, that.contactNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(investorId, investorName, surname, dob, address, email, contactNumber);
    }
}
