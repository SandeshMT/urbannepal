/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.dao;

import com.urbannepal.entity.Post;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author myhp
 */
@Repository
public class PostDao implements PostDaoInterface {

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPost(Post p) {
        Session sess = sessionFactory.openSession();
        sess.save(p);
        sess.close();
    }

    @Override
    public List<Post> displayPost() {
        Session sess = sessionFactory.openSession();
        List<Post> p = sess.createCriteria(Post.class).list();
        sess.close();
        return p;
    }

    @Override
    public void deletePost(int pid) {
        Session sess=sessionFactory.openSession();
        Transaction t=sess.beginTransaction();
        Post p= (Post) sess.load(Post.class, pid);
        sess.delete(p);
        t.commit();
        sess.close();
    }

    @Override
    public void updatePost(Post p) {
        Session sess=sessionFactory.openSession();
        Query query=sess.createQuery("update Post p set p.postTitle=:postTitle, p.description=:description, p.tags=:tags, p.categories=:categories  where p.postId=:pid");
        query.setInteger("pid", p.getPostId());
        query.setString("postTitle", p.getPostTitle());
        query.setString("description", p.getDescription());
        query.setString("tags", p.getTags());
        query.setString("categories", p.getCategories());
        query.executeUpdate();
        sess.close();
    }

    @Override
    public List<Post> displayPosById(int pid) {
        Session sess = sessionFactory.openSession();
        Criteria cr = sess.createCriteria(Post.class);
        cr.add(Restrictions.eq("postId", pid));
        List results = cr.list();
        sess.close();
        return results;
    }

    @Override
    public List<Post> displayTenLatestPost() {
        Session sess = sessionFactory.openSession();
        Criteria cr = sess.createCriteria(Post.class);
        //code for getting max id
        cr.setProjection(Projections.max("postId"));
        Integer maxPostId = (Integer) cr.uniqueResult();
        int minPostId = maxPostId - 4;
        System.out.println("Maximum Post Id:" + maxPostId);

        //code for getting last ten posts details
        Criteria criteria = sess.createCriteria(Post.class);
        criteria.setFirstResult(minPostId);
        criteria.setMaxResults(maxPostId);
        List<Post> results = criteria.list();
        sess.close();
        return results;
    }

    @Override
    public List<Post> getPreviousPost(int postId) {
        Session sess = sessionFactory.openSession();
        Criteria cr = sess.createCriteria(Post.class);
        cr.add(Restrictions.eq("postId", postId));
        List results = cr.list();
        sess.close();
        return results;
    }

    @Override
    public List<Post> getNextPost(int postId) {
        Session sess = sessionFactory.openSession();
        Criteria cr = sess.createCriteria(Post.class);
        cr.add(Restrictions.eq("postId", postId));
        List results = cr.list();
        sess.close();
        return results;
    }

    @Override
    public List<Post> displayPostByCategory(String category) {
        Session sess = sessionFactory.openSession();
        //Query query=sess.createQuery("FROM Post where categories='"+category+"'");
        Criteria cr = sess.createCriteria(Post.class);
        cr.add(Restrictions.eq("categories", category));
        //List<Post> results = query.list();
        List<Post> results = cr.list();
        sess.close();
        return results;
    }

    @Override
    public void updateViews(int postId, int views) {
        Session sess=sessionFactory.openSession();
        Query query=sess.createQuery("update Post p set p.views=:views  where p.postId=:pid");
        query.setInteger("pid", postId);
        query.setInteger("views", views);
        query.executeUpdate();
        sess.close();
    }

    @Override
    public List<Post> displayPostforSearch(String postTitle) {
        Session sess = sessionFactory.openSession();
        Criteria cr = sess.createCriteria(Post.class);
        cr.add(Restrictions.like("postTitle", postTitle + "%"));
        List results = cr.list();
        sess.close();
        return results;
    }

    @Override
    public List<Post> displayPopularPost() {
        Session sess=sessionFactory.openSession();
        Query query=sess.createQuery("FROM Post p ORDER BY p.views DESC");
        List Results=query.setMaxResults(5).list();
        return Results;
    }

    @Override
    public void updatePostImageOnly(int postId, String imgpath) {
        Session sess=sessionFactory.openSession();
        Query query=sess.createQuery("update Post set featuredimage='"+imgpath+"'  where postId="+postId);
//        query.setInteger("pid", postId);
//        query.setString("featuredimage", imgpath);
        query.executeUpdate();
        sess.close();
    }

}
