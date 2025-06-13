package com.Ashutosh.Spring_Security_Demo.service;

import com.Ashutosh.Spring_Security_Demo.repository.SecurityRepository;
import com.Ashutosh.Spring_Security_Demo.model.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    public SecurityRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        com.Ashutosh.Spring_Security_Demo.model.UserDetails user = repo.findByUserName(username);
        if(user==null){
            System.out.println("User 404");
            throw new UsernameNotFoundException("user 404");
        }


        return new UserPrinciple(user);
    }


}
