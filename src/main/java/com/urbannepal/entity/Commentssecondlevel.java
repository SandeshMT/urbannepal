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
@Table(name = "commentssecondlevel", catalog = "urbannepal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commentssecondlevel.findAll", query = "SELECT c FROM Commentssecondlevel c"),
    @NamedQuery(name = "Commentssecondlevel.findByCslIc", query = "SELECT c FROM Commentssecondlevel c WHERE c.cslIc = :cslIc"),
    @NamedQuery(name = "Commentssecondlevel.findByCommentBy", query = "SELECT c FROM Commentssecondlevel c WHERE c.commentBy = :commentBy"),
    @NamedQuery(name = "Commentssecondlevel.findByComment", query = "SELECT c FROM Commentssecondlevel c WHERE c.comment = :comment"),
    @NamedQuery(name = "Commentssecondlevel.findByCommentId", query = "SELECT c FROM Commentssecondlevel c WHERE c.commentId = :commentId"),
    @NamedQuery(name = "Commentssecondlevel.findByPostId", query = "SELECT c FROM Commentssecondlevel c WHERE c.postId = :postId"),
    @NamedQuery(name = "Commentssecondlevel.findByReplyForFirstCommentId", query = "SELECT c FROM Commentssecondlevel c WHERE c.replyForFirstCommentId = :replyForFirstCommentId")})
public class Commentssecondlevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cslIc")
    private Integer cslIc;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "replyForFirstCommentId")
    private int replyForFirstCommentId;

    public Commentssecondlevel() {
    }

    public Commentssecondlevel(Integer cslIc) {
        this.cslIc = cslIc;
    }

    public Commentssecondlevel(Integer cslIc, String commentBy, String comment, int commentId, int postId, int replyForFirstCommentId) {
        this.cslIc = cslIc;
        this.commentBy = commentBy;
        this.comment = comment;
        this.commentId = commentId;
        this.postId = postId;
        this.replyForFirstCommentId = replyForFirstCommentId;
    }

    public Integer getCslIc() {
        return cslIc;
    }

    public void setCslIc(Integer cslIc) {
        this.cslIc = cslIc;
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

    public int getReplyForFirstCommentId() {
        return replyForFirstCommentId;
    }

    public void setReplyForFirstCommentId(int replyForFirstCommentId) {
        this.replyForFirstCommentId = replyForFirstCommentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cslIc != null ? cslIc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commentssecondlevel)) {
            return false;
        }
        Commentssecondlevel other = (Commentssecondlevel) object;
        if ((this.cslIc == null && other.cslIc != null) || (this.cslIc != null && !this.cslIc.equals(other.cslIc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.urbannepal.entity.Commentssecondlevel[ cslIc=" + cslIc + " ]";
    }
    
}
