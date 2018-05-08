/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.dao;

import com.urbannepal.entity.Post;
import java.util.List;

/**
 *
 * @author myhp
 */
public interface PostDaoInterface {
    public void addPost(Post p);

    public List<Post> displayPost();
    
    public List<Post> getPreviousPost(int postId);
    
    public List<Post> getNextPost(int postId);
    
    public List<Post> displayPostByCategory(String category);
    
    public List<Post> displayTenLatestPost();
    
    public List<Post> displayPosById(int pid);
    
    public List<Post> displayPostforSearch(String postTitle);

    public void deletePost(int pid);
    
    public void updatePost(Post p);
    
    public void updateViews(int postId, int views);
    
    public List<Post> displayPopularPost();
    
    public void updatePostImageOnly(int postId, String imgpath);
}
