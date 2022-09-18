/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senzo.investments.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author user
 */
@Data
@Entity
@Table(name = "status_log")
@NamedQueries({
    @NamedQuery(name = "StatusLog.findAll", query = "SELECT s FROM StatusLog s")})
public class StatusLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "log_id")
    private Integer logId;
    @Basic(optional = false)
    @Column(name = "current_status")
    private String currentStatus;
    @Basic(optional = false)
    @Column(name = "status_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusTime;
    @JoinColumn(name = "withdrawal_id", referencedColumnName = "withdrawal_id")
    @ManyToOne
    private Withdrawal withdrawal;

}
