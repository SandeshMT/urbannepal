/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author myhp
 */
@Entity
@Table(name = "post", catalog = "urbannepal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p"),
    @NamedQuery(name = "Post.findByPostId", query = "SELECT p FROM Post p WHERE p.postId = :postId"),
    @NamedQuery(name = "Post.findByPostTitle", query = "SELECT p FROM Post p WHERE p.postTitle = :postTitle"),
    @NamedQuery(name = "Post.findByTags", query = "SELECT p FROM Post p WHERE p.tags = :tags"),
    @NamedQuery(name = "Post.findByCategories", query = "SELECT p FROM Post p WHERE p.categories = :categories"),
    @NamedQuery(name = "Post.findByFeaturedimage", query = "SELECT p FROM Post p WHERE p.featuredimage = :featuredimage"),
    @NamedQuery(name = "Post.findByOwner", query = "SELECT p FROM Post p WHERE p.owner = :owner"),
    @NamedQuery(name = "Post.findByCreatedDate", query = "SELECT p FROM Post p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "Post.findByViews", query = "SELECT p FROM Post p WHERE p.views = :views"),
    @NamedQuery(name = "Post.findByLikes", query = "SELECT p FROM Post p WHERE p.likes = :likes")})
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "post_id")
    private Integer postId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "post_title")
    private String postTitle;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tags")
    private String tags;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "categories")
    private String categories;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "featuredimage")
    private String featuredimage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "owner")
    private String owner;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "views")
    private Integer views;
    @Column(name = "likes")
    private Integer likes;
    
    String encId;

    public String getEncId() {
        return encId;
    }

    public void setEncId(String encId) {
        this.encId = encId;
    }
    

    public Post() {
    }

    public Post(Integer postId) {
        this.postId = postId;
    }

    public Post(Integer postId, String postTitle, String description, String tags, String categories, String featuredimage, String owner, Date createdDate, Integer views, Integer likes) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.description = description;
        this.tags = tags;
        this.categories = categories;
        this.featuredimage = featuredimage;
        this.owner = owner;
        this.createdDate = createdDate;
        this.views = views;
        this.likes = likes;
    }
    public Post(Integer postId, String postTitle, String description, String tags, String categories) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.description = description;
        this.tags = tags;
        this.categories = categories;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getFeaturedimage() {
        return featuredimage;
    }

    public void setFeaturedimage(String featuredimage) {
        this.featuredimage = featuredimage;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postId != null ? postId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.postId == null && other.postId != null) || (this.postId != null && !this.postId.equals(other.postId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.urbannepal.entity.Post[ postId=" + postId + " ]";
    }
    
}
