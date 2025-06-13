package com.Ashutosh.Spring_Security_Demo.controller;

import com.Ashutosh.Spring_Security_Demo.model.UserDetails;
import com.Ashutosh.Spring_Security_Demo.service.AddUserDetailsService;
import com.Ashutosh.Spring_Security_Demo.service.GetUserDetails;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private AddUserDetailsService userAddition;
    @Autowired
    private GetUserDetails getUserDetails;

    @GetMapping(path = {"/","hello"})
    public String helloPage(HttpServletRequest request){
        return "Hello World session Id is : "+request.getSession().getId() ;
    }

    @GetMapping(path = "about")
    public String about(HttpServletRequest request){
        return "About session Id is : "+request.getSession().getId();
    }

    @PostMapping(path = "addUser",consumes = "application/json")
    public void addUser(@RequestBody UserDetails user){
        System.out.println("Calling add user");
        System.out.println("adding user "+user.toString());
        userAddition.addUser(user);
    }

    @GetMapping(path = "getUsersDetail")
    public List<UserDetails> getUser(){
        return getUserDetails.getUserDetail();

    }



}
