/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.urbannepal.entity.Categories;
import com.urbannepal.entity.Comments;
import com.urbannepal.entity.Commentsfirstlevel;
import com.urbannepal.entity.Commentssecondlevel;
import com.urbannepal.entity.Email;
import com.urbannepal.entity.Post;
import com.urbannepal.entity.Subscribers;
import com.urbannepal.service.CategoriesService;
import com.urbannepal.service.CommentService;
import com.urbannepal.service.EmailService;
import com.urbannepal.service.PostService;
import com.urbannepal.service.UserService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author myhp
 */
@Controller
public class PostController {
   @Autowired
   PostService postService;

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }
    
    @Autowired
    CategoriesService categoriesService;

    public CategoriesService getCategoriesService() {
        return categoriesService;
    }

    public void setCategoriesService(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }
    
    @Autowired
    EmailService emailService;

    public EmailService getEmailService() {
        return emailService;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
    
    @Autowired
    CommentService cmtService;

    public CommentService getCmtService() {
        return cmtService;
    }

    public void setCmtService(CommentService cmtService) {
        this.cmtService = cmtService;
    }
    
//    @Autowired
//    UserService userService;
//
//    public UserService getUserService() {
//        return userService;
//    }
//
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
    
    
    //redirecting to adding new post
    @RequestMapping(value = "/addpost", method = RequestMethod.GET)
    public ModelAndView newPost() {
        List<Categories> lcat=categoriesService.displayCategoryName();
        return new ModelAndView("NewPost","catnamelist",lcat);
    }
   
    @RequestMapping(method = RequestMethod.POST, value = "/TinyMCE")
    public @ResponseBody String uploadFile(@RequestParam("rr") CommonsMultipartFile file,HttpServletRequest request) throws FileNotFoundException, IOException {
       String filePath = request.getServletContext().getRealPath("/") + "/assets";
        // file.transferTo(new File(filePath + File.separator+file.getOriginalFilename()));
        System.out.println(request.getParameter("rr"));
       String filename = file.getOriginalFilename();
        filePath = filePath.replaceAll("\\\\", "/");

        System.out.println(filePath + "/" + filename);

        byte[] bytes = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                new File(filePath + File.separator + filename)));
        stream.write(bytes);
        stream.flush();
        stream.close(); 
        String path="assets/"+filename;
        System.out.println(path);        
        return path;       
 
    }
    
    private static final String UPLOAD_DIRECTORY="assets/images";
    @RequestMapping(value = "/savenewpost", method = RequestMethod.POST)
    public ModelAndView submitAddProduct(@RequestParam("posttitle") String posttitle,
            @RequestParam("postcontents") String postcontents,
            @RequestParam("posttags") String posttags,
            @RequestParam("postcategories") String postcategories,
            @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws FileNotFoundException, IOException {

        String filePath = request.getServletContext().getRealPath("/") + "/assets/images";
        // file.transferTo(new File(filePath + File.separator+file.getOriginalFilename()));
        System.out.println(filePath);
        String filename = file.getOriginalFilename();
        filePath = filePath.replaceAll("\\\\", "/");

        System.out.println(filePath + "/" + filename);

        byte[] bytes = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                new File(filePath + File.separator + filename)));
        stream.write(bytes);
        stream.flush();
        stream.close();
        String fullpath = UPLOAD_DIRECTORY + "/" + filename;
        String author="suman"; //get this value from logged in user
        long millis=System.currentTimeMillis();  
        java.sql.Date createddate=new java.sql.Date(millis);  
        Post pt=new Post(0,posttitle,postcontents,posttags,postcategories,fullpath,author,createddate,0,0);
        postService.addPost(pt);
        List<Categories> lcat=categoriesService.displayCategoryName();
        
        //code for updating email for newsletter
        String sub="Get In Touch With us";
        String content="";
        Email email=new Email(3,sub,postcontents,fullpath);
        emailService.updateEmailInformation(email);
        //end of code for updating email for newsletter
        //begin of code for sending first email to subscriber
        String subject="Subscriber";
        List<Email> subsemail= emailService.getEmailBySubject(subject);
        String conts="";
        String path="";
        for(Email e: subsemail){
            conts=e.getContent();
            path=e.getFeaturedImage();
        }
        
