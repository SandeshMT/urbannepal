/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author myhp
 */
@Entity
@Table(name = "subscribers", catalog = "urbannepal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subscribers.findAll", query = "SELECT s FROM Subscribers s"),
    @NamedQuery(name = "Subscribers.findBySubscribeId", query = "SELECT s FROM Subscribers s WHERE s.subscribeId = :subscribeId"),
    @NamedQuery(name = "Subscribers.findBySubscriberEmail", query = "SELECT s FROM Subscribers s WHERE s.subscriberEmail = :subscriberEmail"),
    @NamedQuery(name = "Subscribers.findByStatus", query = "SELECT s FROM Subscribers s WHERE s.status = :status")})
public class Subscribers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subscribeId")
    private Integer subscribeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "subscriberEmail")
    private String subscriberEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status")
    private String status;

    public Subscribers() {
    }

    public Subscribers(Integer subscribeId) {
        this.subscribeId = subscribeId;
    }

    public Subscribers(Integer subscribeId, String subscriberEmail, String status) {
        this.subscribeId = subscribeId;
        this.subscriberEmail = subscriberEmail;
        this.status = status;
    }

    public Integer getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(Integer subscribeId) {
        this.subscribeId = subscribeId;
    }

    public String getSubscriberEmail() {
        return subscriberEmail;
    }

    public void setSubscriberEmail(String subscriberEmail) {
        this.subscriberEmail = subscriberEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subscribeId != null ? subscribeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscribers)) {
            return false;
        }
        Subscribers other = (Subscribers) object;
        if ((this.subscribeId == null && other.subscribeId != null) || (this.subscribeId != null && !this.subscribeId.equals(other.subscribeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.urbannepal.entity.Subscribers[ subscribeId=" + subscribeId + " ]";
    }
    
}
