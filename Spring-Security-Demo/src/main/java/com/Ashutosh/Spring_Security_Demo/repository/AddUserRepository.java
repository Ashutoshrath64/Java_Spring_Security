package com.Ashutosh.Spring_Security_Demo.repository;

import com.Ashutosh.Spring_Security_Demo.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddUserRepository extends JpaRepository<UserDetails,Long> {
}
