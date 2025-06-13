package com.Ashutosh.Spring_Security_Demo.service;

import com.Ashutosh.Spring_Security_Demo.model.UserDetails;
import com.Ashutosh.Spring_Security_Demo.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserDetails {

    @Autowired
    private SecurityRepository repo;

    public List<UserDetails> getUserDetail(){
        return repo.findAll();
    }




}
