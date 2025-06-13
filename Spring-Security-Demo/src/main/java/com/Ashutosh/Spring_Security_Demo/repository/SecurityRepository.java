package com.Ashutosh.Spring_Security_Demo.repository;

import com.Ashutosh.Spring_Security_Demo.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface SecurityRepository extends JpaRepository<UserDetails,Integer> {
    public UserDetails findByUserName(String userName);
    @Query("select id,userName,password from UserDetails")
    public UserDetails findAllUserDetails();
}
