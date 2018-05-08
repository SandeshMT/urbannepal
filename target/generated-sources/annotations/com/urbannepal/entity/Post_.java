package com.urbannepal.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-24T11:34:21")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, String> tags;
    public static volatile SingularAttribute<Post, String> encId;
    public static volatile SingularAttribute<Post, String> description;
    public static volatile SingularAttribute<Post, String> featuredimage;
    public static volatile SingularAttribute<Post, Integer> views;
    public static volatile SingularAttribute<Post, Integer> likes;
    public static volatile SingularAttribute<Post, String> owner;
    public static volatile SingularAttribute<Post, String> categories;
    public static volatile SingularAttribute<Post, String> postTitle;
    public static volatile SingularAttribute<Post, Date> createdDate;
    public static volatile SingularAttribute<Post, Integer> postId;

}