/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.urbannepal.entity.Servicelist;
import com.urbannepal.entity.User;
import com.urbannepal.service.ServiceService;
import com.urbannepal.service.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author myhp
 */
@Controller
public class ServiceController {
    @Autowired
    ServiceService srvService;

    public ServiceService getSrvService() {
        return srvService;
    }

    public void setSrvService(ServiceService srvService) {
        this.srvService = srvService;
    }
    
    @Autowired
    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    
    //redirecting to adding services
    @RequestMapping(value = "/addservice", method = RequestMethod.GET)
    public ModelAndView addServices() {
        List<User> ulist=userService.displayUsers();
        return new ModelAndView("NewService","userList",ulist);
    }
    //end of redirecting to adding services
    
    
    //    begin of code for inserting service details
        @RequestMapping(value = "/newService", method = RequestMethod.POST)
    public ModelAndView addBooks(@RequestParam("serviceName") String serviceName,
            @RequestParam("price") int price,
            @RequestParam("serviceProvider") int serviceProvider
    ) {
            List<User> ul=userService.displayUserById(serviceProvider);
            int cid=0;
            for(User u: ul){
                cid=u.getContactId();
            }
            Servicelist sl=new Servicelist(0,serviceName,price,serviceProvider,cid);
            srvService.addService(sl);
            return new ModelAndView("redirect:addservice");
       
    }
//    end of code for inserting service details
    
    //begin of code for displaying services
    @RequestMapping(value = "/displayservices", method = RequestMethod.GET)
    public ModelAndView allServices() {
        List<Servicelist> sl=srvService.displayService();
        return new ModelAndView("AllServices","serviceDetails",sl);
    }
    //end of code for displaying services
    
    //begin of code for editing services detail
    @RequestMapping(value = "/editService", method = RequestMethod.GET)
    public String editServices(@RequestParam("esid") int esid,ModelMap model) {
        List<Servicelist> esl=srvService.displayServiceById(esid);
        List<User> ulist=userService.displayUsers();
        model.addAttribute("serviceDetail",esl);
        model.addAttribute("userList",ulist);
        return "EditServiceInfo";
    }
    //end of code for editing services detail
    
    //begin of code for updating services detail
    @RequestMapping(value = "/updateService", method = RequestMethod.POST)
    public ModelAndView updateServices(@RequestParam("serviceId") int serviceId,
                                       @RequestParam("serviceName") String serviceName,
                                       @RequestParam("price") int price,
                                       @RequestParam("serviceProvider") int serviceProvider) {
        List<User> ul=userService.displayUserById(serviceProvider);
            int cid=0;
            for(User u: ul){
                cid=u.getContactId();
            }
        Servicelist sl=new Servicelist(serviceId,serviceName,price,serviceProvider,cid);
        srvService.updateServiceInformation(sl);
        List<Servicelist> sls=srvService.displayService();
        return new ModelAndView("AllServices","serviceDetails",sls);
    }
    //end of code for updating services detail
    
    //begin of code for deleting services detail
    @RequestMapping(value = "/deleteService", method = RequestMethod.GET)
    public ModelAndView deleteServices(@RequestParam("dsid") int serviceId) {
        srvService.deleteService(serviceId);
        List<Servicelist> sls=srvService.displayService();
        return new ModelAndView("AllServices","serviceDetails",sls);
    }
    //end of code for deleting services detail
    
    //begin of code for displaying services name
    @RequestMapping(value = "/getServiceNames", method = RequestMethod.POST)
    public @ResponseBody void getServiceNames(HttpServletResponse response) throws IOException {
       List<Servicelist> sls=srvService.displayServiceName();
       Gson gson = new Gson(); 
            JsonElement element = gson.toJsonTree(sls, new TypeToken<List<Servicelist>>() {}.getType());
            com.google.gson.JsonArray jsonArray = element.getAsJsonArray();
            response.setContentType("application/json");
            response.getWriter().print(jsonArray);
    }
    //end of code for displaying services name
    
    //begin of code for storing new services order
    @RequestMapping(value = "/submitServiceOrder", method = RequestMethod.POST)
    public void newServiceOrder(@RequestParam("fullName") String fullName,
                                @RequestParam("locality") String locality,
                                @RequestParam("startDate") String startDate,
                                @RequestParam("endDate") String endDate,
                                @RequestParam("mobileNumber") String mobileNumber) {
        System.out.println(fullName+" "+locality+" "+startDate+" "+endDate+" "+mobileNumber);
    }
    //end of code for storing new services order
}
