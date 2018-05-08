/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.service;

import com.urbannepal.dao.CommentDao;
import com.urbannepal.entity.Comments;
import com.urbannepal.entity.Commentsfirstlevel;
import com.urbannepal.entity.Commentssecondlevel;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author myhp
 */
@Service
public class CommentService implements CommentServiceInterface{
    CommentDao cmtDao;

    public CommentDao getCmtDao() {
        return cmtDao;
    }

    public void setCmtDao(CommentDao cmtDao) {
        this.cmtDao = cmtDao;
    }

    @Transactional
    @Override
    public void saveComments(Comments c) {
        cmtDao.saveComments(c);
    }

    @Transactional
    @Override
    public List<Comments> displayCommentsByPostId(int postId) {
        return cmtDao.displayCommentsByPostId(postId);
    }

    @Override
    public void saveFLComments(Commentsfirstlevel cfl) {
        cmtDao.saveFLComments(cfl);
    }

    @Transactional
    @Override
    public List<Commentsfirstlevel> displayFLComments(int comentId, int postId) {
        return cmtDao.displayFLComments(comentId, postId);
    }

    @Transactional
    @Override
    public void saveSLComments(Commentssecondlevel csl) {
        cmtDao.saveSLComments(csl);
    }

    @Transactional
    @Override
    public List<Commentssecondlevel> displaySLComments(int postId,int comentId,int firstReplycommentId) {
        return cmtDao.displaySLComments(postId, comentId, firstReplycommentId);
    }
    
}
