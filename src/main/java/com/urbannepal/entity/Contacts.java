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
@Table(name = "contacts", catalog = "urbannepal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacts.findAll", query = "SELECT c FROM Contacts c"),
    @NamedQuery(name = "Contacts.findByContactId", query = "SELECT c FROM Contacts c WHERE c.contactId = :contactId"),
    @NamedQuery(name = "Contacts.findByProfilepicture", query = "SELECT c FROM Contacts c WHERE c.profilepicture = :profilepicture"),
    @NamedQuery(name = "Contacts.findByFirstname", query = "SELECT c FROM Contacts c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Contacts.findByLastnanme", query = "SELECT c FROM Contacts c WHERE c.lastnanme = :lastnanme"),
    @NamedQuery(name = "Contacts.findByPrimaryno", query = "SELECT c FROM Contacts c WHERE c.primaryno = :primaryno"),
    @NamedQuery(name = "Contacts.findBySecondaryno", query = "SELECT c FROM Contacts c WHERE c.secondaryno = :secondaryno"),
    @NamedQuery(name = "Contacts.findByPrimaryaddress", query = "SELECT c FROM Contacts c WHERE c.primaryaddress = :primaryaddress"),
    @NamedQuery(name = "Contacts.findBySecondaryaddress", query = "SELECT c FROM Contacts c WHERE c.secondaryaddress = :secondaryaddress"),
    @NamedQuery(name = "Contacts.findByGender", query = "SELECT c FROM Contacts c WHERE c.gender = :gender"),
    @NamedQuery(name = "Contacts.findByEmail", query = "SELECT c FROM Contacts c WHERE c.email = :email"),
    @NamedQuery(name = "Contacts.findByProfession", query = "SELECT c FROM Contacts c WHERE c.profession = :profession")})
public class Contacts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contact_id")
    private Integer contactId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "profilepicture")
    private String profilepicture;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 56)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 56)
    @Column(name = "lastnanme")
    private String lastnanme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "primaryno")
    private String primaryno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "secondaryno")
    private String secondaryno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "primaryaddress")
    private String primaryaddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "secondaryaddress")
    private String secondaryaddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "gender")
    private String gender;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "profession")
    private String profession;

    public Contacts() {
    }

    public Contacts(Integer contactId) {
        this.contactId = contactId;
    }

    public Contacts(Integer contactId, String profilepicture, String firstname, String lastnanme, String primaryno, String secondaryno, String primaryaddress, String secondaryaddress, String gender, String email, String profession) {
        this.contactId = contactId;
        this.profilepicture = profilepicture;
        this.firstname = firstname;
        this.lastnanme = lastnanme;
        this.primaryno = primaryno;
        this.secondaryno = secondaryno;
        this.primaryaddress = primaryaddress;
        this.secondaryaddress = secondaryaddress;
        this.gender = gender;
        this.email = email;
        this.profession = profession;
    }

    public Contacts(Integer contactId, String firstname, String lastnanme, String primaryno, String secondaryno, String primaryaddress, String secondaryaddress, String gender, String email, String profession) {
        this.contactId = contactId;
        this.firstname = firstname;
        this.lastnanme = lastnanme;
        this.primaryno = primaryno;
        this.secondaryno = secondaryno;
        this.primaryaddress = primaryaddress;
        this.secondaryaddress = secondaryaddress;
        this.gender = gender;
        this.email = email;
        this.profession = profession;
    }
    
    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastnanme() {
        return lastnanme;
    }

    public void setLastnanme(String lastnanme) {
        this.lastnanme = lastnanme;
    }

    public String getPrimaryno() {
        return primaryno;
    }

    public void setPrimaryno(String primaryno) {
        this.primaryno = primaryno;
    }

    public String getSecondaryno() {
        return secondaryno;
    }

    public void setSecondaryno(String secondaryno) {
        this.secondaryno = secondaryno;
    }

    public String getPrimaryaddress() {
        return primaryaddress;
    }

    public void setPrimaryaddress(String primaryaddress) {
        this.primaryaddress = primaryaddress;
    }

    public String getSecondaryaddress() {
        return secondaryaddress;
    }

    public void setSecondaryaddress(String secondaryaddress) {
        this.secondaryaddress = secondaryaddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacts)) {
            return false;
        }
        Contacts other = (Contacts) object;
        if ((this.contactId == null && other.contactId != null) || (this.contactId != null && !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.urbannepal.entity.Contacts[ contactId=" + contactId + " ]";
    }
    
}