//        List<Subscribers> subs=userService.displaySubscribers();
//        String subscribers="";
//        for(Subscribers s: subs){
//            subscribers=s.getSubscriberEmail();
//        }
        
        //String to = "suman.thapa1605@gmail.com  ";//change accordingly  
        final String username = "nepbagz@gmail.com";//change accordingly  
        final String password = "nepbagz2016";//change accordingly 

        //getting properties object
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        //getting session object
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(username, password);
                    }
                });

        try {
            //compose message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(""));

            message.setSubject("HTML Message with attachment from database");

            //creating MimeBodyPart object and setting text message    
            BodyPart htmlcont = new MimeBodyPart();
            htmlcont.setText("Dear &nbsp;"+ email);
            //htmlcont.setContent("<h1>This is heading 1</h1><p>this is paragraph</p>","text/html");
            htmlcont.setContent(conts,"text/html");

            //creating new MimeBodyPart object and setting DataHandler object to this object      
            MimeBodyPart attachment = new MimeBodyPart();

            String attach = "C:/Users/myhp/Documents/NetBeansProjects/urbannepal/src/main/webapp/"+fullpath;//change accordingly  
            DataSource source = new FileDataSource(attach);
            attachment.setDataHandler(new DataHandler(source));
            attachment.setFileName(attach);

            //creating Multipart object and adding MimeBodyPart objects to this object      
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(htmlcont);
            multipart.addBodyPart(attachment);

            // setting the multiplart object to the message object  
            message.setContent(multipart);
        //message.setContent("<h1>sending html mail check</h1>","text/html" );  

            //sending message
            Transport.send(message);
            System.out.println("message sent....");
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        //end of code for sending first email to subscriber
        //return "Thank you for subscribing us.";
    
    //end of code for subscriber
        return new ModelAndView("NewPost","catnamelist",lcat);
    }
    
    
    //begin of links for Blogs
    //redirecting to Blogs Home
    @RequestMapping(value = "/BlogHome", method = RequestMethod.GET)
    public String blogsHome(ModelMap model) throws Exception {
        List<Post> pls=postService.displayPost();
//        String encIds;
//        for(Post p: pls){
//            encIds=encrypt(p.getPostId().toString());
//            System.out.println("Encrypted Ids:"+ encIds);
//            p.setEncId(encIds);
//        }
        List<Post> tpls=postService.displayTenLatestPost();
        List<Post> ppost=postService.displayPopularPost();
        model.addAttribute("postdetails", pls);
        model.addAttribute("latestpostdetails", tpls);
        model.addAttribute("popularpost", ppost);
        return "MainBlogPage";
    }
    //begin of code for encryption
