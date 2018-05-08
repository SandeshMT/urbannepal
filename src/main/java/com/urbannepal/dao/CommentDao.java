/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.dao;

import com.urbannepal.entity.Comments;
import com.urbannepal.entity.Commentsfirstlevel;
import com.urbannepal.entity.Commentssecondlevel;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author myhp
 */
@Repository
public class CommentDao implements CommentDaoInterface{
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveComments(Comments c) {
        Session sess=sessionFactory.openSession();
        sess.save(c);
        sess.close();
    }

    @Override
    public List<Comments> displayCommentsByPostId(int postId) {
        Session sess = sessionFactory.openSession();
        Criteria cr = sess.createCriteria(Comments.class);
        cr.add(Restrictions.eq("postId", postId));
        List results = cr.list();
        sess.close();
        return results;
    }

    @Override
    public void saveFLComments(Commentsfirstlevel cfl) {
        Session sess=sessionFactory.openSession();
        sess.save(cfl);
        sess.close();
    }

    @Override
    public List<Commentsfirstlevel> displayFLComments(int comentId, int postId) {
        Session sess = sessionFactory.openSession();
        Criteria cr = sess.createCriteria(Commentsfirstlevel.class);
        cr.add(Restrictions.eq("postId", postId));
        cr.add(Restrictions.eq("commentId", comentId));
        List results = cr.list();
        sess.close();
        return results;
    }

    @Override
    public void saveSLComments(Commentssecondlevel csl) {
        Session sess = sessionFactory.openSession();
        sess.save(csl);
        sess.close();
    }

    @Override
    public List<Commentssecondlevel> displaySLComments(int postId,int comentId,int firstReplycommentId) {
        Session sess = sessionFactory.openSession();
        Criteria cr = sess.createCriteria(Commentssecondlevel.class);
        cr.add(Restrictions.eq("postId", postId));
        cr.add(Restrictions.eq("commentId", comentId));
        cr.add(Restrictions.eq("replyForFirstCommentId", firstReplycommentId));
        List results = cr.list();
        sess.close();
        return results;
    }
    
}
