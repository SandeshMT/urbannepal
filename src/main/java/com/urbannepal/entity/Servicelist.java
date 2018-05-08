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
@Table(name = "servicelist", catalog = "urbannepal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicelist.findAll", query = "SELECT s FROM Servicelist s"),
    @NamedQuery(name = "Servicelist.findBySlId", query = "SELECT s FROM Servicelist s WHERE s.slId = :slId"),
    @NamedQuery(name = "Servicelist.findByServiceName", query = "SELECT s FROM Servicelist s WHERE s.serviceName = :serviceName"),
    @NamedQuery(name = "Servicelist.findByPrice", query = "SELECT s FROM Servicelist s WHERE s.price = :price"),
    @NamedQuery(name = "Servicelist.findByServiceProvider", query = "SELECT s FROM Servicelist s WHERE s.serviceProvider = :serviceProvider"),
    @NamedQuery(name = "Servicelist.findByContactId", query = "SELECT s FROM Servicelist s WHERE s.contactId = :contactId")})
public class Servicelist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "slId")
    private Integer slId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "serviceName")
    private String serviceName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ServiceProvider")
    private int serviceProvider;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ContactId")
    private int contactId;

    public Servicelist() {
    }

    public Servicelist(Integer slId) {
        this.slId = slId;
    }

    public Servicelist(Integer slId, String serviceName, int price, int serviceProvider, int contactId) {
        this.slId = slId;
        this.serviceName = serviceName;
        this.price = price;
        this.serviceProvider = serviceProvider;
        this.contactId = contactId;
    }

    public Integer getSlId() {
        return slId;
    }

    public void setSlId(Integer slId) {
        this.slId = slId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(int serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (slId != null ? slId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicelist)) {
            return false;
        }
        Servicelist other = (Servicelist) object;
        if ((this.slId == null && other.slId != null) || (this.slId != null && !this.slId.equals(other.slId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.urbannepal.entity.Servicelist[ slId=" + slId + " ]";
    }
    
}
