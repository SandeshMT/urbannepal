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
@Table(name = "commentsfirstlevel", catalog = "urbannepal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commentsfirstlevel.findAll", query = "SELECT c FROM Commentsfirstlevel c"),
    @NamedQuery(name = "Commentsfirstlevel.findByCflId", query = "SELECT c FROM Commentsfirstlevel c WHERE c.cflId = :cflId"),
    @NamedQuery(name = "Commentsfirstlevel.findByCommentBy", query = "SELECT c FROM Commentsfirstlevel c WHERE c.commentBy = :commentBy"),
    @NamedQuery(name = "Commentsfirstlevel.findByComment", query = "SELECT c FROM Commentsfirstlevel c WHERE c.comment = :comment"),
    @NamedQuery(name = "Commentsfirstlevel.findByCommentId", query = "SELECT c FROM Commentsfirstlevel c WHERE c.commentId = :commentId"),
    @NamedQuery(name = "Commentsfirstlevel.findByPostId", query = "SELECT c FROM Commentsfirstlevel c WHERE c.postId = :postId")})
public class Commentsfirstlevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cflId")
    private Integer cflId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "commentBy")
    private String commentBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "commentId")
    private int commentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "postId")
    private int postId;

    public Commentsfirstlevel() {
    }

    public Commentsfirstlevel(Integer cflId) {
        this.cflId = cflId;
    }

    public Commentsfirstlevel(Integer cflId, String commentBy, String comment, int commentId, int postId) {
        this.cflId = cflId;
        this.commentBy = commentBy;
        this.comment = comment;
        this.commentId = commentId;
        this.postId = postId;
    }

    public Integer getCflId() {
        return cflId;
    }

    public void setCflId(Integer cflId) {
        this.cflId = cflId;
    }

    public String getCommentBy() {
        return commentBy;
    }

    public void setCommentBy(String commentBy) {
        this.commentBy = commentBy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cflId != null ? cflId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commentsfirstlevel)) {
            return false;
        }
        Commentsfirstlevel other = (Commentsfirstlevel) object;
        if ((this.cflId == null && other.cflId != null) || (this.cflId != null && !this.cflId.equals(other.cflId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.urbannepal.entity.Commentsfirstlevel[ cflId=" + cflId + " ]";
    }
    
}
