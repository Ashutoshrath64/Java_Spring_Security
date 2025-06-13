package com.Ashutosh.Spring_Security_Demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_DETAILS")
@Component
public class UserDetails {
    @Id
    @Column(name = "userId")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String userName;
    private  String password;
}
