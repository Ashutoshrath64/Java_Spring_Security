package com.Ashutosh.Spring_Security_Demo;

import com.Ashutosh.Spring_Security_Demo.model.UserDetails;
import com.Ashutosh.Spring_Security_Demo.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailController {

    @Autowired
    public  UserDetails users;
    @Autowired
    public SecurityRepository repoSecurity;



    @GetMapping(path = "/saveUser")
    public UserDetails insertUser(){

        users.setId(1);
        users.setUserName("badmin");
        users.setPassword("System123#");

        repoSecurity.save(users);



        return users;




    }

    @PostMapping("saveUser")
    public UserDetails saveuserDetails(@RequestBody UserDetails user){
        repoSecurity.save(user);
        return user;

    }
}
