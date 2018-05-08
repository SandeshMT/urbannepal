/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.service;

import com.urbannepal.entity.Comments;
import com.urbannepal.entity.Commentsfirstlevel;
import com.urbannepal.entity.Commentssecondlevel;
import java.util.List;

/**
 *
 * @author myhp
 */
public interface CommentServiceInterface {
    public void saveComments(Comments c);
    
    public List<Comments> displayCommentsByPostId(int postId);
    
    public void saveFLComments(Commentsfirstlevel cfl);
    
    public List<Commentsfirstlevel> displayFLComments(int comentId, int postId);
    
    public void saveSLComments(Commentssecondlevel csl);
    
    public List<Commentssecondlevel> displaySLComments(int postId,int comentId,int firstReplycommentId);    
}
