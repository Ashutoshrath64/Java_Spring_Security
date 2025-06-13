package com.Ashutosh.Spring_Security_Demo.service;


import com.Ashutosh.Spring_Security_Demo.model.UserDetails;
import com.Ashutosh.Spring_Security_Demo.repository.AddUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddUserDetailsService {

    @Autowired
    private AddUserRepository addUser;

    public void addUser(UserDetails user){
        addUser.save(user);
    }

}
