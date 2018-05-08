/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.urbannepal.entity.Comments;
import com.urbannepal.entity.Commentsfirstlevel;
import com.urbannepal.entity.Commentssecondlevel;
import com.urbannepal.service.CommentService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author myhp
 */
@Controller
public class CommentController {
    @Autowired
    CommentService cmtService;

    public CommentService getCmtService() {
        return cmtService;
    }

    public void setCmtService(CommentService cmtService) {
        this.cmtService = cmtService;
    }
    
    //    begin of code for inserting comments details
        @RequestMapping(value = "/savemaincomment", method = RequestMethod.POST)
    public void saveComments(@RequestParam("comment") String comment,
            @RequestParam("postId") int postId
    ) {
        String commentBy="Suman"; //change after login
        Comments c=new Comments(0,commentBy,comment,postId);
        cmtService.saveComments(c);
       
    }
//    end of code for inserting comments details
    
    //    begin of code for inserting first reply for comments
        @RequestMapping(value = "/savefirstreplycomment", method = RequestMethod.POST)
    public void saveFirstReplyForComments(@RequestParam("commentId") int commentId,
            @RequestParam("postId") int postId,
            @RequestParam("firstRely") String firstReply
    ) {
        String commentBy="Shyam"; //change after login
        Commentsfirstlevel cfl=new Commentsfirstlevel(0,commentBy,firstReply,commentId,postId);
        cmtService.saveFLComments(cfl);
    }
//    end of code for inserting first reply for comments
    
    
    
    //    begin of code for displaying main comments
        @RequestMapping(value = "/displayMainComments", method = RequestMethod.POST)
    public void displayMainComments(@RequestParam("postId") int postId,HttpServletResponse response) throws IOException {
        List<Comments> lcmts= cmtService.displayCommentsByPostId(postId);
        Gson gson = new Gson(); 
            JsonElement element = gson.toJsonTree(lcmts, new TypeToken<List<Comments>>() {}.getType());
            com.google.gson.JsonArray jsonArray = element.getAsJsonArray();
            response.setContentType("application/json");
            response.getWriter().print(jsonArray);
    }
//    end of code for displaying main comments
    
    //    begin of code for displaying reply comments
        @RequestMapping(value = "/displayReplyComments", method = RequestMethod.POST)
    public void displayReplyComments(@RequestParam("postId") int postId,
            @RequestParam("cmtId") List<Integer> cid,
            HttpServletResponse response) throws IOException {
        int commentId=0;
            for(int a=0;a<cid.size();a++){
                commentId=cid.get(a);
                System.out.println("CommentIds:"+commentId);
            }
            List<Commentsfirstlevel> rcmts= cmtService.displayFLComments(commentId, postId);
            for(Commentsfirstlevel cfl: rcmts){
                System.out.println("Replies of comments"+cfl.getComment());
            }
            Gson gson = new Gson(); 
            JsonElement element = gson.toJsonTree(rcmts, new TypeToken<List<Commentsfirstlevel>>() {}.getType());
            com.google.gson.JsonArray jsonArray = element.getAsJsonArray();
            response.setContentType("application/json");
            response.getWriter().print(jsonArray);
    }
//    end of code for displaying  reply comments
    
}
