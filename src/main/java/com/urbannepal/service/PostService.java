/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.service;

import com.urbannepal.dao.PostDao;
import com.urbannepal.entity.Post;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author myhp
 */
@Service
public class PostService implements PostServiceInterface{
    @Autowired
    PostDao postdao;

    public PostDao getPostdao() {
        return postdao;
    }

    public void setPostdao(PostDao postdao) {
        this.postdao = postdao;
    }

    @Transactional
    @Override
    public void addPost(Post p) {
        postdao.addPost(p);
    }

    @Transactional
    @Override
    public List<Post> displayPost() {
        return postdao.displayPost();
    }

    @Transactional
    @Override
    public void deletePost(int pid) {
        postdao.deletePost(pid);
    }

    @Transactional
    @Override
    public void updatePost(Post p) {
        postdao.updatePost(p);
    }

    @Transactional
    @Override
    public List<Post> displayPosById(int pid) {
        return postdao.displayPosById(pid);
    }

    @Transactional
    @Override
    public List<Post> displayTenLatestPost() {
        return postdao.displayTenLatestPost();
    }

    @Transactional
    @Override
    public List<Post> getPreviousPost(int postId) {
        return postdao.getPreviousPost(postId);
    }

    @Transactional
    @Override
    public List<Post> getNextPost(int postId) {
        return postdao.getNextPost(postId);
    }

    @Transactional
    @Override
    public List<Post> displayPostByCategory(String category) {
        return postdao.displayPostByCategory(category);
    }

    @Transactional
    @Override
    public void updateViews(int postId, int views) {
        postdao.updateViews(postId, views);
    }

    @Transactional
    @Override
    public List<Post> displayPostforSearch(String postTitle) {
        return postdao.displayPostforSearch(postTitle);
    }

    @Transactional
    @Override
    public List<Post> displayPopularPost() {
        return postdao.displayPopularPost();
    }

    @Transactional
    @Override
    public void updatePostImageOnly(int postId, String imgpath) {
        postdao.updatePostImageOnly(postId, imgpath);
    }
    
}