//    private static final String ALGO="AES";
//    private static final byte[] keyValue= new byte[]{};
//    
//    private static Key generateKey() throws Exception{
//        Key key=new SecretKeySpec(keyValue,ALGO);
//        return key;
//    }
//    
//    public String encrypt(String Data) throws Exception{
//        Key key= generateKey();
//        Cipher c =Cipher.getInstance(ALGO);
//        c.init(Cipher.ENCRYPT_MODE, key);
//        byte[] encVal=c.doFinal(Data.getBytes());
//        String encryptedValue=new BASE64Encoder().encode(encVal);
//        return encryptedValue;
//    }
//    
//    public String decrypt(String encryptedData) throws Exception{
//        Key key= generateKey();
//        Cipher c =Cipher.getInstance(ALGO);
//        c.init(Cipher.DECRYPT_MODE, key);
//        byte[] decordedValue=new BASE64Decoder().decodeBuffer(encryptedData);
//        byte[] decValue=c.doFinal(decordedValue);
//        String decryptedValue=new String(decValue);
//        return decryptedValue;
//    }//end of code for encryption
    
    
    //redirecting to Single News Page
    @RequestMapping(value = "/SingleNews", method = RequestMethod.GET)
    public String singleBlogPage(@RequestParam("pid") int postId, ModelMap model) {
        
        List<Post> spls=postService.displayPosById(postId);
        String category="";
        for(Post p:spls){
            category=p.getCategories();
        }
        List<Post> relatedpost=postService.displayPostByCategory(category);
        List<Post> pls=postService.displayPost();
        List<Post> tpls=postService.displayTenLatestPost();
        int ppid=postId-1;
        List<Post> previouspost=postService.getPreviousPost(ppid);
        int npid=postId+1;
        List<Post> nextpost=postService.getNextPost(npid);
        List<Comments> mainComments=cmtService.displayCommentsByPostId(postId);
        int comentId=0;
        for(Comments cmt : mainComments){
            comentId= cmt.getCommentId();
        }
        List<Commentsfirstlevel> cfl= cmtService.displayFLComments(comentId, postId);
        
        List<Post> ppost=postService.displayPopularPost();
        
        model.addAttribute("singlepostdetails", spls);
        model.addAttribute("postdetails", pls);
        model.addAttribute("latestpostdetails", tpls);
        model.addAttribute("previouspostdetails", previouspost);
        model.addAttribute("nextpostdetails", nextpost);
        model.addAttribute("relatedpostdetails", relatedpost);
        model.addAttribute("maincomments", mainComments);
        model.addAttribute("replytofirstcomment", cfl);
        model.addAttribute("popularpost", ppost);
        
        return "SingleNewsPage";
    }
    //end of links for Blogs
    
    //begin of code for increasing views
    //redirecting to adding new post
    @RequestMapping(value = "/updateViews", method = RequestMethod.POST)
    public @ResponseBody String increaseViews(@RequestParam("postId") int postId,
            @RequestParam("views") int views) {
        int increasedView=views+1;
        postService.updateViews(postId,increasedView);
        return "Success";
    }
    //end of code for increasing views
    
    //begin of code for searching posts
    @RequestMapping(value = "/searchposts", method = RequestMethod.POST)
    public @ResponseBody void searchPosts(@RequestParam("searchvalue") String postTitle,HttpServletResponse response) throws IOException {
        System.out.println("Searching vaue is:"+postTitle);
        if(postTitle.equals("")){
            System.out.println("No Results");
        }else{
        List<Post> searchPost= postService.displayPostforSearch(postTitle);
        Gson gson = new Gson(); 
            JsonElement element = gson.toJsonTree(searchPost, new TypeToken<List<Post>>() {}.getType());
            com.google.gson.JsonArray jsonArray = element.getAsJsonArray();
            response.setContentType("application/json");
            response.getWriter().print(jsonArray);
        }
    }
    //end of code for searching posts
    
    //begin of links for displaying all Posts
    @RequestMapping(value = "/displayposts", method = RequestMethod.GET)
    public ModelAndView viewPosts() {
        List<Post> allPost=postService.displayPost();
        return new ModelAndView("AllPosts","allposts",allPost);
    }
    //end of links for displaying all post
    
    //begin of code for deleting posts
    @RequestMapping(value = "/deletePostInfo", method = RequestMethod.GET)
    public ModelAndView deletePost(@RequestParam("dpid") int postId) {
        postService.deletePost(postId);
        List<Post> allPost=postService.displayPost();
        return new ModelAndView("AllPosts","allposts",allPost);
    }
    //end of code for deleting posts
    
    //begin of code for displaying single posts details for update
    @RequestMapping(value = "/editPostInfo", method = RequestMethod.GET)
    public String getPostDtlsById(@RequestParam("epid") int postId, Model model) {  
        List<Categories> lcat=categoriesService.displayCategoryName();
        List<Post> singlePostDetails=postService.displayPosById(postId);
        model.addAttribute("postsdtls",singlePostDetails);
        model.addAttribute("catnamelist", lcat);
        return "EditPostInfo";
    }
    //end of code for displaying single posts detals for update
    
    //begin of code for updating post Image only
    @RequestMapping(value = "/updatepostimage", method = RequestMethod.POST)
    public @ResponseBody String updatePostImg(@RequestParam("postId") int postId,
            @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws FileNotFoundException, IOException {

        String filePath = request.getServletContext().getRealPath("/") + "/assets/images";
        // file.transferTo(new File(filePath + File.separator+file.getOriginalFilename()));
        System.out.println(filePath);
        String filename = file.getOriginalFilename();
        filePath = filePath.replaceAll("\\\\", "/");

        System.out.println(filePath + "/" + filename);

        byte[] bytes = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                new File(filePath + File.separator + filename)));
        stream.write(bytes);
        stream.flush();
        stream.close();
        String fullpath = UPLOAD_DIRECTORY + "/" + filename;
        postService.updatePostImageOnly(postId, fullpath);
        return "success";
    }
    //end of code for updating post Image only
    
    //begin of code for updating posts details
    @RequestMapping(value = "/updatePostInfo", method = RequestMethod.POST)
    public ModelAndView updatePostDetails(@RequestParam("postId") int postId,
            @RequestParam("postTitle") String postTitle,
            @RequestParam("contents") String contents,
            @RequestParam("tags") String tags,
            @RequestParam("categories") String categories) { 
        Post postUpdate=new Post(postId,postTitle,contents,tags,categories);
        postService.updatePost(postUpdate);
        List<Post> allPost=postService.displayPost();
        return new ModelAndView("AllPosts","allposts",allPost);
    }
    //end of code for updating posts detals
}
